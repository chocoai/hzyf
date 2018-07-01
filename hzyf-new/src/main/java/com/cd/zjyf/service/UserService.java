package com.cd.zjyf.service;

import com.cd.zjyf.bean.AppUser;
import com.cd.zjyf.bean.YlwsJbxx;
import com.cd.zjyf.enums.ServiceRangeCode;
import com.cd.zjyf.exception.ValidateException;
import com.cd.zjyf.mapper.*;

import com.cd.zjyf.pojo.LoginUserInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;


@Service
public class UserService {

	
	@Autowired
	private YlwsJbxxMapper ylwsJbxxMapper;
	
	@Autowired
	private ProjectMapper projectMapper;

	@Autowired
	private AppUserMapper appUserMapper;


	
	private static Logger log = LoggerFactory.getLogger(UserService.class);


	public LoginUserInfo getLoginUserInfo(LoginUserInfo tokenUser) throws ValidateException {
		userCheck(tokenUser);
		//AppUser loginUser = appUserMapper.selectByPrimaryKey(tokenUser.getId());
		AppUser appUser = appUserMapper.selectByPrimaryKey(tokenUser.getUserid());

		if(ServiceRangeCode.OUT_GUARD.getCode().equals(appUser.getZgzt())){
			throw new ValidateException("该用户已被删除。。。");
		}


		//如果人员类型是6医院管理员，那么需要加入对应的暂存点id和暂存点对应的监管机构id
		if(ServiceRangeCode.YYGLY.getCode().equals(tokenUser.getRylx())){
			YlwsJbxx ylwsJbxx = ylwsJbxxMapper.selectByPrimaryKey(appUser.getYljgid());
			tokenUser.setZcdid(ylwsJbxx.getId());
			tokenUser.setJgdwid(ylwsJbxx.getJgdwid());
			tokenUser.setZcdmc(ylwsJbxx.getDwmc());
			tokenUser.setZcdjc(ylwsJbxx.getDwjc());
			tokenUser.setIsSewage(ylwsJbxx.getIsSewage());
		}

		String xzqh=null;
		//过滤掉运输公司管理员不需要查行政区划
		if(!ServiceRangeCode.YSGLY.getCode().equals(tokenUser.getRylx())){
			 xzqh = projectMapper.queryUserXZQH(tokenUser);
			tokenUser.setUserxzqh(xzqh);
		}
		tokenUser.setUserxm(appUser.getXm());
		return tokenUser.translateXZQH();
	}

	//用户登陆校验
	private  void userCheck(LoginUserInfo appUser) throws ValidateException {
		List<String> avliableRole= Arrays.asList(ServiceRangeCode.GLY.getCode(),
				ServiceRangeCode.YYGLY.getCode(),
				ServiceRangeCode.JDGLY.getCode(),
				ServiceRangeCode.YSGLY.getCode());

		//if(appUser==null) appUser=new AppUser();


		//过滤掉未审核用户
		if(ServiceRangeCode.WSH.getCode().equals(appUser.getIssh())){
			throw new ValidateException("未审核用户不允许登陆！");
		}
		//过滤掉待审核用户
		if(ServiceRangeCode.DSH.getCode().equals(appUser.getIssh())){
			throw new ValidateException("用户正在审核中。。。");
		}
		//过滤掉审核不通过的用户
		if(ServiceRangeCode.SHWTG.getCode().equals(appUser.getIssh())){
			throw new ValidateException("对不起，该用户审核未通过。。。");
		}
		if(!avliableRole.contains(appUser.getRylx())){
			throw new ValidateException("该角色类型不允许登陆!");
		}

	}

}


