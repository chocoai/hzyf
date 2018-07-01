/**
  * Copyright 2018 bejson.com 
  */
package com.cd.zjyf.pojo.qr;

import com.cd.zjyf.utils.Constant;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * Auto-generated: 2018-02-06 10:6:36
 *实际收集情况
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class SJSJQK {

	private String jsr;      //接收人
	private String tgz;      //交接员
	private String csd;      //产生点
	private String zcd;      //暂存点
	private String qsr;//清算人

	public String getQsr() {
		return qsr;
	}

	public void setQsr(String qsr) {
		this.qsr = qsr;
	}
	public String getZcd() {
		return zcd;
	}

	public void setZcd(String zcd) {
		this.zcd = zcd;
	}

	private Date jstime;   //接收实际
	public String getJsr() {
		return jsr;
	}
	public void setJsr(String jsr) {
		this.jsr = jsr;
	}
	public String getTgz() {
		return tgz;
	}
	public void setTgz(String tgz) {
		this.tgz = tgz;
	}
	public String getCsd() {
		return csd;
	}
	public void setCsd(String csd) {
		this.csd = csd;
	}
	@JsonFormat(timezone = "GMT+8", pattern = Constant.DATE_PATTERN1)
	public Date getJstime() {
		return jstime;
	}
	public void setJstime(Date jstime) {
		this.jstime = jstime;
	}
	

}