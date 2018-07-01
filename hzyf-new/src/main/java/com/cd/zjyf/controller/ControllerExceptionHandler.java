/*
package com.cd.zjyf.controller;

import com.cd.zjyf.pojo.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Set;

@ControllerAdvice
public class ControllerExceptionHandler {
	private Logger log = LoggerFactory.getLogger(ControllerExceptionHandler.class);

	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Response handleException(Exception e) {
		e.printStackTrace();
		if (e.getCause() != null) {
			log.error("",e);
			return new Response(1, ResultCode.FAILED_SYSTEM.appendMsg(e.getCause().getMessage()), null);
		} else {
			log.error(e.getMessage());
			return new Response(1, ResultCode.FAILED_SYSTEM.appendMsg(e.getMessage()), null);
		}
	}


	
	@ExceptionHandler(MethodArgumentNotValidException.class)  
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)  
	@ResponseBody  
	public Response handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {  
	    BindingResult bindingResult = ex.getBindingResult();  
		StringBuilder errorMesssage = new StringBuilder();
	  
	    for (FieldError fieldError : bindingResult.getFieldErrors()) {  
	        errorMesssage.append(fieldError.getDefaultMessage());
	        errorMesssage.append(",");
	    }  
	    return new Response(1, ResultCode.FAILED_VALIDATION.appendMsg(errorMesssage.toString()),null);  
	}  
}*/
