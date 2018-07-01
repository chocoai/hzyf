/**
  * Copyright 2018 bejson.com 
  */
package com.cd.zjyf.pojo.qr;

import com.cd.zjyf.utils.CommonUtil;

import java.math.BigDecimal;
import java.util.List;

/**
 * Auto-generated: 2018-02-06 9:57:5
 * 地区产生点列表
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class CSDlist {
	private String id;//产生点主键

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	private String name ;//产生点名称

	private String dwmc;//也是产生点名称

	private BigDecimal zl= CommonUtil.getDeafualtBigDecimal();//接收重量

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