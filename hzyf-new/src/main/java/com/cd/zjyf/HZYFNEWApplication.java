package com.cd.zjyf;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
//import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

/**
 * 引导类
 * @author huntto
 *
 */
//@EnableResourceServer //password方式(这个是uap服务token认证的开关，发布时候应该解除注销)
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@EnableScheduling
@MapperScan("com.cd.zjyf.mapper")
public class HZYFNEWApplication {
	public static void main(String[] args) {
		SpringApplication.run(HZYFNEWApplication.class,  args);
	}



	/*@Bean(name = "multipartResolver")
	public MultipartResolver multipartResolver(){
		CommonsMultipartResolver resolver = new CommonsMultipartResolver();
		resolver.setDefaultEncoding("UTF-8");
		resolver.setResolveLazily(true);//resolveLazily属性启用是为了推迟文件解析，以在在UploadAction中捕获文件大小异常
		resolver.setMaxInMemorySize(40960);
		resolver.setMaxUploadSize(50*1024*1024);//上传文件大小 50M 50*1024*1024
		return resolver;
	}*/

}



