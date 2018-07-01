package com.cd.zjyf.service;

import com.alibaba.fastjson.JSONObject;
import com.cd.zjyf.annotation.ClearReidsCache;
import com.cd.zjyf.annotation.Paging;
import com.cd.zjyf.annotation.ReidsCache;
import com.cd.zjyf.bean.*;
import com.cd.zjyf.component.StringOfYearQuery;
import com.cd.zjyf.enums.ServiceRangeCode;
import com.cd.zjyf.exception.SystemException;
import com.cd.zjyf.exception.ValidateException;
import com.cd.zjyf.mapper.*;

import com.cd.zjyf.pojo.AreaTree;
import com.cd.zjyf.pojo.Dropdown;
import com.cd.zjyf.pojo.PageBean;
import com.cd.zjyf.pojo.qc.*;
import com.cd.zjyf.pojo.qr.*;
import com.cd.zjyf.proxy.monitor.Openapi;
import com.cd.zjyf.utils.CommonUtil;
import com.cd.zjyf.utils.FTPclient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import static com.cd.zjyf.utils.CommonUtil.*;
import static java.util.stream.Collectors.toList;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.time.LocalDate;
import java.util.*;

@Service
public class ProjectService {

	@Autowired
	private AppMapper appMapper;

	@Autowired
	private YlwsJbxxMapper ylwsJbxxMapper;
	
	@Autowired
	private YlfwJsdjMapper ylfwJsdjMapper;
	
	@Autowired
	private JgdwJbxxMapper JgdwJbxxMapper;
	
	@Autowired
	private AreainfoMapper areainfoMapper;

	@Autowired
	private ProjectMapper projectMapper;

	@Autowired
	private AppUserMapper appUserMapper;

	@Autowired
	private TblYlwsDlxxMapper tblYlwsDlxxMapper;


	@Autowired
	private HkdeviceMapper hkdeviceMapper;

	@Autowired
	private YlwsFileMapper ylwsFileMapper;

	@Autowired
	private YlwsUploadMapper ylwsUploadMapper;

	@Value("${BAIDU_API.COORDINATE_URL}")
	private String url;

	@Value("${BAIDU_API.AK}")
	private String ak;

	@Autowired
	private FTPclient fTPclient;

	@Value("${FTP.SEWAGE_PATH}")
	private String SEWAGE_PATH;

	@Value("${FTP.NGINX_SERVER_ADDR}")
	private String NGINX_SERVER_ADDR;


	@Autowired
	private StringOfYearQuery stringOfYearQuery;

	private final  static  String PDF_SUFFIX=".jpg";


	//湖州卫生监督所应急指挥uuid
	private final  static String JDS="a9c7437f25d741e185c5e9d3169e37d3";


	private static Logger log = LoggerFactory.getLogger(ProjectService.class);

	/**
	 * 污水监测批量文件上传
	 * @param id upload表主键
	 * @param multipartFile
	 * @param filename（由于考虑到multipartFile取得的文件名可能存在乱码的问题，所以这里又前端直接传值过来）
	 * @return
	 * @throws SystemException
	 */
	public Object uploadSewage(String id,MultipartFile[] multipartFile,String[] filename) throws SystemException {

		//先删除原来上传的数据
		YlwsFileExample ylwsFileExample = new YlwsFileExample();
		ylwsFileExample.createCriteria().andUploadidEqualTo(id);
		ylwsFileMapper.deleteByExample(ylwsFileExample);
		String fileDir=id+"/";//文件夹名以id命名确保唯一性
		int index=0;
		for(MultipartFile multipartFile1:multipartFile){

/*			String fileName=multipartFile1.getOriginalFilename();
			try {
				fileName = new String(fileName.getBytes(), "UTF-8");
			} catch (UnsupportedEncodingException e) {
				throw new SystemException();
			}*/

			String originalFilename = multipartFile1.getOriginalFilename();

			String fileName=filename[index];

			String ftpPath=SEWAGE_PATH+fileDir;
				String ngixnPath=NGINX_SERVER_ADDR+SEWAGE_PATH+fileDir+fileName;
				YlwsFile ylwsFile = new YlwsFile();
				ylwsFile.setPath(ngixnPath);
				ylwsFile.setUploadid(id);
				try {
					ylwsFileMapper.insertSelective(ylwsFile);
					fTPclient.uploadFilebyRename(ftpPath,fileName,multipartFile1.getInputStream());
				} catch (IOException e) {
					throw new SystemException();
				}
				index++;
		}
		//更新YlwsUpload表
		YlwsUpload ylwsUpload = new YlwsUpload();
		ylwsUpload.setId(id);
		ylwsUpload.setCreateTime(new Date());
		Map<String, Object> appUserInfo = null;
		try {
			appUserInfo = CommonUtil.getAppUserInfo();
		} catch (Exception e) {
			throw new SystemException();
		}
		String userid=appUserInfo!=null? (String) appUserInfo.get("id") :null;
		ylwsUpload.setUserid(userid);
		ylwsUpload.setState(ServiceRangeCode.SCZT_Y.getCode());
		ylwsUploadMapper.updateByPrimaryKeySelective(ylwsUpload);
		return null;
	}

	public PageBean<SewageQR> querySewage(SewageQC qc) {
		List<SewageQR> sewageQRS = projectMapper.querySewage(qc);
		return getPageBean(getListRangValue(sewageQRS));
	}


	public PageBean<SewageQR> querySewageInfo(SewageQC qc) {
		List<SewageQR> sewageQRS = projectMapper.querySewageInfo(qc);
		sewageQRS.stream().forEach(sewageQR -> {
			YlwsFileExample ylwsFileExample = new YlwsFileExample();
			ylwsFileExample.createCriteria().andUploadidEqualTo(sewageQR.getId());
			List<YlwsFile> ylwsFiles = ylwsFileMapper.selectByExample(ylwsFileExample);
			sewageQR.setPaths(ylwsFiles.stream().map(YlwsFile::getPath).collect(toList()));
		});
		return getPageBean(getListRangValue(sewageQRS));
	}

	/**
	 * 海康视频接口
	 * @throws Exception
	 */
	public List<JSONObject> getRegionsByUnitUuid()  {
		JSONObject jsonObject = JSONObject.parseObject(Openapi.getRegionsByUnitUuid());
		JSONObject data =  jsonObject.getJSONObject("data");

		List<JSONObject> all = (List<JSONObject>) data.get("list");
		List<JSONObject> parentNodeType = all.stream().filter(j -> j.getInteger("parentNodeType")==1&&!j.getString("regionUuid").equals(JDS)).collect(toList());
		parentNodeType.stream().forEach(p->p.put("zcd",all.stream().filter(a->a.getString("parentUuid").equals(p.getString("regionUuid"))).collect(toList())));

		return parentNodeType;

	}


	/**
	 *保存或者更新海康设备表业务逻辑
	 * @param ylwsJbxx
	 * @param update 更新标志
	 */
	private void saveOrHkdeviceUpdate(YlwsJbxx ylwsJbxx,boolean update){
				HkdeviceExample example=new HkdeviceExample();
				example.createCriteria().andYljgidEqualTo(ylwsJbxx.getId());
			if(ServiceRangeCode.HAS_MONITOR.getCode().equals(ylwsJbxx.getIsMonitor())){
				Hkdevice hkdevice = new Hkdevice();
				hkdevice.setYljgid(ylwsJbxx.getId());
				hkdevice.setIndexcode(ylwsJbxx.getRegionUuid());
				hkdevice.setParentUuid(ylwsJbxx.getParentUuid());

				List<Hkdevice> hkdevices = hkdeviceMapper.selectByExample(example);
				if(hkdevices.size()>0){
					hkdevice.setId(hkdevices.get(0).getId());
					hkdeviceMapper.updateByPrimaryKey(hkdevice);
					log.info("医疗机构：{}，修改海康监控成功！",ylwsJbxx.getDwmc());
				}else {
					hkdeviceMapper.insert(hkdevice);
					log.info("医疗机构：{}，新增海康监控成功！",ylwsJbxx.getDwmc());
				}
			}else {
				if(update) {
					int i = hkdeviceMapper.deleteByExample(example);
					if (i > 0) {
						log.info("医疗机构：{}，删除海康监控成功！", ylwsJbxx.getDwmc());
					}
				}
			}
	}

	/**
	 * 医疗机构新增
	 * @param ylwsJbxx
	 */
	@Transactional(rollbackFor=Exception.class)
	@ClearReidsCache
	public String addYLJG(YlwsJbxx ylwsJbxx) throws SystemException, ValidateException {
		basicValidate(ylwsJbxx);
		try{
		ylwsJbxxMapper.insertSelective(ylwsJbxx);
		//插入地理信息表
		TblYlwsDlxx dlxx = getDLXX(ylwsJbxx.getDwdz());
		dlxx.setFkid(ylwsJbxx.getId());
		tblYlwsDlxxMapper.insert(dlxx);
		//海康监控
		saveOrHkdeviceUpdate(ylwsJbxx,false);
		//污水监测
		if(ServiceRangeCode.SEWAGE_Y.getCode().equals(ylwsJbxx.getIsSewage())){
			YlwsUpload ylwsUpload = new YlwsUpload();
			ylwsUpload.setYljgid(ylwsJbxx.getId());
			ylwsUpload.setYear(String.valueOf(LocalDate.now().getYear()));
			ylwsUpload.setQuarter(LocalDate.now().query(stringOfYearQuery));
			ylwsUploadMapper.insertSelective(ylwsUpload);
		}
		}catch (Exception e){
			throw new SystemException(e.getMessage());
		}
		return null;
	}


	/**
	 * 通过单位具体地址获取单位坐标
	 * @param dwdz
	 */
	private TblYlwsDlxx getDLXX(String dwdz) throws ValidateException {
			RestTemplate restTemplate = new RestTemplate();
			String forObject = restTemplate.getForObject(url+"?output=json&&address="+dwdz+"号&&ak="+ak, String.class);
			log.debug("通过单位具体地址获取单位坐标json:"+forObject);
			JSONObject jsonObject = JSONObject.parseObject(forObject);
			if(!jsonObject.get("status").equals(0)){
				throw  new ValidateException("单位地址不准确，无法获取经纬度！");
			}
			JSONObject result = (JSONObject) jsonObject.get("result");
			JSONObject location = (JSONObject) result.get("location");
			TblYlwsDlxx tblYlwsDlxx = new TblYlwsDlxx();
		String lng = String.valueOf(location.get("lng"));
		String lat = String.valueOf( location.get("lat"));
		tblYlwsDlxx.setLongitude(lng);
		tblYlwsDlxx.setLatitude(lat);
		return tblYlwsDlxx;
	}




	/**
	 * 医疗机构修改
	 * @param ylwsJbxx
	 */
	@Transactional(rollbackFor=Exception.class)
	@ClearReidsCache
	public String updateYLJG(YlwsJbxx ylwsJbxx) throws ValidateException, SystemException {
		basicValidate(ylwsJbxx);
		try{
			YlwsJbxx ylwsJbxx1 = ylwsJbxxMapper.selectByPrimaryKey(ylwsJbxx.getId());
			//级联修改经纬度表（有点问题，没有ID）
			if(!ylwsJbxx1.getDwdz().equals(ylwsJbxx.equals(ylwsJbxx.getDwdz()))){
				TblYlwsDlxx dlxx = getDLXX(ylwsJbxx.getDwdz());
				TblYlwsDlxxExample example = new TblYlwsDlxxExample();
				example.createCriteria().andFkidEqualTo(ylwsJbxx.getId());
				List<TblYlwsDlxx> tblYlwsDlxxes = tblYlwsDlxxMapper.selectByExample(example);
				//如果没有该机构的地理信息，那么插入地理信息
				if(tblYlwsDlxxes.size()==0){
					dlxx.setFkid(ylwsJbxx.getId());
					tblYlwsDlxxMapper.insert(dlxx);
				}else{
					tblYlwsDlxxMapper.updateByExampleSelective(dlxx,example);
				}
			}
			ylwsJbxxMapper.updateByPrimaryKeySelective(ylwsJbxx);
			saveOrHkdeviceUpdate(ylwsJbxx,true);

			//污水监测
			if(ServiceRangeCode.SEWAGE_Y.getCode().equals(ylwsJbxx.getIsSewage())){
				YlwsUpload ylwsUpload = new YlwsUpload();
				ylwsUpload.setYljgid(ylwsJbxx.getId());
				ylwsUpload.setYear(String.valueOf(LocalDate.now().getYear()));
				ylwsUpload.setQuarter(LocalDate.now().query(stringOfYearQuery));
				//保证年季度份唯一
				YlwsUploadExample ylwsUploadExample = new YlwsUploadExample();
				ylwsUploadExample.createCriteria().andYearEqualTo(ylwsUpload.getYear()).andQuarterEqualTo(ylwsUpload.getQuarter())
						.andYljgidEqualTo(ylwsUpload.getYljgid());
				List<YlwsUpload> ylwsUploads = ylwsUploadMapper.selectByExample(ylwsUploadExample);
				if(ylwsUploads.size()==0){
					ylwsUploadMapper.insertSelective(ylwsUpload);
				}
			}

		}catch (Exception e){
			throw new SystemException(e.getMessage());
		}
		return null;
	}

	/**
	 * 医疗机构删除(做级联删除，删除该医疗机构下的用户，如果是暂存点，那么删除该科室和诊所)
	 * @param id
	 */
	@ClearReidsCache
	@Transactional(rollbackFor=Exception.class)
	public String deleteYLJG(String id) throws  SystemException {
		try{
			projectMapper.logicDeleteYljg(id);
			//删除绑定医疗机构的用户
			projectMapper.logicDeleteUserByYLJGID(id);
		}catch (Exception e){
			throw new SystemException(e);
		}
		return null;
	}
/*	@ClearReidsCache
	@Transactional(rollbackFor=Exception.class)
	public String deleteYLJG(String id) throws  SystemException {
		try{
			YlwsJbxx ylwsJbxx = ylwsJbxxMapper.selectByPrimaryKey(id);
			ylwsJbxxMapper.deleteByPrimaryKey(id);
			//删除暂存点下的产生点
			YlwsJbxxExample example=new YlwsJbxxExample();
			example.createCriteria().andZcdidEqualTo(ylwsJbxx.getId());
			ylwsJbxxMapper.deleteByExample(example);
			//删除绑定医疗机构的用户
			projectMapper.deleteUserByYLJGID(id);
		}catch (Exception e){
			throw new SystemException(e);
		}
		return null;
	}*/


	/**
	 * 医疗机构查看详情
	 * @param id
	 * @return
	 */
	public YlwsJbxx queryYLJG(String id){
		YlwsJbxx ylwsJbxx = ylwsJbxxMapper.selectByPrimaryKey(id);
		//海康设备相关信息
		HkdeviceExample example=new HkdeviceExample();
		example.createCriteria().andYljgidEqualTo(ylwsJbxx.getId());
		List<Hkdevice> hkdevices = hkdeviceMapper.selectByExample(example);
		if(hkdevices.size()>0){
			Hkdevice hkdevice = hkdevices.get(0);
			ylwsJbxx.setRegionUuid(hkdevice.getIndexcode());
			ylwsJbxx.setParentUuid(hkdevice.getParentUuid());
			ylwsJbxx.setIsMonitor(ServiceRangeCode.HAS_MONITOR.getCode());
		}else{
			ylwsJbxx.setIsMonitor(ServiceRangeCode.NO_MONITOR.getCode());
		}
		return ylwsJbxx;
	}

	/**
	 * 医疗机构条件查询
	 * @param ylwsJbxxQC
	 * @return
	 */
	//@ReidsCache
	public PageBean<YlwsJbxxQR> cqueryYLJG(YlwsJbxxQC ylwsJbxxQC){
		return getPageBean(getListRangValue(projectMapper.cqueryYLJG(ylwsJbxxQC)));
	}

/****************人员******************************//*
d
	*/
/**
	 * 人员新增
	 * @param AppUser
	 *//*

	public String addRY(AppUser AppUser) throws SystemException, ValidateException {
		basicValidate(AppUser);
		try{
			appUserMapper.insertSelective(AppUser);
		}catch (Exception e){
			throw new SystemException(e);
		}
		return null;
	}

	*/
/**
	 * 人员修改
	 * @param AppUser
	 *//*

	public String (AppUser AppUser) throws ValidateException, SystemException {
		basicValidate(AppUser);
		try{
			appUserMapper.updateByPrimaryKeySelective(AppUser);
		}catch (Exception e){
			throw new SystemException(e);
		}
		return null;
	}

	*/
/**
	 * 人员删除
	 * @param AppUser
	 *//*

	public String deleteRY(String id) throws  SystemException {
		try{
			appUserMapper.deleteByPrimaryKey(id);
		}catch (Exception e){
			throw new SystemException(e);
		}
		return null;
	}

	*/
/**
	 * 人员查看详情
	 * @param id
	 * @return
	 *//*

	public AppUser queryRY(String id){
		return appUserMapper.selectByPrimaryKey(id);
	}

	*/
/**
	 * 人员条件查询
	 * @param AppUser
	 * @return
	 *//*

	public PageBean<AppUser> cqueryRY(AppUserQC appUserQC){
		return getPageBean(projectMapper.cqueryRY(appUserQC));
	}

*/


	/**
	 * 接收明细情况
	 * @param qc
	 * @return
	 */
	@ReidsCache
	public PageBean<JSMXQR> queryJSMX(JSMX qc){
		return getPageBean(projectMapper.queryJSMX(qc));
	}

	/**
	 * 接收同比
	 * @param qc
	 * @return
	 */
	@ReidsCache
	@Deprecated
	public List<JSTBQR> queryJSTB(JSTB qc){
		return projectMapper.queryJSTB(qc);
	}

	/**
	 * 接收同比
	 * @param qc
	 * @return
	 */
	@ReidsCache
	public List<JSTBNQR> queryJSTBN(JSTB qc){
			qc.setXzqhLevel(CommonUtil.getLevelByRegionCode(qc.getXzqh()));
			return projectMapper.queryJSTBN(qc);
	}


	/**
	 * 接收环比
	 * @param qc
	 * @return
	 */
	@ReidsCache
	public List<JSHBQR> queryJSHB(JSHB qc){
		qc.translate();
		//市级
		if(CommonUtil.getLevelByRegionCode(qc.getXzqh())==2){
			return projectMapper.queryJSHB(qc);
		}

		return projectMapper.queryJSHBZCD(qc);
	}


	/**
	 * 管理员查看的接收明细
	 * @param qc
	 * @return
	 */
	@ReidsCache
	//@Paging(total = false)
	public PageBean<JSQKQR> queryJSQK(JSQK qc){
		return getPageBean(getListRangValue(projectMapper.queryJSQK(qc)));
	}


	/**
	 * 产生点送达率汇总表
	 * @param qc
	 * @return
	 */
	@Deprecated
	public PageBean<SDLQR> querySDL(SDL qc){
		return getPageBean(projectMapper.querySDL(qc));
	}


	/**
	 *医疗机构管理新增/修改——暂存点下拉
	 * @param userxzqh
	 * @return
	 */
	public List<Dropdown> zcdDropdown(String userxzqh){
			return projectMapper.zcdDropdown(userxzqh);
		}

	/**
	 *医疗机构，接收明细，接收情况条件查询——暂存点下拉
	 * @param userxzqh
	 * @return
	 */
	public List<Dropdown> zcdDropdown1(String userxzqh){
		return projectMapper.zcdDropdown1(userxzqh);
	}

	/**
	 *医疗机构管理新增/修改—监管单位下拉
	 * @param userxzqh
	 * @return
	 */
	public List<Dropdown> jgdwDropdown(String userxzqh){
		return projectMapper.jgdwDropdown(userxzqh);
	}

	/**
	 *人员管理新增/修改—机构下拉（三种）
	 * @param userxzqh
	 * @return
	 */
	public List<Dropdown> userjgDropdown(String userxzqh,String rylx){
		return projectMapper.userjgDropdown(userxzqh,rylx);
	}

	/**
	 *人员管理新增/修改—医疗机构下拉
	 * @param userxzqh
	 * @return
	 */
	public List<Dropdown> userYljgDropdown(String userxzqh,String rylx,String zcdid){
		return projectMapper.userYljgDropdown(userxzqh,rylx,zcdid);
	}


	/**
	 *人员管理新增/修改—监管单位下拉
	 * @param userxzqh
	 * @return
	 */
	public List<Dropdown> userJgdwDropdown(String userxzqh,String rylx){
		return projectMapper.userJgdwDropdown(userxzqh,rylx);
	}
	


	/**
	 * 地区级联,通过地区
	 * 	如果三级机构，那么=查一次，截取前两个机构名，各精确查一次
	 如果二级机构，那么like_ 查一次，截取机构名，精确查一次
	 如果一级机构，那么like_查两次
	 注意：地区位数长度固定包括空格，如果实际编码过长，请修改sql语句
	 * @return AreaTree
	 */
	public List<AreaTree> getArea(String areacode,String isAddr) {
		AreaTree areaTreelv1=null;
		int level=getLevelByRegionCode(areacode);
		if(level==1) {
			areaTreelv1 = appMapper.getArea(areacode);
			List<AreaTree> areaTreelv2 = appMapper.getAreaChildren(areacode);
			for(AreaTree areaTreelv2$:areaTreelv2) {
				List<AreaTree> areaTreelv3 = appMapper.getAreaChildren(areaTreelv2$.getCode());
				areaTreelv2$.setchildren(areaTreelv3);
			}
			areaTreelv1.setchildren(areaTreelv2);

		}else if(level==2){

			String areaCodelv1=getAreaCodelv1(areacode);
			areaTreelv1 = appMapper.getArea(areaCodelv1);
			AreaTree areaTreelv2 = appMapper.getArea(areacode);
			List<AreaTree> areaTreelv3 = appMapper.getAreaChildren(areacode);

			areaTreelv1.setItem(areaTreelv2);
			//1代表地址编码，去除市直辖的
			if("1".equals(isAddr)){
				areaTreelv3 = areaTreelv3.stream().filter(v3 -> !(v3.getCode().equals("330000000, 330500000, 330500000"))).collect(toList());
			}
			areaTreelv2.setchildren(areaTreelv3);


		}else if(level==3) {
			AreaTree areaTreelv3 = appMapper.getArea(areacode);
			String areaCodelv1=getAreaCodelv1(areaTreelv3.getCode());
			String areaCodelv2=getAreaCodelv2(areaTreelv3.getCode());
			areaTreelv1 = appMapper.getArea(areaCodelv1);
			AreaTree areaTreelv2 = appMapper.getArea(areaCodelv2);

			areaTreelv1.setItem(areaTreelv2);
			areaTreelv2.setItem(areaTreelv3);
		}
		List<AreaTree> list=new ArrayList<>();
		list.add(areaTreelv1);
		return list;
	}

	/**
	 * 获取一级机构编码
	 * @param areaCode
	 * @return
	 */
	private String getAreaCodelv1(String areaCode) {
		return areaCode.split(",")[0];
	}

	/**
	 * 获取二级机构编码(warn:数据库地区编码中，之间带有空格)
	 * @param areaCode
	 * @return
	 */
	private String getAreaCodelv2(String areaCode) {
		return areaCode.split(",")[0]+","+areaCode.split(",")[1];
	}



	private int getLevelByRegionCode(String regionCode) {
		return regionCode!=null?regionCode.split(",").length:0;
		//return regionCode.split(",").length;
	}









}


