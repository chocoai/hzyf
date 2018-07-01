package com.cd.zjyf.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cd.zjyf.base.controller.BaseController;
import com.cd.zjyf.base.controller.ServiceHandlerAdapter;
import com.cd.zjyf.bean.AppUser;
import com.cd.zjyf.bean.YfappVersion;
import com.cd.zjyf.exception.SystemException;
import com.cd.zjyf.exception.ValidateException;
import com.cd.zjyf.pojo.LoginUserInfo;
import com.cd.zjyf.pojo.Response;
import com.cd.zjyf.service.UserService;
import com.cd.zjyf.utils.CodeMessage;
import com.cd.zjyf.utils.CommonUtil;
import com.cd.zjyf.utils.FTPclient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.Principal;
import java.util.Collection;
import java.util.Map;


@RestController
public class UserController extends BaseController {
	
	
	@Autowired
	private UserService userService;
	//@Autowired
	//private UAPService uAPService;//平台uap代理服务

	
	
	private static Logger log = LoggerFactory.getLogger(UserController.class);


	/**
	 * 用户登陆，关联相关信息
	 * @param principal 能自动解析token的对象
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET,value="/login")
	public Response login() {
		log.info("======================>>用户登陆操作<<======================");
		Map<String, Object> userInfo=null;
		try {
			//TODO 开通token解析
			userInfo = CommonUtil.getAppUserInfo();
		} catch (Exception e) {
			log.error("usernameService",e);
		}
		LoginUserInfo loginUserInfo = praseAppUser(userInfo);
		return super.genericSaveOrUpdate(new ServiceHandlerAdapter() {
			@Override
			public Object serviceSaveOrUpdateOperate() throws SystemException, ValidateException {
				return userService.getLoginUserInfo(loginUserInfo);
			}
		});

	}


	//{"phoneNumber":"13511112222"%"roles":["4"%"1"]%"nickname":"李四"%"username":"lisi"}

	private LoginUserInfo praseAppUser(Map<String, Object> userInfo) {
		String id = (String) userInfo.get("id");
		String  rylx=(String) userInfo.get("rylx");
		String  xm=(String) userInfo.get("xm");
		String  issh=(String) userInfo.get("issh");
		LoginUserInfo loginUserInfo=new LoginUserInfo();
		loginUserInfo.setUserid(id);
		loginUserInfo.setRylx(rylx);
		loginUserInfo.setUserxm(xm);
		loginUserInfo.setIssh(issh);
		return loginUserInfo;
	}






}










