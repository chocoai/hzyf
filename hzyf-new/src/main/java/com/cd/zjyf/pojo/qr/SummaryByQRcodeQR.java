package com.cd.zjyf.pojo.qr;

import com.cd.zjyf.utils.CommonUtil;

import java.math.BigDecimal;

/**
 * @author chen.shuodong
 *扫描汇总，包括运输者的清算
 */
public class SummaryByQRcodeQR {
	private String zcdmc;//暂存点名称
    private String csdmc;//产生点名称
    
    private String jscs="0";//接收次数
    
    private BigDecimal jszl=	CommonUtil.getDeafualtBigDecimal();//重量;//接收重量
    
    private String jssl="0";//接收数量
    
    private BigDecimal ssxfwzl=CommonUtil.getDeafualtBigDecimal();//各类废物数量
    
    private String ssxfwsl="0";
    
    private BigDecimal blxfwzl=	CommonUtil.getDeafualtBigDecimal();//重量;
    
    private String blxfwsl="0";
    
    private BigDecimal grxfwzl=	CommonUtil.getDeafualtBigDecimal();//重量;
    
    private String grxfwsl="0";
    
    private BigDecimal hxxfwzl=	CommonUtil.getDeafualtBigDecimal();//重量;
    
    private String hxxfwsl="0";
    
    private BigDecimal ywxfwzl=	CommonUtil.getDeafualtBigDecimal();//重量;
    
    private String ywxfwsl="0";
    
    private String qsrxm;//运输者姓名，扫运输者二维码时候，强入
    
    private String qsrid;
    
    private String zcdid;//暂存点id
    
	public String getQsrxm() {
		return qsrxm;
	}
	public void setQsrxm(String qsrxm) {
		this.qsrxm = qsrxm;
	}
	public String getQsrid() {
		return qsrid;
	}
	public void setQsrid(String qsrid) {
		this.qsrid = qsrid;
	}
	public String getZcdmc() {
		return zcdmc;
	}
	public void setZcdmc(String zcdmc) {
		this.zcdmc = zcdmc;
	}
	public String getCsdmc() {
		return csdmc;
	}
	public void setCsdmc(String csdmc) {
		this.csdmc = csdmc;
	}
	public String getJscs() {
		return jscs;
	}
	public void setJscs(String jscs) {
		this.jscs = jscs;
	}
	public BigDecimal getJszl() {
		return jszl;
	}
	public void setJszl(BigDecimal jszl) {
		this.jszl = jszl;
	}
	public String getJssl() {
		return jssl;
	}
	public void setJssl(String jssl) {
		this.jssl = jssl;
	}
	public BigDecimal getSsxfwzl() {
		return ssxfwzl;
	}
	public void setSsxfwzl(BigDecimal ssxfwzl) {
		this.ssxfwzl = ssxfwzl;
	}
	public String getSsxfwsl() {
		return ssxfwsl;
	}
	public void setSsxfwsl(String ssxfwsl) {
		this.ssxfwsl = ssxfwsl;
	}
	public BigDecimal getBlxfwzl() {
		return blxfwzl;
	}
	public void setBlxfwzl(BigDecimal blxfwzl) {
		this.blxfwzl = blxfwzl;
	}
	public String getBlxfwsl() {
		return blxfwsl;
	}
	public void setBlxfwsl(String blxfwsl) {
		this.blxfwsl = blxfwsl;
	}
	public BigDecimal getGrxfwzl() {
		return grxfwzl;
	}
	public void setGrxfwzl(BigDecimal grxfwzl) {
		this.grxfwzl = grxfwzl;
	}
	public String getGrxfwsl() {
		return grxfwsl;
	}
	public void setGrxfwsl(String grxfwsl) {
		this.grxfwsl = grxfwsl;
	}
	public BigDecimal getHxxfwzl() {
		return hxxfwzl;
	}
	public void setHxxfwzl(BigDecimal hxxfwzl) {
		this.hxxfwzl = hxxfwzl;
	}
	public String getHxxfwsl() {
		return hxxfwsl;
	}
	public void setHxxfwsl(String hxxfwsl) {
		this.hxxfwsl = hxxfwsl;
	}
	public BigDecimal getYwxfwzl() {
		return ywxfwzl;
	}
	public void setYwxfwzl(BigDecimal ywxfwzl) {
		this.ywxfwzl = ywxfwzl;
	}
	public String getYwxfwsl() {
		return ywxfwsl;
	}
	public void setYwxfwsl(String ywxfwsl) {
		this.ywxfwsl = ywxfwsl;
	}
	public String getZcdid() {
		return zcdid;
	}
	public void setZcdid(String zcdid) {
		this.zcdid = zcdid;
	}
    
    
    
}
