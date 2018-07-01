package com.cd.zjyf.pojo.qr;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author chen.shuodong
 *交接员通过扫描二维码获取的结果，QR表示二维码
 */
public class SJZqueryByQRcodeQR {
	private String	zcdmc;  //暂存点名称
	private String	zcdid;  //暂存点主键
	private String	csdmc;  //产生点名称
	private String	csdid;  //产生点主键
	private String	tgzxm;  //交接员姓名
	private String	tgzid;  //交接员主键
	private String	id;  //本次收集信息主键
	//以下这几个字段可以作为历史查询复用
	private String lx;//废物类型
	private String sl;//数量
	 private BigDecimal zl;//重量

	private Date jstime;//接收时间
	
	public String getLx() {
		return lx;
	}
	public void setLx(String lx) {
		this.lx = lx;
	}
	public String getSl() {
		return sl;
	}
	public void setSl(String sl) {
		this.sl = sl;
	}
	public BigDecimal getZl() {
		return zl;
	}
	public void setZl(BigDecimal zl) {
		this.zl = zl;
	}
	public String getZcdmc() {
		return zcdmc;
	}
	public void setZcdmc(String zcdmc) {
		this.zcdmc = zcdmc;
	}
	public String getZcdid() {
		return zcdid;
	}
	public void setZcdid(String zcdid) {
		this.zcdid = zcdid;
	}
	public String getCsdmc() {
		return csdmc;
	}
	public void setCsdmc(String csdmc) {
		this.csdmc = csdmc;
	}
	public String getCsdid() {
		return csdid;
	}
	public void setCsdid(String csdid) {
		this.csdid = csdid;
	}
	public String getTgzxm() {
		return tgzxm;
	}
	public void setTgzxm(String tgzxm) {
		this.tgzxm = tgzxm;
	}
	public String getTgzid() {
		return tgzid;
	}
	public void setTgzid(String tgzid) {
		this.tgzid = tgzid;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the jstime
	 */
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getJstime() {
		return jstime;
	}
	/**
	 * @param jstime the jstime to set
	 */
	public void setJstime(Date jstime) {
		this.jstime = jstime;
	}
	
	
	
}
