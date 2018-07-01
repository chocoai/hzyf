package com.cd.zjyf.pojo.qr;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * @author chen.shuodong
 *运输者首页列表
 */
public class GLZindexQR {
	  private String zcdmc;//暂存点名称
	  private Date zjjssj;//最近接收时间

	public String getZcdmc() {
		return zcdmc;
	}
	public void setZcdmc(String zcdmc) {
		this.zcdmc = zcdmc;
	}
	/**
	 * @return the zjjssj
	 */
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm")
	public Date getZjjssj() {
		return zjjssj;
	}
	/**
	 * @param zjjssj the zjjssj to set
	 */
	public void setZjjssj(Date zjjssj) {
		this.zjjssj = zjjssj;
	}
	
	
}
