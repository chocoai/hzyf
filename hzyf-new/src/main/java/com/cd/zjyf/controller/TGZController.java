package com.cd.zjyf.controller;

import com.cd.zjyf.base.controller.BaseController;
import com.cd.zjyf.base.controller.ServiceHandlerAdapter;
import com.cd.zjyf.base.exception.BaseException;
import com.cd.zjyf.bean.AppUser;
import com.cd.zjyf.exception.ValidateException;
import com.cd.zjyf.pojo.Response;
import com.cd.zjyf.pojo.qc.TGZstatisticsFWQC;
import com.cd.zjyf.service.TGZService;
import com.cd.zjyf.utils.CommonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


@RestController
@RequestMapping("/tgz")
public class TGZController extends BaseController {
	
	
	@Autowired
	private TGZService tGZService;
	
	private static Logger log = LoggerFactory.getLogger(TGZController.class);

	@RequestMapping(method = RequestMethod.GET,value="/bang")
	public Response selectByTGZqueryByQRcodeBean(String id) {
		log.info("个人信息通过二维码扫描显示绑定信息");
		
		return super.queryHasException(new ServiceHandlerAdapter() {
			@Override
			public Object serviceQueryOperateHasExcpetoin() throws ValidateException {
				return tGZService.selectByTGZqueryByQRcodeBean(id,getUserid());
			}
		});
	}
	
	private String getUserid() {
			Map<String, Object> userInfo=null;
			try {
				userInfo = CommonUtil.getAppUserInfo();
			} catch (Exception e) {
				log.error("usernameService",e);
			}
			String id = (String) userInfo.get("username");
			AppUser appUser=new AppUser();
			appUser.setId(id);
			return appUser.getId();
	}
	
	@Deprecated
	@RequestMapping(method = RequestMethod.PUT,value="/bang")
	public Response bondingAppUser(@RequestBody AppUser appUser) {
		log.info("保存个人绑定医院信息，并生成个人二维码");
		return super.genericSaveOrUpdate(new ServiceHandlerAdapter() {
			@Override
			public Object serviceSaveOrUpdateOperate(Object o) throws BaseException {
				return tGZService.bondingAppUser((AppUser)o);
			}
		}, appUser);
	}
	
	
	
	@RequestMapping(method = RequestMethod.GET,value="/index")
	public Response selectTGZfirstPageList(String id) {
		log.info("用于展示提供废物列表、用户信息。提供废物列表按时间从近到远排序最多显示10条。");
		return super.query(new ServiceHandlerAdapter() {
			@Override
			public Object serviceQueryOperate(Object o) {
				return tGZService.selectTGZfirstPageList((String)o);
			}
		}, id);
	}
	
	@RequestMapping(method = RequestMethod.GET,value="/registerInfo")
	public Response selectTGZstatisticsFW(TGZstatisticsFWQC qc) {
		log.info("统计该交接员在一定时间段内提供医废的总重量和总次数，并按5种医废类型分别统计。");
		return super.query(new ServiceHandlerAdapter() {
			@Override
			public Object serviceQueryOperate(Object o) {
				return tGZService.selectTGZstatisticsFW((TGZstatisticsFWQC)o);
			}
		}, qc);
	}
	
	
}










