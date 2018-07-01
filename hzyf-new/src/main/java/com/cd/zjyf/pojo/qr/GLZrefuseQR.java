package com.cd.zjyf.pojo.qr;

import com.cd.zjyf.utils.CommonUtil;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author chen.shuodong 管理者拒收列表
 */
public class GLZrefuseQR {
	private String id;// 接收表id
	private String dwmc;// 单位名称
	private String jjly;// 拒接理由
	private Date endtime;//结算时间
	private BigDecimal zl=CommonUtil.getDeafualtBigDecimal();//拒绝重量

	private String lx;//拒接类型
	
	
	
	public BigDecimal getZl() {
		return zl;
	}

	public void setZl(BigDecimal zl) {
		this.zl = zl;
	}

	public String getLx() {
		return lx;
	}

	public void setLx(String lx) {
		this.lx = lx;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDwmc() {
		return dwmc;
	}

	public void setDwmc(String dwmc) {
		this.dwmc = dwmc;
	}

	public String getJjly() {
		return jjly;
	}

	public void setJjly(String jjly) {
		this.jjly = jjly;
	}

	/**
	 * @return the endtime
	 */
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm")
	public Date getEndtime() {
		return endtime;
	}

	/**
	 * @param endtime the endtime to set
	 */
	public void setEndtime(Date endtime) {
		this.endtime = endtime;
	}

}
