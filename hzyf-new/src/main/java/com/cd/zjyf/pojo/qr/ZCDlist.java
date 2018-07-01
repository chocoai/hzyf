/**
  * Copyright 2018 bejson.com 
  */
package com.cd.zjyf.pojo.qr;

import com.cd.zjyf.utils.CommonUtil;

import java.math.BigDecimal;

/**
 * Auto-generated: 2018-02-06 9:57:5
 * 地区暂存点列表
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class ZCDlist {
	private String yljgid;//医疗机构id
	private String dwmc ;//暂存点名称
	private String  name;//所属区域
	private BigDecimal zl=CommonUtil.getDeafualtBigDecimal();//当前重量
	private String indexCode;//设备ID（根据这个字段判断是否有影像）
	
	public String getYljgid() {
		return yljgid;
	}
	public void setYljgid(String yljgid) {
		this.yljgid = yljgid;
	}
	public String getIndexCode() {
		return indexCode;
	}
	public void setIndexCode(String indexCode) {
		this.indexCode = indexCode;
	}
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