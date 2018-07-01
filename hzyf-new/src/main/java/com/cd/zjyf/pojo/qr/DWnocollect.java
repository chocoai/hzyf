/**
  * Copyright 2018 bejson.com 
  */
package com.cd.zjyf.pojo.qr;

import com.cd.zjyf.utils.Constant;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * Auto-generated: 2018-02-06 9:57:5
 *长期未收集单位
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class DWnocollect {
    private String dwmc;//单位名称
    private Date acceptTime;//最近接收时间
    public void setDwmc(String dwmc) {
         this.dwmc = dwmc;
     }
     public String getDwmc() {
         return dwmc;
     }
     
 	@JsonFormat(timezone = "GMT+8", pattern = Constant.DATE_PATTERN1)
	public Date getAcceptTime() {
		return acceptTime;
	}
	public void setAcceptTime(Date acceptTime) {
		this.acceptTime = acceptTime;
	}

}