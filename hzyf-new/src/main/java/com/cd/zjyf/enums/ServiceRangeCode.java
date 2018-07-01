package com.cd.zjyf.enums;

import org.apache.commons.lang.StringUtils;

//医疗机构类型	N	N1	Y	1暂存点2科室3诊所

//营业状态	S2	N1	Y	0正常1关闭2暂停营业

//LX	类型	S2	N2	Y	01损伤性废物（锐器盒）02感染性废物03病理性废物04药物性废物05化学性废物

//人员类型	S2	N1	N	1交接员2收集员3运输者4管理员

//在岗状态	S2	N1	Y	1在岗2离岗

//是否审核	S2	N1	Y	0未审核1审核通过2审核未通过

//部门级别	S1	N1	Y	1省级2市级3县级

//是否最新版本	S2	N1	Y	1是0否

//更新类型	S2	N1	Y	1非强制更新2强制更新

//结算情况	S2	N1	Y	0未清算1已清算2拒接3拒接已处理


/**
 * 值域代码枚举
 * @author chen.shuodong
 *group组名需要保持与实体类字段名一致
 */
public enum ServiceRangeCode {

	SEWAGE_N("isSewage","0","未关联污水监测"),

	SEWAGE_Y("isSewage","1","关联污水监测"),

	SCZT_N("state","1","未上传"),

	SCZT_Y("state","0","已上传"),

	ZDTYPE_ZCD("zdType","1","暂存点"),

	ZDTYPE_CSD("zdType","2","产生点"),

	ZDTYPE_SJY("zdType","3","在线收集员"),

	HAS_MONITOR("isMonitor","1","关联了海康监控"),

	NO_MONITOR("isMonitor","0","未关联海康监控"),

	SJ("bmjb", "1", "省级"),

	SHIJ("bmjb", "2", "市级"),

	XJ("bmjb", "3", "县级"),

	SSXFW("lx", "01", "损伤性废物"),

	GRXFW("lx", "02", "感染性废物"),

	BLXFW("lx", "03", "病理性废物"),

	YWXFW("lx", "04", "药物性废物"),

	HXXFW("lx", "05", "化学性废物"),

	FORCE_TRUE("", "1", "是"),

	FORCE_FALSE("", "0", "否"),

	WJS("jsqk", "0", "未清算"),

	YJS("jsqk", "1", "已清算"),

	JJ("jsqk", "2", "拒接"),

	JJYCL("jsqk", "3", "拒接已处理"),

	TGZ("rylx", "1", "交接员"),

	SJZ("rylx", "2", "收集员"),

	YSZ("rylx", "3", "运输者"),

	GLY("rylx", "4", "监督员"),

	YYGLY("rylx", "5", "医院管理员"),

	JDGLY("rylx", "6", "监督管理员"),

	YSGLY("rylx", "7", "运输管理员"),

	WSH("issh", "0", "未审核"),

	SHTG("issh", "1", "审核通过"),

	SHWTG("issh", "2", "审核未通过"),

	DSH("issh","3","待审核"),

	S("", "1", "是"),

	F("", "0", "否"),

	ZCD("yljgtype", "1", "暂存点"),

	KS("yljgtype", "2", "科室"),

	ZS("yljgtype", "3", "诊所"),

	ZC("", "0", "正常"),

	GB("", "1", "关闭"),

	ZTYY("", "2", "暂停营业"),

	ON_GUARD("", "1", "在岗"),

	OUT_GUARD("", "2", "离岗"),

	NOT_FORCE_UPDATE("","1","非强制更新"),

	FORCE_UPDATE("","2","强制更新"),

	NO_UPDATE("","0","无需更新");  //返回给前端的枚举类型，数据库中没有



	// 成员变量
	private String group;//组名，对应实体类字段名
	private String code;//代码
	private String value;//值域

	ServiceRangeCode(String group, String code, String value) {
		this.code = code;
		this.value = value;
		this.group=group;
	}

	/**
	 * 根据业务码获得业务类型
	 *
	 * @param code
	 *            业务码
	 * @return 业务类型
	 */

	public static ServiceRangeCode getServiceCode(String group,String code) {
		ServiceRangeCode[] values = ServiceRangeCode.values();
		for (ServiceRangeCode operate : values) {
			if (operate.getCode().equals(code)&&operate.getGroup().equals(group)) {
				return operate;
			}
		}
		return null;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	/**
	 * @return the group
	 */
	public String getGroup() {
		return group;
	}

	/**
	 * @param group the group to set
	 */
	public void setGroup(String group) {
		this.group = group;
	}
}
