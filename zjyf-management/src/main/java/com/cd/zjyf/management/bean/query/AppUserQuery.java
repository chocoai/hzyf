package com.cd.zjyf.management.bean.query;

import io.swagger.annotations.ApiModelProperty;

public class AppUserQuery extends AbstarctQuery implements java.io.Serializable {
	private static final long serialVersionUID = 395656964284091782L;

	@ApiModelProperty("用户名")
	private String id;

	@ApiModelProperty("姓名")
	private String xm;

	@ApiModelProperty("人员类型")
	private String rylx;

	@ApiModelProperty("机构名称(可能医疗机构或监管机构)")
	private String jgmc;

	@ApiModelProperty("是否审核(0未审核1审核通过2审核未通过)")
	private String issh;

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

	public String getRylx() {
		return rylx;
	}

	public void setRylx(String rylx) {
		this.rylx = rylx;
	}

	public String getIssh() {
		return issh;
	}

	public void setIssh(String issh) {
		this.issh = issh;
	}

	public String getJgmc() {
		return jgmc;
	}

	public void setJgmc(String jgmc) {
		this.jgmc = jgmc;
	}

}