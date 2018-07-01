package com.cd.zuul.ywdp.filter;


import java.net.URLEncoder;
import java.security.Principal;
import java.util.Map;

import javax.servlet.ServletResponseWrapper;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

import com.cd.zuul.ywdp.dao.UserDao;
import com.cd.zuul.ywdp.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSON;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

public class UserAccessFilter extends ZuulFilter {

	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private UserDao userDao;
	
	/**
	 * 从请求中获取用户信息,转为map,然后加入权限信息,再转为String,存入请求属性值中
	 */
	@Override
	@SuppressWarnings("unchecked")
	public Object run() {

		try {
			RequestContext context = RequestContext.getCurrentContext();
			HttpServletRequest request = context.getRequest();

			logger.info("send {} request to {}", request.getMethod(), request.getRequestURL().toString());

			Principal principal = request.getUserPrincipal();

			OAuth2Authentication auth2Authentication = (OAuth2Authentication)principal;
			//获取token中存储的用户信息
			String userJson = auth2Authentication.getName();

			Map<String,Object> userInfoMap = (Map<String,Object>)JSON.parse(userJson);

			if (StringUtils.isEmpty(userJson)) {
				logger.error("用户信息解析失败");
				return null;
			}

			String id = (String)userInfoMap.get("id");
			User user = userDao.findOne(id);

			//如果token已经发出，但是被用户在数据库中删除
			if (null == user) {

				logger.error("用户 {} 已经被删除",id);
				context.setSendZuulResponse(false);
				context.setResponseStatusCode(401);
				context.setResponseBody("{\"status\": 0,\"result\":{\"code\": \"1000\",\"msg\":\"请重新登录\"},\"data\": null}");
				return null;


			}

//		userInfoMap.put("rylx", authorityList);
			userJson = JSON.toJSONString(userInfoMap);
			context.addZuulRequestHeader("userInfo", URLEncoder.encode(userJson, "UTF-8"));
		} catch (Exception exception) {
			logger.error("用户信息解析失败");
		}


		return null;
	}
	
	@Override
	public boolean shouldFilter() {
		
		return true;
	}

	@Override
	public String filterType() {
		// TODO Auto-generated method stub
		return "pre";
	}

	@Override
	public int filterOrder() {
		// TODO Auto-generated method stub
		return 0;
	}

}
