/**
  * Copyright 2018 bejson.com 
  */
package com.cd.zjyf.pojo.qr.HomePage;

import com.cd.zjyf.utils.CommonUtil;

import java.math.BigDecimal;

/**
 * Auto-generated: 2018-02-06 9:57:5
 *医疗废物重量/医疗机构趋势图
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class QST {
		private String year;    //年份
		private BigDecimal zl=CommonUtil.getDeafualtBigDecimal();//重量（吨）
		private int jgs;     //机构数
		public String getYear() {
			return year;
		}
		public void setYear(String year) {
			this.year = year;
		}
		public BigDecimal getZl() {
			return zl;
		}
		public void setZl(BigDecimal zl) {
			this.zl = zl;
		}
		public int getJgs() {
			return jgs;
		}
		public void setJgs(int jgs) {
			this.jgs = jgs;
		}
		
		
}