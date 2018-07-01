package com.cd.zjyf.base.exception;

import com.cd.zjyf.pojo.Response;
import com.cd.zjyf.utils.CodeMessage;

public abstract class BaseException extends Exception{

	/**
	 * 校验异常
	 */
	private static final long serialVersionUID = 1L;

	public static final int success=CodeMessage.STATUS_SUCCESS.getStatus();
	
	public static final int fail=CodeMessage.STATUS_FAILED.getStatus();

	
	public abstract Response getResponse();
	/**
	 * 获取相应体
	 * @param code
	 * @param msg
	 * @param isSysError 是否是系统异常
	 * @return
	 */
	@Deprecated
	 protected Response getResponse(String code,String msg,boolean isSysError) {
			Response response = new Response();
			response.setStatus(success);
			if(isSysError) {
				response.setStatus(fail);
			}
			if(super.getMessage()==null)
			response.setError(code, msg);
			else
			response.setError(code, super.getMessage());
			return response;
	 }
	 
	 /**
	  * 
	  * @param code
	  * @param msg
	  * @return
	  */
	 protected Response getResponse(String code,String msg) {
			Response response = new Response();
			response.setStatus(fail);
			if(super.getMessage()==null)
			response.setError(code, msg);
			else
			response.setError(code, super.getMessage());
			return response;
	 }
	 
	
	public BaseException() {
		// TODO Auto-generated constructor stub
	}

	public BaseException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public BaseException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public BaseException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public BaseException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}
