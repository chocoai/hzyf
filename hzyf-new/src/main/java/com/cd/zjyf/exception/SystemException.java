package com.cd.zjyf.exception;


import com.cd.zjyf.base.exception.BaseException;
import com.cd.zjyf.pojo.Response;
import com.cd.zjyf.utils.CodeMessage;

/**
 * @author chen.shuodong
 *系统异常类
 */
public class SystemException extends BaseException  {

	private final static String CODE=CodeMessage.SYSTEM_ERROR.getCode();
	private final static String MSG=CodeMessage.SYSTEM_ERROR.getMsg();
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	
	public SystemException() {
		// TODO Auto-generated constructor stub
	}

	public SystemException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public SystemException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public SystemException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public SystemException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	
	
	@Override
	public Response getResponse() {
		return super.getResponse(CODE, MSG);
	}
	
	
}
