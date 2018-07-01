package com.cd.zjyf.management.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("返回信息对象")
public class Response {

	@ApiModelProperty(value = "操作状态", notes = "0成功，1失败")
	private int status;

	@ApiModelProperty(value = "结果信息", notes = "状态码及信息")
	private ResultCode result;

	@ApiModelProperty(value = "数据信息")
	private Object data;

	public Response(int status, ResultCode result, Object data) {
		super();
		this.status = status;
		this.result = result;
		this.data = data;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public ResultCode getResult() {
		return result;
	}

	public void setResult(ResultCode result) {
		this.result = result;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

}