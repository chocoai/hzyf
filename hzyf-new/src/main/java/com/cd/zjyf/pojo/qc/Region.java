package com.cd.zjyf.pojo.qc;

import com.cd.zjyf.pojo.PageParam;

import java.util.Arrays;
import java.util.List;

/**
 * 查询的地区bean
 * @author chen.shuodong
 *
 */
public class Region extends PageParam {
	private String id;//各种id
	private String regionCode;//区域代码
	private int level;//区域级别
	private String sqlFun;//动态的sql方法
	private String sqlFun2;//与sqlfun差不多，不过方法里面的对象属性不同
	
	private String sqlSegment;//sql片段
	private String sqlSegment1;//sql片段1
	
	private String zdType;//信息类型（1暂存点2产生点3在线收集员）
	private List<String> zdTypes;
	
	
	
	public String getRegionCode() {
		//return regionCode+",";//补个逗号，避免产生本级地区
		return regionCode;
	}
	public void setRegionCode(String regionCode) {
		this.regionCode = regionCode;
	}
	
	public int getLevel() {
		return level=getLevelByRegionCode(regionCode);
	}
	public void setLevel(int level) {
		this.level = level;
	}
	private int getLevelByRegionCode(String regionCode) {
		return regionCode!=null?regionCode.split(",").length:0;
		//return regionCode.split(",").length;
	}
	
	public String getSqlFun() {
		if(regionCode==null) return null;
		int level = regionCode.split(",").length;
		if(level==1) {
			sqlFun="fun_tocity(dwdzbm)";
		}else if(level==2) {
			sqlFun="fun_toarea(dwdzbm)";
		}else {
			sqlFun="dwdzbm";
		}
		
		return sqlFun;
	}
	
	public void setSqlFun(String sqlFun) {
		this.sqlFun = sqlFun;
	}
	
	public String getSqlFun2() {
		if(regionCode==null) return null;
		int level = regionCode.split(",").length;
		if(level==1) {
			sqlFun2="fun_tocity(code)";
		}else if(level==2) {
			sqlFun2="fun_toarea(code)";
		}else {
			sqlFun2="code";
		}
		return sqlFun2;
	}
	
	public void setSqlFun2(String sqlFun2) {
		this.sqlFun2 = sqlFun2;
	}
	
	public String getSqlSegment() {
		return sqlSegment;
	}
	public void setSqlSegment(String sqlSegment) {
		this.sqlSegment = sqlSegment;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getZdType() {
		return zdType;
	}
	public void setZdType(String zdType) {
		this.zdType = zdType;
	}
	
	public List<String> getZdTypes() {
		if(zdType==null) return null;
		return	Arrays.asList(zdType.split(","));
	}
	
	public void setZdTypes(List<String> zdTypes) {
		this.zdTypes = zdTypes;
	}
	public String getsqlSegment1() {
		return sqlSegment1;
	}
	public void setsqlSegment1(String sqlSegment1) {
		this.sqlSegment1 = sqlSegment1;
	}

	
}
