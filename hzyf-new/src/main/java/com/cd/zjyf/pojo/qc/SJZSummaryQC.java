package com.cd.zjyf.pojo.qc;

/**
 * 接收者扫码和接收历史
 * @author chen.shuodong
 *
 */
public class SJZSummaryQC {
	private String id;//暂存点id
	private String jsqk;
	private String qsrid;//运输者id
	public String getJsqk() {
		return jsqk;
	}
	public void setJsqk(String jsqk) {
		this.jsqk = jsqk;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the qsrid
	 */
	public String getQsrid() {
		return qsrid;
	}
	/**
	 * @param qsrid the qsrid to set
	 */
	public void setQsrid(String qsrid) {
		this.qsrid = qsrid;
	}
	

}
