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
 *接收环比
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class JSHB extends LoginUserInfo{

    private int timeType;//时间类型(1年2季3月)

    private int year;//年

    private int month;//月

    private int quarter;//季度

    private Date beginTimeSql;//已处理的开始时间
    private Date endTimeSql;//已处理的结束时间

    private String xzqh;//行政区划

    public String getXzqh() {
        return xzqh;
    }

    public void setXzqh(String xzqh) {
        this.xzqh = xzqh;
    }

    /* public void translate(){
        LocalDateTime begin=null;
        LocalDateTime end=null;
        switch (timeType){
            case 1 :
                begin = LocalDateTime.of(year,1,1,0,0);
                end = LocalDateTime.of(year+1,1,1,0,0);
                break;
            case 2 :
                if(quarter==1) {
                    begin = LocalDateTime.of(year,1,1,0,0);
                    end = LocalDateTime.of(year,4,1,0,0);
                }else if(quarter==2)  {
                    begin = LocalDateTime.of(year,4,1,0,0);
                    end = LocalDateTime.of(year,7,1,0,0);
                }else if(quarter==3)  {
                    begin = LocalDateTime.of(year,7,1,0,0);
                    end = LocalDateTime.of(year,10,1,0,0);
                }else if(quarter==4)  {
                    begin = LocalDateTime.of(year,10,1,0,0);
                    end = LocalDateTime.of(year+1,1,1,0,0);
                }
                break;
            case 3 :
                begin = LocalDateTime.of(year,month,1,0,0);
                end = LocalDateTime.of(year,month+1,1,0,0);                break;
        }
        beginTimeSql= CommonUtil.convertLDTToDate(begin);
        endTimeSql= CommonUtil.convertLDTToDate(end);
    } */

    public void translate(){
        LocalDateTime begin=null;
        LocalDateTime end=null;
        switch (timeType){
            case 2:case 3:
                begin = LocalDateTime.of(year,1,1,0,0);
                end = LocalDateTime.of(year+1,1,1,0,0);
                beginTimeSql= CommonUtil.convertLDTToDate(begin);
                endTimeSql= CommonUtil.convertLDTToDate(end);
                break;
        }

    }

    public int getTimeType() {
        return timeType;
    }

    public void setTimeType(int timeType) {
        this.timeType = timeType;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getQuarter() {
        return quarter;
    }

    public void setQuarter(int quarter) {
        this.quarter = quarter;
    }

    public Date getBeginTimeSql() {
        return beginTimeSql;
    }

    public void setBeginTimeSql(Date beginTimeSql) {
        this.beginTimeSql = beginTimeSql;
    }

    public Date getEndTimeSql() {
        return endTimeSql;
    }

    public void setEndTimeSql(Date endTimeSql) {
        this.endTimeSql = endTimeSql;
    }
}