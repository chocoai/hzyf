package com.cd.zjyf.pojo.qr;

import com.cd.zjyf.utils.CommonUtil;

import java.math.BigDecimal;

/**
 * @author chen.shuodong
 *管理者统计
 */
public class GLZstatisticsQR {
	private String name;//行政区划名
	private BigDecimal zl=CommonUtil.getDeafualtBigDecimal();//重量
	
	public BigDecimal getZl() {
		return zl;
	}
	public void setZl(BigDecimal zl) {
		this.zl = zl;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	
}
