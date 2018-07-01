/**
  * Copyright 2018 bejson.com 
  */
package com.cd.zjyf.pojo.qc;

import com.cd.zjyf.pojo.LoginUserInfo;
import com.cd.zjyf.utils.CommonUtil;
import com.cd.zjyf.utils.Constant;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Auto-generated: 2018-02-06 10:6:36
 *接收情况
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class JSQK extends LoginUserInfo {



    public String xzqh;  //行政区划
    public Date beginTime;//	开始统计时间
    public Date endTime;//	结束统计时间
    public List<String> zcd;  //  暂存点
    public String csd;//产生点
    public String jsqk;//清算情况

    private String jstimeOrder;//页面时间排序

    public String getJstimeOrder() {
        return jstimeOrder;
    }

    public void setJstimeOrder(String jstimeOrder) {
        this.jstimeOrder = jstimeOrder;
    }

    public String getJsqk() {
        return jsqk;
    }

    public void setJsqk(String jsqk) {
        this.jsqk = jsqk;
    }

    public String getCsd() {
        return csd;
    }

    public void setCsd(String csd) {
        this.csd = csd;
    }

    public String getXzqh() {
        return xzqh;
    }

    public void setXzqh(String xzqh) {
        this.xzqh = xzqh;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public List<String> getZcd() {
        return zcd;
    }

    public void setZcd(List<String> zcd) {
        this.zcd = zcd;
    }
}