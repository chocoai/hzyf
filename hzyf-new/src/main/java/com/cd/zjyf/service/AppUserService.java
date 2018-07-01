package com.cd.zjyf.service;

import com.cd.zjyf.bean.AppUser;
import com.cd.zjyf.bean.Areainfo;
import com.cd.zjyf.bean.YfappVersion;
import com.cd.zjyf.enums.ServiceRangeCode;
import com.cd.zjyf.exception.SystemException;
import com.cd.zjyf.exception.ValidateException;
import com.cd.zjyf.mapper.*;
import com.cd.zjyf.mapper.AppMapper;
import com.cd.zjyf.pojo.qc.UserQuerydataQC;
import com.cd.zjyf.pojo.qr.UserQueryDataQR;
import com.cd.zjyf.utils.CodeMessage;
import com.cd.zjyf.utils.CommonUtil;
import com.cd.zjyf.utils.FTPclient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class AppUserService {



	@Autowired
	private AppUserMapper appUserMapper;

	@Autowired
	private YfappVersionMapper yfappVersionMapper;
	
	@Autowired
	private AppMapper appMapper;


	@Autowired
	private  AreainfoMapper areainfoMapper;
	
	private static Logger log = LoggerFactory.getLogger(UserService.class);

	@Autowired
	private RedisTemplate<String, String> redisTemplate;


	@Autowired
	private FTPclient fTPclient;

	@Value("${FTP.RYZP_PATH}")
	private String RYZP_PATH;

	@Value("${FTP.NGINX_SERVER_ADDR}")
	private String NGINX_SERVER_ADDR;


	private final  static  String RYZP_SUFFIX=".jpg";


	/**
	 * 人员照片上传
	 * @param is
	 * @param id 用户id
	 */
	public Object uploadRYZP(String id,InputStream is) throws SystemException {
		String fileName=id+RYZP_SUFFIX;
		AppUser appUser = new AppUser();
		appUser.setId(id);
		appUser.setRyzp(NGINX_SERVER_ADDR+RYZP_PATH+fileName);
		try {
			appUserMapper.updateByPrimaryKeySelective(appUser);
			fTPclient.uploadFile(RYZP_PATH,fileName,is);
		} catch (Exception e) {
			throw new SystemException(e);
		}
		return null;
	}



	/**
	 * app版本检查
	 * 
	 * @param yfappVersion
	 * @return
	 */
	public YfappVersion selectCheckupdate(YfappVersion yfappVersion) {
		YfappVersion yfappVersionJO = yfappVersionMapper.selectByPrimaryKey(yfappVersion.getAppkey());
		if(yfappVersion.getByh().compareTo(yfappVersionJO.getByh())==0) {//版本号比数据库的小
			yfappVersionJO.setGxlx(ServiceRangeCode.NO_UPDATE.getCode());
		}
		return yfappVersionJO;
	}





	public Object chooseRYLZ(String rylz) {
		// TODO Auto-generated method stub
		return null;
	}




/*	*//**
	 * 如果没有查到该用户，则插入该用户
	 * 
	 * @param appUser
	 * @return
	 * @throws SystemException
	 *//*
	public AppUser relation(AppUser appUser) throws SystemException {
		AppUser appUserJo = appMapper.selectByPrimaryKeyHasYLJG(appUser.getId());
		try {
			if (appMapper.updateByPrimaryKeySelective(appUser) == 0) {
				appMapper.insertSelective(appUser);
			}
			if (appUserJo==null) {
				appMapper.insertSelective(appUser);
			}
		} catch (Exception be) {
			throw new SystemException();
		}
		return setToken(appUserJo);
	}*/


	/**
	 * 
	 * 第一次登陆判断
	 * @param appUser
	 * @return
	 * @throws SystemException
	 */
	public AppUser relation(AppUser appUser) throws SystemException, ValidateException {
		AppUser appUserJo = appMapper.selectByPrimaryKeyHasYLJG(appUser.getId());
		//当湖州市管理者登陆时候，进行行政区划转码
		if(appUserJo.getXzqh()!=null) {
			Areainfo areainfo = areainfoMapper.selectByPrimaryKey(appUserJo.translateXZQH().getXzqh());
			appUserJo.setXzqhfn(areainfo.getFullname());
		}
		//return setToken(appUserJo);
		return setToken(appUserJo.translateXZQH());
	}
	private AppUser setToken(AppUser appUser) throws ValidateException {
		List<String> avliableRole= Arrays.asList(ServiceRangeCode.YSZ.getCode(),
				ServiceRangeCode.YYGLY.getCode(),
				ServiceRangeCode.JDGLY.getCode(),
				ServiceRangeCode.YSGLY.getCode());


		if(ServiceRangeCode.OUT_GUARD.getCode().equals(appUser.getZgzt())){
			log.info("用户id：{}，该用户已被删除!",appUser.getId());
			throw new ValidateException("用户已被删除");
		}

		if(avliableRole.contains(appUser.getRylx())){
			log.info("用户id：{}，该角色类型不允许登陆!",appUser.getId());
			throw new ValidateException("该角色类型不允许登陆!");
		}

		//if(appUser==null) appUser=new AppUser();
		//过滤掉待审核用户
		if(ServiceRangeCode.DSH.getCode().equals(appUser.getIssh())){
			log.info("用户id：{}，用户正在审核中!",appUser.getId());
			throw new ValidateException("用户正在审核中!");
		}
		//过滤掉审核不通过的用户
		if(ServiceRangeCode.SHWTG.getCode().equals(appUser.getIssh())){
			log.info("用户id：{}，对不起，该用户审核未通过!!",appUser.getId());
			throw new ValidateException("对不起，该用户审核未通过!");
		}
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
				.getRequest();
		appUser.setAccess_token(request.getHeader("Authorization"));
		return appUser;
	}

	/**
	 * 角色验证
	 * @param tokenUser
	 * @param rylx
	 * @return
	 * @throws SystemException
	 * @throws ValidateException
	 */
	public AppUser rolecheck(AppUser tokenUser, String rylx) throws SystemException, ValidateException {
		if(!tokenUser.getRylx().equals(rylx)) {
			//角色类型不一致
			throw new ValidateException(CodeMessage.RYLX_ERROR);
		}

		return tokenUser;
	}
	
	/**
	 * 信息补全接口
	 * @param inputUser
	 * @return
	 * @throws SystemException
	 * @throws ValidateException
	 */

	public AppUser dataSupp(AppUser inputUser) throws SystemException, ValidateException {
		CommonUtil.basicValidate(inputUser);
		try {
			//如果是交接员申请，那么直接审核通过
			if(ServiceRangeCode.TGZ.getCode().equals(inputUser.getRylx())) {
				inputUser.setIssh(ServiceRangeCode.SHTG.getCode());
			}else{
				inputUser.setIssh(ServiceRangeCode.DSH.getCode());
			}
			appUserMapper.updateByPrimaryKeySelective(inputUser);
			//过滤掉待审核用户
//			if(ServiceRangeCode.DSH.getCode().equals(inputUser.getIssh())){
//				throw new ValidateException("用户正在审核中。。。");
//			}
		} catch (Exception be) {
			throw new SystemException(be.getMessage());
		}
		return inputUser;
	}
	
	/**
	 * 用户待补全数据查询
	 * @param qc
	 * @return
	 */
	public List<UserQueryDataQR> querydata(UserQuerydataQC qc) {
		return appMapper.selectUserQuerydata(qc);
		//return getTestData();
	}
	
	
	private List<UserQueryDataQR>  getTestData() {
		ArrayList<UserQueryDataQR> list = new ArrayList<UserQueryDataQR>();
		for(int i=0;i<2000;i++) {
			list.add(new UserQueryDataQR(""+i,i+"XX医院"));
		}
		return list;
	}

    public Object reviceGPS(String id, String lng, String lat) {
		String coordinate=lng+","+lat;
		//5分钟缓存，前端定时请求5分钟
		//redisTemplate.boundValueOps(id).set(coordinate,60*5, TimeUnit.SECONDS);
		redisTemplate.boundValueOps(id).set(coordinate,60*5, TimeUnit.SECONDS);
		return null;
    }
    //是否第一次登陆接口
	
	
	//如果没有查到该用户，则表示第一次登陆本平台，则返回一个判断标志
	//如果查到该用户，则返回用户信息，
	
	
}
