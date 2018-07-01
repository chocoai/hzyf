package com.cd.zjyf.pojo.qr;
/**
 * 用户第一次登陆查询的补全资料列表
 * @author chen.shuodong
 *
 */
public class UserQueryDataQR {
	private String id;//监管单位或单位名称
	private String name;//监管单位或单位名称
	private String xzqh;//行政区划
	
	public UserQueryDataQR() {}
	
	public UserQueryDataQR(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getXzqh() {
		return xzqh;
	}

	public void setXzqh(String xzqh) {
		this.xzqh = xzqh;
	}
	
}
