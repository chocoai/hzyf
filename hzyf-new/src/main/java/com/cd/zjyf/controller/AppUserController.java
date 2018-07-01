package com.cd.zjyf.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cd.zjyf.base.controller.BaseController;
import com.cd.zjyf.base.controller.ServiceHandlerAdapter;
import com.cd.zjyf.bean.AppUser;
import com.cd.zjyf.bean.YfappVersion;
import com.cd.zjyf.exception.SystemException;
import com.cd.zjyf.exception.ValidateException;
import com.cd.zjyf.pojo.Response;
import com.cd.zjyf.pojo.qc.UserQuerydataQC;
import com.cd.zjyf.service.AppUserService;
import com.cd.zjyf.utils.CodeMessage;
import com.cd.zjyf.utils.CommonUtil;
import com.cd.zjyf.utils.FTPclient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.security.Principal;
import java.util.Map;


@RestController
@RequestMapping("/user")
public class AppUserController extends BaseController {
	
	
	@Autowired
	private AppUserService appUserService;
	//@Autowired
	//private UAPService uAPService;//平台uap代理服务
	@Autowired
	private FTPclient fTPclient;
	
	
	private static Logger log = LoggerFactory.getLogger(UserController.class);

	
	/**
	 * 用户登陆，关联相关信息
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET,value="/login")
	public Response login() {
		log.info("======================>>用户登陆操作<<======================");
		Map<String, Object> userInfo=null;
		try {
			userInfo = CommonUtil.getAppUserInfo();
		} catch (Exception e) {
			log.error("usernameService",e);
		}
		  AppUser appUser = praseAppUser(userInfo);
		return super.genericSaveOrUpdate(new ServiceHandlerAdapter() {
			@Override
			public Object serviceSaveOrUpdateOperate(Object o) throws SystemException, ValidateException {
				return appUserService.relation(appUser);
			}
		}, appUser);
		
	}



	@GetMapping(value="/rolecheck")
	public Response rolecheck(Principal principal, @RequestParam String rylx) {
		log.info("======================>>用户第一次校色选择校验<<======================");
		Map<String, Object> userInfo=null;
		try {
			userInfo = CommonUtil.getAppUserInfo();
		} catch (Exception e) {
			log.error("usernameService",e);
		}
		  AppUser tokenUser = praseAppUser(userInfo);
		  return super.queryHasException(new ServiceHandlerAdapter() {
			@Override
			public Object serviceQueryOperateHasExcpetoin() throws SystemException, ValidateException {
				return appUserService.rolecheck(tokenUser,rylx);
			}
		});
		
	}
	
	@GetMapping(value="/querydata")
	public Response querydata(UserQuerydataQC qc) {
		log.info("======================>>用户第一次登陆，待补全资料查询<<======================");
		return super.query(new ServiceHandlerAdapter() {
			@Override
			public Object serviceQueryOperate() {
				return appUserService.querydata(qc);
			}
		});
	}
	
	
	
	//第一次登陆的资料填充接口，包括人员类型选择，其它一些资料填充
	@PostMapping(value="/datasupp")
	public Response dataSupplement(@RequestBody AppUser inputUser) {
		log.info("======================>>用户第一次登陆资料填充<<======================");
		return super.genericSaveOrUpdate(new ServiceHandlerAdapter() {
			@Override
			public Object serviceSaveOrUpdateOperate() throws SystemException, ValidateException {
				return appUserService.dataSupp(inputUser);
			}
		});
		
	}
	
	
	@RequestMapping(method = RequestMethod.GET,value="/checkupdate")
	public Response selectCheckupdate(YfappVersion yfappVersion) {
		log.info("查询APP版本更新");
		return super.query(new ServiceHandlerAdapter() {
			@Override
			public Object serviceQueryOperate(Object o) {
				return appUserService.selectCheckupdate(yfappVersion);
			}
		}, yfappVersion);
		
	}
	
/*	*//**
	 * 上传人员照片
	 * 
	 * @param file	上传文件
	 * @return	
	 *
	 */
	@RequestMapping(value="/uploadRYZP",method = RequestMethod.POST)
	@ResponseBody
	public Response fileUpload(@RequestParam("file") MultipartFile uploadFile, @RequestParam(value="id")String id) throws IOException {
		log.info("上传人员照片");
		InputStream inputStream = uploadFile.getInputStream();
		return 	genericSaveOrUpdate(new ServiceHandlerAdapter() {
			@Override
			public Object serviceSaveOrUpdateOperate() throws SystemException {
				 return appUserService.uploadRYZP(id,inputStream);
			}
		});
	  }
	
	

	
	/**
	 *跟新/下载apk
	 * 
	 * @param 	新增项的信息
	 * @return	
	 * @throws IOException 
	 */

	@RequestMapping(value = {"/download"},method = RequestMethod.GET)
	@Deprecated
	public Response downloadAPP(HttpServletResponse response,@RequestParam(value="gxdz")String gxdz)  {
		log.info("======================>>用户更新app<<======================");
		Response result = null;
		ServletOutputStream outputStream=null;
		response.addHeader("Content-Disposition","attachment; filename="+getAPPFileName(gxdz));
		response.setContentType("application/vnd.android.package-archive");
		//response.setHeader("Content-Length ",String.valueOf(fTPclient.getFileSize(gxdz)));
		response.setContentLengthLong(fTPclient.getFileSize(gxdz));
		//response.setHeader("filesize",fTPclient.getFileSize(gxdz) + "");
		try {
			outputStream = response.getOutputStream();
			fTPclient.downloadFiles(gxdz, outputStream);
		} catch (IOException e) {
			result = new Response();
			result.setStatus(CodeMessage.STATUS_SUCCESS);
			result.setError(CodeMessage.DOWNLOAD_ERROR);
			log.error("downloadAPP",e);
		}
		return result;
	}
	

	
	
	private static String getAPPFileName(String gxdz) {
		return gxdz.split("/")[gxdz.split("/").length-1];
	}



	

	
	/**
	 * 
	 * @param str
	 * @return
	 */
	private AppUser praseAppUserTemp(String str) {
		AppUser appUser = new AppUser();
		appUser.setId(str);
		return appUser;
	}

	//{"phoneNumber":"13511112222"%"roles":["4"%"1"]%"nickname":"李四"%"username":"lisi"}

	private AppUser praseAppUser(Map<String, Object> userInfo) {
		String id = (String) userInfo.get("id");
		String  rylx=(String) userInfo.get("rylx");
		AppUser appUser=new AppUser();
		appUser.setId(id);
		appUser.setRylx(rylx);
		return appUser;
	}
	
	

	/**
	 * 
	 * @param str
	 * @return
	 */
	private AppUser praseAppUser(String str) {
		JSONObject jo = JSON.parseObject(str);
		if(jo==null) return null;
		AppUser appUser=new AppUser();
		appUser.setId((String)jo.get(""));
		appUser.setRylx((String)jo.get(""));
		return appUser;
	}

	
	@RequestMapping(method = RequestMethod.PUT,value="/choose")
	@Deprecated
	public Response chooseRYLZ(String rylz) {
		log.info("第一次登陆使用，选择人员类型");
		return super.query(new ServiceHandlerAdapter() {
			@Override
			public Object serviceQueryOperate(Object o) {
				return appUserService.chooseRYLZ(rylz);
			}
		}, rylz);

	}

	/**
	 * 获取用户gps
	 * @param id
	 * @param lng 经度
	 * @param lat 纬度
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET,value="/gps")
	public Response reviceGPS(@RequestParam(required = true) String id,@RequestParam(required = true) String lng,@RequestParam(required = true) String lat) {
		log.info("获取用户{}的gps坐标定位经度：{}，纬度：{},坐标：{}",id,lng,lat,lat+","+lng);
		return genericSaveOrUpdate(new ServiceHandlerAdapter() {
			@Override
			public Object serviceSaveOrUpdateOperate() {
				return appUserService.reviceGPS(id,lng,lat);
			}
		});

	}




}










