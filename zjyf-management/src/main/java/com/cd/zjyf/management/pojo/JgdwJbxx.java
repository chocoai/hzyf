package com.cd.zjyf.management.pojo;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "TBL_JGDW_JBXX")
public class JgdwJbxx implements java.io.Serializable {

    private static final long serialVersionUID = 172843409194933858L;

	// Fields
    @Id
	@ApiModelProperty("监管单位编码")
    private String id;
    
	@ApiModelProperty("监管单位名称")
    private String jgdwmc;
    
	@ApiModelProperty("部门级别")
    private String bmjb;
    
	@ApiModelProperty("部门监管行政区划")
    private String xzqh;
    
	@OneToMany(targetEntity=AppUser.class, mappedBy="jgdwJbxx", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("jgdwJbxx")
    private Set<AppUser> appUsers;

	@OneToMany(targetEntity=YlwsJbxx.class, mappedBy="jgdwJbxx", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("jgdwJbxx")
	private Set<YlwsJbxx> ylwsJbxxs;

	public JgdwJbxx() {
		super();
		// TODO Auto-generated constructor stub
	}

	public JgdwJbxx(String id, String jgdwmc, String bmjb, String xzqh, Set<AppUser> appUsers,
			Set<YlwsJbxx> ylwsJbxxs) {
		super();
		this.id = id;
		this.jgdwmc = jgdwmc;
		this.bmjb = bmjb;
		this.xzqh = xzqh;
		this.appUsers = appUsers;
		this.ylwsJbxxs = ylwsJbxxs;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getJgdwmc() {
		return jgdwmc;
	}

	public void setJgdwmc(String jgdwmc) {
		this.jgdwmc = jgdwmc;
	}

	public String getBmjb() {
		return bmjb;
	}

	public void setBmjb(String bmjb) {
		this.bmjb = bmjb;
	}

	public String getXzqh() {
		return xzqh;
	}

	public void setXzqh(String xzqh) {
		this.xzqh = xzqh;
	}

	public Set<AppUser> getAppUsers() {
		return appUsers;
	}

	public void setAppUsers(Set<AppUser> appUsers) {
		this.appUsers = appUsers;
	}

	public Set<YlwsJbxx> getYlwsJbxxs() {
		return ylwsJbxxs;
	}

	public void setYlwsJbxxs(Set<YlwsJbxx> ylwsJbxxs) {
		this.ylwsJbxxs = ylwsJbxxs;
	}



}