/**
  * Copyright 2018 bejson.com 
  */
package com.cd.zjyf.pojo.qr;

import com.cd.zjyf.utils.CommonUtil;

import java.math.BigDecimal;

/**
 * Auto-generated: 2018-02-06 9:57:5
 * 智能监管
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class ZNJG {
	private int csd ;//产生点数量
	private BigDecimal zcd=CommonUtil.getDeafualtBigDecimal();//暂存点
	private BigDecimal zl=CommonUtil.getDeafualtBigDecimal();//重量
	private int car;//运输车辆数
	
	public int getCsd() {
		return csd;
	}
	public void setCsd(int csd) {
		this.csd = csd;
	}
	public BigDecimal getZcd() {
		return zcd;
	}
	public void setZcd(BigDecimal zcd) {
		this.zcd = zcd;
	}
	public BigDecimal getZl() {
		return zl;
	}
	public void setZl(BigDecimal zl) {
		this.zl = zl;
	}
	public int getCar() {
		return car;
	}
	public void setCar(int car) {
		this.car = car;
	}
	
	
}