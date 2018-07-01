package com.cd.zjyf.pojo.qr;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * @author chen.shuodong
 *收集员者首页列表
 */
public class SJZindexQR {
	private String csdmc;//产生点单位名称
	private Date jstime;//接收时间  
	private String tgzxm;//交接员姓名
	
	public String getCsdmc() {
		return csdmc;
	}
	public void setCsdmc(String csdmc) {
		this.csdmc = csdmc;
	}
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm")
	public Date getJstime() {
		return jstime;
	}
	public void setJstime(Date jstime) {
		this.jstime = jstime;
	}
	public String getTgzxm() {
		return tgzxm;
	}
	public void setTgzxm(String tgzxm) {
		this.tgzxm = tgzxm;
	}
	
	 
	
	
	
}
