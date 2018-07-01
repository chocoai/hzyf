package com.cd.zjyf.pojo.qr;

import com.cd.zjyf.utils.CommonUtil;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author chen.shuodong
 *管理者统计大对象
 */
public class GLZstat {


		private List<GLZstatisticsQR> gLZstatisticsQR=new ArrayList<>(); //按地区统计

		private String zcdmc;//暂存点名称



	private BigDecimal zl=CommonUtil.getDeafualtBigDecimal();//总重量

		private BigDecimal wqs=CommonUtil.getDeafualtBigDecimal();//未清算

		private BigDecimal yqs=CommonUtil.getDeafualtBigDecimal();//已清算

		private List<CSDlist> cSDlist; //产生点列表


	public List<GLZstatisticsQR> getgLZstatisticsQR() {
		return gLZstatisticsQR;
	}

	public void setgLZstatisticsQR(List<GLZstatisticsQR> gLZstatisticsQR) {
		this.gLZstatisticsQR = gLZstatisticsQR;
	}

	public String getZcdmc() {
		return zcdmc;
	}

	public void setZcdmc(String zcdmc) {
		this.zcdmc = zcdmc;
	}



	public void setcSDlist(List<CSDlist> cSDlist) {
		this.cSDlist = cSDlist;
	}

	public BigDecimal getZl() {
		return zl;
	}

	public void setZl(BigDecimal zl) {
		this.zl = zl;
	}

	public BigDecimal getWqs() {
		return wqs;
	}

	public void setWqs(BigDecimal wqs) {
		this.wqs = wqs;
	}

	public BigDecimal getYqs() {
		return yqs;
	}

	public void setYqs(BigDecimal yqs) {
		this.yqs = yqs;
	}

	public List<CSDlist> getcSDlist() {
		return cSDlist;
	}
}
