package com.cd.zuul.ywdp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

import com.cd.zuul.ywdp.filter.UserAccessFilter;

@SpringBootApplication
@EnableZuulProxy
@EnableResourceServer
@EnableWebSecurity
public class YwdpZuul1Application extends ResourceServerConfigurerAdapter {

	public static void main(String[] args) {
		SpringApplication.run(YwdpZuul1Application.class, args);
	}

	@Bean
	public UserAccessFilter accessFilter() {
		return new UserAccessFilter();
	}


	@Override
	public void configure(HttpSecurity http) throws Exception {

		 http.authorizeRequests()
	  		  .antMatchers(HttpMethod.POST, "/api/zjyfmanagement/user").access("hasAnyAuthority('5','6')")
		      .antMatchers(HttpMethod.GET,"/api/zjyfmanagement/user/conditions").access("hasAnyAuthority('5','6')")
		      .antMatchers(HttpMethod.POST, "/api/zjyfmanagement/user/transporter").access("hasAnyAuthority('7')")
		      .antMatchers(HttpMethod.DELETE, "/api/zjyfmanagement/user/transporter/*").access("hasAnyAuthority('5','6','7')")
		      .antMatchers(HttpMethod.PUT, "/api/zjyfmanagement/user/*/issh").access("hasAnyAuthority('5','6')")
		      .antMatchers("/api/zjyfweb/**").access("hasAnyAuthority('4','5','6','7')")
		      .antMatchers("/api/hzyf/**").access("hasAnyAuthority('1','2','4','5','6','7')");

	}
}
