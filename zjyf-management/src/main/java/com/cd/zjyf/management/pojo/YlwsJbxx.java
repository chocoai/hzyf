package com.cd.zjyf.management.pojo;


import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "TBL_YLWS_JBXX")
public class YlwsJbxx implements java.io.Serializable {

    private static final long serialVersionUID = 235092360253803386L;

	// Fields
    @Id
	@ApiModelProperty("唯一主键")
    private String id;
    
	@ApiModelProperty("统一社会信用代码")
    private String shyxdm;
    
	@ApiModelProperty("医疗机构类型")
    private Long yljgtype;
    
	@ApiModelProperty("单位（科室）名称")
    private String dwmc;
    
	@ApiModelProperty("单位（科室）简称")
    private String dwjc;
    
	@ApiModelProperty("单位地址")
    private String dwdz;
    
	@ApiModelProperty("单位地址编码")
    private String dwdzbm;
    
	@ApiModelProperty("暂存点主键")
    private String zcdid;
    
	@ApiModelProperty("二维码ID")
    private String qrcode;
    
	@ApiModelProperty("营业状态")
	private String yyzt;
    
	@ApiModelProperty("登记人主键")
    private String djrid;
    
	@ApiModelProperty("登记时间")
    private java.util.Date djsj;
    
	@ManyToOne
    @JoinColumn(name="jgdwid")
    @JsonIgnoreProperties("ylwsJbxxs")
	private JgdwJbxx jgdwJbxx;
    
	@OneToMany(targetEntity=AppUser.class, mappedBy="ylwsJbxx", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("ylwsJbxx")
    private Set<AppUser> appUsers;

	public YlwsJbxx() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public YlwsJbxx(String id, String shyxdm, Long yljgtype, String dwmc, String dwjc, String dwdz, String dwdzbm,
			String zcdid, String qrcode, String yyzt, String djrid, Date djsj, JgdwJbxx jgdwJbxx,
			Set<AppUser> appUsers) {
		super();
		this.id = id;
		this.shyxdm = shyxdm;
		this.yljgtype = yljgtype;
		this.dwmc = dwmc;
		this.dwjc = dwjc;
		this.dwdz = dwdz;
		this.dwdzbm = dwdzbm;
		this.zcdid = zcdid;
		this.qrcode = qrcode;
		this.yyzt = yyzt;
		this.djrid = djrid;
		this.djsj = djsj;
		this.jgdwJbxx = jgdwJbxx;
		this.appUsers = appUsers;
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getShyxdm() {
		return shyxdm;
	}

	public void setShyxdm(String shyxdm) {
		this.shyxdm = shyxdm;
	}

	public Long getYljgtype() {
		return yljgtype;
	}

	public void setYljgtype(Long yljgtype) {
		this.yljgtype = yljgtype;
	}

	public String getDwmc() {
		return dwmc;
	}

	public void setDwmc(String dwmc) {
		this.dwmc = dwmc;
	}

	public String getDwjc() {
		return dwjc;
	}

	public void setDwjc(String dwjc) {
		this.dwjc = dwjc;
	}

	public String getDwdz() {
		return dwdz;
	}

	public void setDwdz(String dwdz) {
		this.dwdz = dwdz;
	}

	public String getDwdzbm() {
		return dwdzbm;
	}

	public void setDwdzbm(String dwdzbm) {
		this.dwdzbm = dwdzbm;
	}

	public String getZcdid() {
		return zcdid;
	}

	public void setZcdid(String zcdid) {
		this.zcdid = zcdid;
	}

	public String getQrcode() {
		return qrcode;
	}

	public void setQrcode(String qrcode) {
		this.qrcode = qrcode;
	}

	public String getYyzt() {
		return yyzt;
	}

	public void setYyzt(String yyzt) {
		this.yyzt = yyzt;
	}

	public String getDjrid() {
		return djrid;
	}

	public void setDjrid(String djrid) {
		this.djrid = djrid;
	}

	public java.util.Date getDjsj() {
		return djsj;
	}

	public void setDjsj(java.util.Date djsj) {
		this.djsj = djsj;
	}

//	public String getJgdwid() {
//		return jgdwid;
//	}
//
//	public void setJgdwid(String jgdwid) {
//		this.jgdwid = jgdwid;
//	}

	public Set<AppUser> getAppUsers() {
		return appUsers;
	}

	public void setAppUsers(Set<AppUser> appUsers) {
		this.appUsers = appUsers;
	}


	public JgdwJbxx getJgdwJbxx() {
		return jgdwJbxx;
	}


	public void setJgdwJbxx(JgdwJbxx jgdwJbxx) {
		this.jgdwJbxx = jgdwJbxx;
	}
	
	
        
}