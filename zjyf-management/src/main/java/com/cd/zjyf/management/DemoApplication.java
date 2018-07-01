package com.cd.zjyf.management;

import java.text.SimpleDateFormat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;

@SpringBootApplication
@EnableDiscoveryClient
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	@Bean
	public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter() {
		MappingJackson2HttpMessageConverter jsonConverter = new MappingJackson2HttpMessageConverter();
		ObjectMapper objectMapper = jsonConverter.getObjectMapper();
		//解决转换json时加载了延迟加载的数据
		objectMapper.registerModule(new Hibernate5Module());
		//设置日期格式，不能解决夏令时问题
		SimpleDateFormat smt = new SimpleDateFormat("yyyy-MM-dd");
		objectMapper.setDateFormat(smt);
		jsonConverter.setObjectMapper(objectMapper);
		return jsonConverter;
	
	}
}
