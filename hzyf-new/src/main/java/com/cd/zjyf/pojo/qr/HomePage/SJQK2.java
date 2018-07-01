/**
  * Copyright 2018 bejson.com 
  */
package com.cd.zjyf.pojo.qr.HomePage;

import com.cd.zjyf.utils.CommonUtil;
import com.cd.zjyf.utils.Constant;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Auto-generated: 2018-02-06 10:6:36
 *具体单位收集情况
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class SJQK2 {
	
	private Date jstime;  //接收时间
	private String jsqk;    //是否清算
	private String lx;      //类别
	private BigDecimal zl=CommonUtil.getDeafualtBigDecimal();//重量
	private String tgz;     //交接人
	private String jsr;     //收集人
	private String qsr;     //运输人
	
	@JsonFormat(timezone = "GMT+8", pattern = Constant.DATE_PATTERN1)
	public Date getJstime() {
		return jstime;
	}
	public void setJstime(Date jstime) {
		this.jstime = jstime;
	}
	public String getLx() {
		return lx;
	}
	public void setLx(String lx) {
		this.lx = lx;
	}
	public BigDecimal getZl() {
		return zl;
	}
	public void setZl(BigDecimal zl) {
		this.zl = zl;
	}
	public String getTgz() {
		return tgz;
	}
	public void setTgz(String tgz) {
		this.tgz = tgz;
	}
	public String getJsr() {
		return jsr;
	}
	public void setJsr(String jsr) {
		this.jsr = jsr;
	}
	public String getQsr() {
		return qsr;
	}
	public void setQsr(String qsr) {
		this.qsr = qsr;
	}
	public String getJsqk() {
		return jsqk;
	}
	public void setJsqk(String jsqk) {
		this.jsqk = jsqk;
	}
	

	
	
}