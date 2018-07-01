package com.cd.zjyf.pojo.qc;

import com.cd.zjyf.pojo.LoginUserInfo;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Created by chen.shuodong on 2018/4/12.
 *     产生点送达率汇总表

 */
public class SDL extends LoginUserInfo{

    private String xzqh;  //行政区划
    private Date beginTime;//	开始统计时间
    private Date endTime;//	结束统计时间
    private String zcd;  //  暂存点
    private String csd;//产生点
    private String sjl;//收集率

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

    public String getzcd() {
        return zcd;
    }

    public void setzcd(String zcd) {
        this.zcd = zcd;
    }

    public String getZcd() {
        return zcd;
    }

    public void setZcd(String zcd) {
        this.zcd = zcd;
    }

    public String getCsd() {
        return csd;
    }

    public void setCsd(String csd) {
        this.csd = csd;
    }

    public String getSjl() {
        return sjl;
    }

    public void setSjl(String sjl) {
        this.sjl = sjl;
    }
}
