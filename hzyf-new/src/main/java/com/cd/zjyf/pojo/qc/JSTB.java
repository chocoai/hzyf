/**
 * Copyright 2018 bejson.com
 */
package com.cd.zjyf.pojo.qc;

import com.cd.zjyf.pojo.LoginUserInfo;
import com.cd.zjyf.utils.CommonUtil;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * Auto-generated: 2018-02-06 9:57:5
 *接收同比
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class JSTB extends LoginUserInfo{



    private Date beginTime;

    private Date endTime;

    private String xzqh;

    private String month;

    private int xzqhLevel;

    public int getXzqhLevel() {
        return xzqhLevel;
    }

    public void setXzqhLevel(int xzqhLevel) {
        this.xzqhLevel = xzqhLevel;
    }

    public String getXzqh() {
        return xzqh;
    }

    public void setXzqh(String xzqh) {
        this.xzqh = xzqh;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
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
}