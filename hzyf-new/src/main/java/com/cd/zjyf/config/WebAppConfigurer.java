package com.cd.zjyf.config;
  
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.cd.zjyf.interceptor.ReturnHandler;
import com.cd.zjyf.interceptor.SystemInterceptor;  
@Configuration  
public class WebAppConfigurer  
        extends WebMvcConfigurerAdapter {  
    @Bean  
    public HandlerInterceptor getMyInterceptor(){  
        return new SystemInterceptor();  
    }  
  
    @Override  
    public void addInterceptors(InterceptorRegistry registry) {  
        // 多个拦截器组成一个拦截器链  
        // addPathPatterns 用于添加拦截规则  
        // excludePathPatterns 用户排除拦截  
        registry.addInterceptor(getMyInterceptor()).addPathPatterns("/**");  
        super.addInterceptors(registry);  
    }  
    
    @Override  
    public void addReturnValueHandlers(List<HandlerMethodReturnValueHandler> returnValueHandlers) {  
        ReturnHandler returnHandler=new ReturnHandler();  
        returnValueHandlers.add(returnHandler);  
        super.addReturnValueHandlers(returnValueHandlers);  
    }  
}  