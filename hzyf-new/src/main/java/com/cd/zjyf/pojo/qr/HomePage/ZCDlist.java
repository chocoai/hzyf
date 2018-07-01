/**
  * Copyright 2018 bejson.com 
  */
package com.cd.zjyf.pojo.qr.HomePage;

import com.cd.zjyf.utils.CommonUtil;

import java.math.BigDecimal;

/**
 * Auto-generated: 2018-02-06 9:57:5
 * 地区暂存点列表
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class ZCDlist {
	private String dwmc ;//暂存点名称
	private String  name;//所属区域
	private BigDecimal zl=CommonUtil.getDeafualtBigDecimal();//当前重量
	
	public String getDwmc() {
		return dwmc;
	}
	public void setDwmc(String dwmc) {
		this.dwmc = dwmc;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public BigDecimal getZl() {
		return zl;
	}
	public void setZl(BigDecimal zl) {
		this.zl = zl;
	}
	
	
	
}