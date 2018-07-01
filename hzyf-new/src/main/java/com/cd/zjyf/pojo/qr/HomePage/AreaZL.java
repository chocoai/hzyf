/**
  * Copyright 2018 bejson.com 
  */
package com.cd.zjyf.pojo.qr.HomePage;

import com.cd.zjyf.utils.CommonUtil;

import java.math.BigDecimal;

/**
 * Auto-generated: 2018-02-06 9:57:5
 * 今年收集各地区重量
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class AreaZL {
	private String code ;//区域编码
	private String  name;//所属区域
	private BigDecimal zl=CommonUtil.getDeafualtBigDecimal();//重量
	
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
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	
	
}