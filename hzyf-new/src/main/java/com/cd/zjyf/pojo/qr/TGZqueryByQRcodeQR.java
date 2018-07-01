package com.cd.zjyf.pojo.qr;

/**
 * @author chen.shuodong
 *交接员通过扫描二维码获取的结果，QR表示二维码
 */
public class TGZqueryByQRcodeQR {
	private String id;//产生点单位主键
	private String dwmc;//暂存点单位名称（不可修改）
	private String ksmc;//产生点名称（不可修改）
	private String xm;//用户姓名 这个字段其实在扫描的时候是没用的，不用返回给前端。绑定时候由前端输入
	private String userid;//用户名
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDwmc() {
		return dwmc;
	}
	public void setDwmc(String dwmc) {
		this.dwmc = dwmc;
	}
	public String getKsmc() {
		return ksmc;
	}
	public void setKsmc(String ksmc) {
		this.ksmc = ksmc;
	}
	public String getXm() {
		return xm;
	}
	public void setXm(String xm) {
		this.xm = xm;
	}
	/**
	 * @return the userid
	 */
	public String getUserid() {
		return userid;
	}
	/**
	 * @param userid the userid to set
	 */
	public void setUserid(String userid) {
		this.userid = userid;
	}
	
	
	
}
