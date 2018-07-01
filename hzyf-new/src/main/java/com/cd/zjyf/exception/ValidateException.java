package com.cd.zjyf.exception;


import com.cd.zjyf.base.exception.BaseException;
import com.cd.zjyf.pojo.Response;
import com.cd.zjyf.utils.CodeMessage;

/**
 * @author chen.shuodong
 *校验异常类
 */
public class ValidateException extends BaseException  {

	private final static String CODE=CodeMessage.VALIDATE_FAILED.getCode();
	private final static String MSG=CodeMessage.VALIDATE_FAILED.getMsg();
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	
	public ValidateException() {
		// TODO Auto-generated constructor stub
	}

	public ValidateException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public ValidateException(CodeMessage codeMessage) {
		super(codeMessage.getMsg());
	}
	
	public ValidateException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public ValidateException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public ValidateException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	
	
	@Override
	public Response getResponse() {
		return super.getResponse(CODE, MSG);
	}
	
	
}
