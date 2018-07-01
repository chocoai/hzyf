package com.cd.zjyf.enums;

/**
 * @author chen.shuodong
 *报表模板路径枚举
 */
public enum ReportTemplateEnum {

	YLJG("医疗机构管理","yljg"),
	JSMX("接收明细","jsmx"),
	JSQK("接收情况","jsqk"),
	SDL("送达率","sdl"),
	RY("人员管理","ry");
	//EMERGENCYSTAT("应急医疗处置月报表","EmergencyStat"),
	//EMERGENCYTOTAL("非在管应急医疗处置月报表","EmergencyTotal"),
	
	
	//public final static String BASE_BATH="report/templates/";

	//public final static String SUFFIX=".xls";

	public final static String REPORT_TEMPLATE_BATH="/report/templates/reportTemplate.xls";

	// 成员变量
	private String name;//模板名
	private String sheet;//sheet名


	private ReportTemplateEnum(String name, String sheet) {
		this.name=name;
		this.sheet=sheet;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getSheet() {
		return sheet;
	}


	public void setSheet(String sheet) {
		this.sheet = sheet;
	}




}
