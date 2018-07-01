package com.cd.zjyf.pojo.qr;

import com.cd.zjyf.utils.CommonUtil;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author chen.shuodong
 *运输者首页
 */
public class YSZindexQR {
	private String zcdid;//暂存点id 
	private String zcdmc;//暂存点名称
	  private String jscs="0";//接收次数
	  private BigDecimal jszl=CommonUtil.getDeafualtBigDecimal();//重量

	  //点入详情时候的用到的字段
	  private Date jstime;//接收时间
	  
	public String getZcdmc() {
		return zcdmc;
	}
	public void setZcdmc(String zcdmc) {
		this.zcdmc = zcdmc;
	}
	public String getJscs() {
		return jscs;
	}
	public void setJscs(String jscs) {
		this.jscs = jscs;
	}
	public BigDecimal getJszl() {
		return jszl;
	}
	public void setJszl(BigDecimal jszl) {
		this.jszl = jszl;
	}
	public String getZcdid() {
		return zcdid;
	}
	public void setZcdid(String zcdid) {
		this.zcdid = zcdid;
	}
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm")
	public Date getJstime() {
		return jstime;
	}
	public void setJstime(Date jstime) {
		this.jstime = jstime;
	}
	
	
}
