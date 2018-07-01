package com.cd.zjyf.management.bean.dto;

import io.swagger.annotations.ApiModelProperty;

public class AppUserDto {
	
	@ApiModelProperty("用户id(账号)")
	private String id;		
	
	@ApiModelProperty("人员姓名/运输公司名称")
	private String xm;
	
	@ApiModelProperty("人员类型Id")
	private String rylxId;
	
	@ApiModelProperty("手机号")
	private String sjh;
	
	@ApiModelProperty("医疗机构Id")
	private String yljgId;
	
	@ApiModelProperty("监管单位Id")
	private String jgdwId;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getXm() {
		return xm;
	}

	public void setXm(String xm) {
		this.xm = xm;
	}

	public String getRylxId() {
		return rylxId;
	}

	public void setRylxId(String rylxId) {
		this.rylxId = rylxId;
	}

	public String getSjh() {
		return sjh;
	}

	public void setSjh(String sjh) {
		this.sjh = sjh;
	}

	public String getYljgId() {
		return yljgId;
	}

	public void setYljgId(String yljgId) {
		this.yljgId = yljgId;
	}

	public String getJgdwId() {
		return jgdwId;
	}

	public void setJgdwId(String jgdwId) {
		this.jgdwId = jgdwId;
	}
	
	
}
