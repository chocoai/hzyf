package com.cd.zjyf.pojo.qr;

import com.cd.zjyf.utils.CommonUtil;

import java.math.BigDecimal;

/**
 * @author chen.shuodong
 *交接员的废物统计
 */
public class TGZstatisticsFWQR {
		private String lx;//类型
		
		
		private BigDecimal zl=CommonUtil.getDeafualtBigDecimal();//重量
		private String cs="0";//次数
		
		
		public TGZstatisticsFWQR() {}
		
		public TGZstatisticsFWQR(String lx) {
			super();
			this.lx = lx;
		}
		public String getLx() {
			return lx;
		}
		public void setLx(String lx) {
			this.lx = lx;
		}
		public BigDecimal getZl() {
			return zl;
		}
		public void setZl(BigDecimal zl) {
			this.zl = zl;
		}
		public String getCs() {
			return cs;
		}
		public void setCs(String cs) {
			this.cs = cs;
		}
		
		
		
}
