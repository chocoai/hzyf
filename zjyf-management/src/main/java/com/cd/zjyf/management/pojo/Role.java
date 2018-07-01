package com.cd.zjyf.management.pojo;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "TBL_ROLE")
public class Role implements java.io.Serializable {

	private static final long serialVersionUID = 713437496577669556L;

	@Id
	@ApiModelProperty("角色id")
	private String id;

	@ApiModelProperty("角色名称")
	private String roleName;

	@ApiModelProperty("创建日期")
	private java.util.Date createdDatetime;

	@ApiModelProperty("角色介绍")
	private String introduction;

	@ApiModelProperty("备注")
	private String remark;

	@OneToMany(targetEntity = AppUser.class, mappedBy = "role", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("role")
	private Set<AppUser> appUsers;

	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Role(String id, String roleName, Date createdDatetime, String introduction, String remark,
			Set<AppUser> appUsers) {
		super();
		this.id = id;
		this.roleName = roleName;
		this.createdDatetime = createdDatetime;
		this.introduction = introduction;
		this.remark = remark;
		this.appUsers = appUsers;
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

	public Set<AppUser> getAppUsers() {
		return appUsers;
	}

	public void setAppUsers(Set<AppUser> appUsers) {
		this.appUsers = appUsers;
	}

	
}