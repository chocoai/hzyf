package com.cd.zjyf.pojo.qc;

import com.cd.zjyf.pojo.PageParam;

/**
 * @author chen.shuodong
 *交接员的废物统计
 */
public class SJZhistoryListQC extends PageParam {
	private String	csdid;  //产生点主键
	private String	jssjStart;  //接收时间开始
	private String	jssjEnd;  //接收时间结束
	private String	lx;  //医疗废物类型
	private String jsrid;//接收人id
	public String getCsdid() {
		return csdid;
	}
	public void setCsdid(String csdid) {
		this.csdid = csdid;
	}
	public String getJssjStart() {
		return jssjStart;
	}
	public void setJssjStart(String jssjStart) {
		this.jssjStart = jssjStart;
	}
	public String getJssjEnd() {
		return jssjEnd;
	}
	public void setJssjEnd(String jssjEnd) {
		this.jssjEnd = jssjEnd;
	}
	public String getLx() {
		return lx;
	}
	public void setLx(String lx) {
		this.lx = lx;
	}
	public String getJsrid() {
		return jsrid;
	}
	public void setJsrid(String jsrid) {
		this.jsrid = jsrid;
	}

	   
		
}
