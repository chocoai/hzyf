package com.cd.zjyf.interceptor;

import javax.servlet.http.HttpServletResponse;

import org.springframework.core.MethodParameter;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.method.support.ModelAndViewContainer;

import com.alibaba.fastjson.JSON;

/**
 * @author chen.shuodong
 *no use
 */
public class ReturnHandler implements HandlerMethodReturnValueHandler {  
  
    /** 
     * 该处理程序是否支持给定的方法返回类型(只有返回true才回去调用handleReturnValue) 
     */  
    @Override  
    public boolean supportsReturnType(MethodParameter methodParameter) {  
        return true; 
    }  
  
    /** 
     * 处理给定的返回值 
     * 通过向 ModelAndViewContainer 添加属性和设置视图或者 
     * 通过调用 ModelAndViewContainer.setRequestHandled(true) 来标识响应已经被直接处理(不再调用视图解析器) 
     */  

	@Override
	public void handleReturnValue(Object returnValue, MethodParameter returnType, ModelAndViewContainer mavContainer,
			NativeWebRequest webRequest) throws Exception {
		
		 HttpServletResponse response = webRequest.getNativeResponse(HttpServletResponse.class);  
	        response.setContentType("text/plain;charset=UTF-8");  
	        String jsonString = JSON.toJSONString(returnValue);
			response.getWriter().append(jsonString).flush();  
	}  
}  