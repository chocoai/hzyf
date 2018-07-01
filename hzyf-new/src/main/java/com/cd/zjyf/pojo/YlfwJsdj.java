package com.cd.zjyf.pojo;
/**
 * 跟jo类就时间注解不同，这里截取到分，返回到页面上
 */
import java.math.BigDecimal;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class YlfwJsdj {
    private String id;//接收登记表主键

    private String csdid;//产生点id

    private String zcdid;//暂存点id

    private Date jstime;//接收时间

    private String lx;//类型

    private BigDecimal sl;//数量

    private BigDecimal zl;//重量

    private String jsqk;//接收情况

    private String jjly;//接收理由
    
    private Date endtime;//清算时间

    private String qsrid;//运输者id

    private String tgzid;//交接员id

    private String jsrid;//接收者id

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getCsdid() {
        return csdid;
    }

    public void setCsdid(String csdid) {
        this.csdid = csdid == null ? null : csdid.trim();
    }

    public String getZcdid() {
        return zcdid;
    }

    public void setZcdid(String zcdid) {
        this.zcdid = zcdid == null ? null : zcdid.trim();
    }

	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm")
    public Date getJstime() {
        return jstime;
    }

    public void setJstime(Date jstime) {
        this.jstime = jstime;
    }

    public String getLx() {
        return lx;
    }

    public void setLx(String lx) {
        this.lx = lx == null ? null : lx.trim();
    }

    public BigDecimal getSl() {
        return sl;
    }

    public void setSl(BigDecimal sl) {
        this.sl = sl;
    }

    public BigDecimal getZl() {
        return zl;
    }

    public void setZl(BigDecimal zl) {
        this.zl = zl;
    }

    public String getJsqk() {
        return jsqk;
    }

    public void setJsqk(String jsqk) {
        this.jsqk = jsqk == null ? null : jsqk.trim();
    }

    public String getJjly() {
        return jjly;
    }

    public void setJjly(String jjly) {
        this.jjly = jjly == null ? null : jjly.trim();
    }

	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm")
    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public String getQsrid() {
        return qsrid;
    }

    public void setQsrid(String qsrid) {
        this.qsrid = qsrid == null ? null : qsrid.trim();
    }

    public String getTgzid() {
        return tgzid;
    }

    public void setTgzid(String tgzid) {
        this.tgzid = tgzid == null ? null : tgzid.trim();
    }

    public String getJsrid() {
        return jsrid;
    }

    public void setJsrid(String jsrid) {
        this.jsrid = jsrid == null ? null : jsrid.trim();
    }
}