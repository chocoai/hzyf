package com.cd.zjyf.management.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.swagger.annotations.ApiModelProperty;


/**  
 * Created by li.mingyang on 2018/4/14.
 */
@Entity
@Table(name="TBL_APP_USER")
public class AppUser {

	@Id
    @ApiModelProperty("用户id")
	@NotBlank(message="用户名不能为空")
	@Size(max=32,message="用户名过长")
	@Pattern(regexp="[^\u4e00-\u9fa5]+",message="用户名格式错误")
    private String id;

    @ApiModelProperty("姓名")
    @Size(max=50,message="姓名过长")
    private String xm;
    
    @Pattern(regexp="^(1[356789]{1})\\d{9}$",message="手机号格式错误")
    @ApiModelProperty("手机号")
    private String sjh;

    @ApiModelProperty("密码")
    private String mm;

    @ApiModelProperty("人员照片")
    private String ryzp;

    @ApiModelProperty("在岗状态(1在岗2离岗)")
    private String zgzt;

    @ApiModelProperty("是否审核(0未审核1审核通过2审核未通过)")
    private String issh;

    @ApiModelProperty("未通过原因")
    private String wtgyy;
    
    @ApiModelProperty("运输公司(管理员)id")
    private String ysgsid;

    @ManyToOne
    @JoinColumn(name="rylx")
    @JsonIgnoreProperties("appUsers")
    private Role role;
    
    @ManyToOne
    @JoinColumn(name="jgdwid",nullable=true)
    @JsonIgnoreProperties("appUsers")
    private JgdwJbxx jgdwJbxx;
    
    @ManyToOne
    @JoinColumn(name="yljgid",nullable=true)
    @JsonIgnoreProperties("appUsers")
    private YlwsJbxx ylwsJbxx;

	public AppUser() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AppUser(String id, String xm, String sjh, String mm, String ryzp, String zgzt, String issh, String wtgyy,
			String ysgsid, Role role, JgdwJbxx jgdwJbxx, YlwsJbxx ylwsJbxx) {
		super();
		this.id = id;
		this.xm = xm;
		this.sjh = sjh;
		this.mm = mm;
		this.ryzp = ryzp;
		this.zgzt = zgzt;
		this.issh = issh;
		this.wtgyy = wtgyy;
		this.ysgsid = ysgsid;
		this.role = role;
		this.jgdwJbxx = jgdwJbxx;
		this.ylwsJbxx = ylwsJbxx;
	}

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

	public String getSjh() {
		return sjh;
	}

	public void setSjh(String sjh) {
		this.sjh = sjh;
	}

	public String getMm() {
		return mm;
	}

	public void setMm(String mm) {
		this.mm = mm;
	}

	public String getRyzp() {
		return ryzp;
	}

	public void setRyzp(String ryzp) {
		this.ryzp = ryzp;
	}

	public String getZgzt() {
		return zgzt;
	}

	public void setZgzt(String zgzt) {
		this.zgzt = zgzt;
	}

	public String getIssh() {
		return issh;
	}

	public void setIssh(String issh) {
		this.issh = issh;
	}

	public String getWtgyy() {
		return wtgyy;
	}

	public void setWtgyy(String wtgyy) {
		this.wtgyy = wtgyy;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public JgdwJbxx getJgdwJbxx() {
		return jgdwJbxx;
	}

	public void setJgdwJbxx(JgdwJbxx jgdwJbxx) {
		this.jgdwJbxx = jgdwJbxx;
	}

	public YlwsJbxx getYlwsJbxx() {
		return ylwsJbxx;
	}

	public void setYlwsJbxx(YlwsJbxx ylwsJbxx) {
		this.ylwsJbxx = ylwsJbxx;
	}

	public String getYsgsid() {
		return ysgsid;
	}

	public void setYsgsid(String ysgsid) {
		this.ysgsid = ysgsid;
	}

	

    
}
