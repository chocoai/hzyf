package com.cd.uap.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_ROLE")
public class Role implements java.io.Serializable {

	private static final long serialVersionUID = 713437496577669556L;

	@Id
	private String id;

	private String roleName;

	private java.util.Date createdDatetime;

	private String introduction;

	private String remark;

	private String identification;

	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	public Role(String id, String roleName, Date createdDatetime, String introduction, String remark,
			String identification) {
		super();
		this.id = id;
		this.roleName = roleName;
		this.createdDatetime = createdDatetime;
		this.introduction = introduction;
		this.remark = remark;
		this.identification = identification;
	}



	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public java.util.Date getCreatedDatetime() {
		return createdDatetime;
	}

	public void setCreatedDatetime(java.util.Date createdDatetime) {
		this.createdDatetime = createdDatetime;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getIdentification() {
		return identification;
	}

	public void setIdentification(String identification) {
		this.identification = identification;
	}

	
	
}