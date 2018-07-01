package com.cd.zjyf.pojo.qc;

/**
 * @author chen.shuodong
 *管理者统计查询条件
 */
public class GLZstatisticsQC {
	private String id;//管理者id
	private String endtimeBegin;
	private String endtimeEnd;
	private String xzqh;//行政区划码
	private String bmjb;//行政区划级别

	private String type;//统计类型 （1地区，2暂存点，3产生点）
	private String jstimeBegin;//接收开始时间
	private String jstimeEnd;
	private String dwid;//机构
	private String dwmc;//机构名称

	public String getDwid() {
		return dwid;
	}

	public void setDwid(String dwid) {
		this.dwid = dwid;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getJstimeBegin() {
		return jstimeBegin;
	}

	public void setJstimeBegin(String jstimeBegin) {
		this.jstimeBegin = jstimeBegin;
	}

	public String getJstimeEnd() {
		return jstimeEnd;
	}

	public void setJstimeEnd(String jstimeEnd) {
		this.jstimeEnd = jstimeEnd;
	}

	public String getDwmc() {
		return dwmc;
	}

	public void setDwmc(String dwmc) {
		this.dwmc = dwmc;
	}

	public String getBmjb() {
		return bmjb;
	}

	public void setBmjb(String bmjb) {
		this.bmjb = bmjb;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getEndtimeBegin() {
		return endtimeBegin;
	}
	public void setEndtimeBegin(String endtimeBegin) {
		this.endtimeBegin = endtimeBegin;
	}
	public String getEndtimeEnd() {
		return endtimeEnd;
	}
	public void setEndtimeEnd(String endtimeEnd) {
		this.endtimeEnd = endtimeEnd;
	}
	public String getXzqh() {
		return xzqh;
	}
	public void setXzqh(String xzqh) {
		this.xzqh = xzqh;
	}
	
	
}
