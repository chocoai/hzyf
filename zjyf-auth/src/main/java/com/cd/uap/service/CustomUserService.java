package com.cd.uap.service;

import java.util.List;

import javax.transaction.Transactional;

import com.alibaba.fastjson.JSON;
import com.cd.uap.bean.WxResponse;
import com.cd.uap.dao.RoleDao;
import com.cd.uap.dao.WxDao;
import com.cd.uap.entity.Role;
import com.cd.uap.entity.User;
import com.cd.uap.entity.Wx;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundValueOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;


import com.cd.uap.dao.UserDao;
import org.springframework.web.client.RestTemplate;

@Service
public class CustomUserService implements UserDetailsService {

	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private UserDao userDao;

	@Autowired
	private UserService userService;

	@Autowired
	private RedisTemplate<String, String> redisTemplate;
	
	@Autowired
	private RoleDao roleDao;

	@Autowired
	private WxDao wxDao;

	@Autowired
	private RestTemplate restTemplate;

	/**
	 * 根据用户名加载用户信息，在Provider中被调用
	 *
	 * @param username
	 * @return
	 * @throws UsernameNotFoundException
	 */
	@Transactional
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		if (null == username) {
			throw new UsernameNotFoundException("手机号或用户不能为空");
		}
		// 如果是手机号方式登录
		if (username.matches("^(1[345789]{1})\\d{9}$")) {

			User user = userDao.findBySjh(username);
			if (null == user) {
				throw new UsernameNotFoundException("手机号码不存在");
			}
			
			//从Redis中校验短信验证码
			BoundValueOperations<String, String> boundValueOps = redisTemplate.boundValueOps("regist" + username);
			String currentValidateCode = boundValueOps.get();
			if (null == currentValidateCode) {
				logger.info("验证码已过期");
				throw new UsernameNotFoundException("验证码已过期");
			}
			
			String userJson = userService.getUserByUsername(username);
			// 此处将权限信息添加到 authorities 对象中
			
			List<GrantedAuthority> authorityList = getAuthorities(user);
			
			return new org.springframework.security.core.userdetails.User(userJson, currentValidateCode, authorityList);

		//如果是code的方式
		}else if (username.length() == 32){

			String entity = restTemplate.getForObject("https://api.weixin.qq.com/sns/jscode2session?appid=" + Wx.APP_ID + "&secret=" + Wx.SECRET + "&js_code=" + username + "&grant_type=authorization_code", String.class);
			WxResponse wxResponse = JSON.parseObject(entity, WxResponse.class);
			if(null != wxResponse.getErrcode()) {
				throw new UsernameNotFoundException("微信openId获取失败");
			}
			String openid = wxResponse.getOpenid();

			Wx wx = wxDao.findByOpenId(openid);
			if (null == wx){
				throw new UsernameNotFoundException("该微信尚未绑定用户");
			}
			User user = userDao.findOne(wx.getUserId());
			String userJson = userService.getUserByUsername(user.getId());
			List<GrantedAuthority> authorityList = getAuthorities(user);

			return new org.springframework.security.core.userdetails.User(userJson, user.getMm(), authorityList);
		}else {
			// 如果是用户名密码方式登录
			User user = userDao.findOne(username);
			if (user == null) {
				throw new UsernameNotFoundException("用户名不存在");
			}
			
			String userJson = userService.getUserByUsername(username);
			// 此处将权限信息添加到 authorities 对象中
			List<GrantedAuthority> authorityList = getAuthorities(user);
			return new org.springframework.security.core.userdetails.User(userJson, user.getMm(), authorityList);

		}
	}


	/**
	 * 通过user对象得到Authority
	 * @param user
	 * @return
	 */
	private List<GrantedAuthority> getAuthorities(User user) throws UsernameNotFoundException{
		
		String rylx = user.getRylx();
		//如果人员类型为空，报错
		if (StringUtils.isEmpty(rylx)) {
			throw new UsernameNotFoundException("用户角色不能为空");
		}
		Role role = roleDao.findOne(rylx);
		//如果用户未查询到用户角色
		if (null == role) {
			throw new UsernameNotFoundException("用户角色不存在");
		}
		String id = role.getId();
		
		List<GrantedAuthority> allAuthorityList = AuthorityUtils.commaSeparatedStringToAuthorityList(id);
		return allAuthorityList;
		
	}

}
