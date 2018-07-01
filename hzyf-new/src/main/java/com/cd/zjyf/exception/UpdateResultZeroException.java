package com.cd.zjyf.exception;


import com.cd.zjyf.base.exception.BaseException;
import com.cd.zjyf.pojo.Response;
import com.cd.zjyf.utils.CodeMessage;

/**
 * @author chen.shuodong
 *修改结果为0的异常（说明没有查询到要修改的数据）
 */
public class UpdateResultZeroException extends BaseException  {

	private final static String CODE=CodeMessage.UPDATE_FAILED.getCode();
	private final static String MSG=CodeMessage.UPDATE_FAILED.getMsg();
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	
	public UpdateResultZeroException() {
		// TODO Auto-generated constructor stub
	}

	public UpdateResultZeroException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public UpdateResultZeroException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public UpdateResultZeroException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public UpdateResultZeroException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	
	
	@Override
	public Response getResponse() {
		return super.getResponse(CODE, MSG);
	}
	
	
}
