package com.cd.uap.config;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.cd.uap.service.CustomUserService;
import org.springframework.util.StringUtils;

@Component
public class MyAuthenticationProvider implements AuthenticationProvider {

	@Autowired
	private CustomUserService userService;

	@Autowired
	private MyPasswordEncoder encoder;

	/**
	 * 通过用户 前端验证登录信息 和 正确登录信息 进行比较，若正确返回token
	 *
	 * @param authentication	前台传来的登录信息
	 * @return
	 * @throws AuthenticationException
	 */
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String username = authentication.getName();
		String password = (String) authentication.getCredentials();
		//根据用户名加载出正确的用户
		UserDetails user = userService.loadUserByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("用户名错误");
		}
		//校验用户密码
		if (!StringUtils.isEmpty(password)){
			password = encoder.encode(password);
		}
		// 加密过程在这里体现
		/*if(user.getPassword().matches("[0-9]{6}")){
			if (!password.equals(encoder.encode(user.getPassword()))) {
				throw new UsernameNotFoundException("验证码错误");
			}
		}else {
			if (!password.equals(user.getPassword())) {
				throw new UsernameNotFoundException("密码错误");
			}
		}*/
		Collection<? extends GrantedAuthority> authorities = user.getAuthorities();
		if(username.matches("^(1[345789]{1})\\d{9}$")){
			if (!password.equals(encoder.encode(user.getPassword()))) {
				throw new UsernameNotFoundException("验证码错误");
			}
			return new UsernamePasswordAuthenticationToken(user, password, authorities);

		} else if (username.length() == 32){
			return new UsernamePasswordAuthenticationToken(user, null, authorities);

		} else {
			if (!password.equals(user.getPassword())) {
				throw new UsernameNotFoundException("密码错误");
			}
			return new UsernamePasswordAuthenticationToken(user, password, authorities);
		}

		//验证用户信息正确


	}

	@Override
	public boolean supports(Class<?> arg0) {
		return true;
	}

}