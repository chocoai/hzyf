package com.cd.zjyf.pojo;

import com.cd.zjyf.utils.CodeMessage;

public class Response {

	private int status;

	private Error error;

	private Object data;

	private String access_token;

	public Response() {
	}

	public Response(int status, Error error) {
		this.status = status;
		this.error = error;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public void setStatus(CodeMessage cm) {
		this.status = cm.getStatus();
	}	
	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public Error getError() {
		return error;
	}

	public void setError(String code, String message) {
		this.error = new Error(code, message);
	}
	
	public void setError(CodeMessage cm) {
		this.error = new Error(cm.getCode(), cm.getMsg());
	}
	
	

	public String getAccess_token() {
		return access_token;
	}

	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}

	/**
	 * 错误信息类
	 * @author li.mingyang
	 *
	 */
	public class Error {
		
		private String code;
		
		private String message;
		
		public Error() {
			super();
		}

		public Error(String code, String message) {
			this.code = code;
			this.message = message;
		}

		public String getCode() {
			return code;
		}

		public void setCode(String code) {
			this.code = code;
		}

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}
		
		
	}

}
