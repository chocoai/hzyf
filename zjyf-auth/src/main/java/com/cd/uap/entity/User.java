package com.cd.uap.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="TBL_APP_USER")
public class User {

	@Id
    private String id;

    private String xm;

    private String sjh;

    private String mm;

    private String ryzp;

    private String zgzt;

    private String issh;

    private String wtgyy;
    
    private String yljgid;
    
    private String jgdwid;
    
    private String rylx;

    private String ysgsid;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}


	public User(String id, String xm, String sjh, String mm, String ryzp, String zgzt, String issh, String wtgyy, String yljgid, String jgdwid, String rylx, String ysgsid) {
		this.id = id;
		this.xm = xm;
		this.sjh = sjh;
		this.mm = mm;
		this.ryzp = ryzp;
		this.zgzt = zgzt;
		this.issh = issh;
		this.wtgyy = wtgyy;
		this.yljgid = yljgid;
		this.jgdwid = jgdwid;
		this.rylx = rylx;
		this.ysgsid = ysgsid;
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

	public String getYljgid() {
		return yljgid;
	}

	public void setYljgid(String yljgid) {
		this.yljgid = yljgid;
	}

	public String getJgdwid() {
		return jgdwid;
	}

	public void setJgdwid(String jgdwid) {
		this.jgdwid = jgdwid;
	}

	public String getRylx() {
		return rylx;
	}

	public void setRylx(String rylx) {
		this.rylx = rylx;
	}

	public String getYsgsid() {
		return ysgsid;
	}

	public void setYsgsid(String ysgsid) {
		this.ysgsid = ysgsid;
	}
}