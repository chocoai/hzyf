package com.cd.zjyf.bean;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class YfappVersion {
    private String appkey;

    private Short byh;

    private String bbh;

    private String rjdx;

    private String gxsm;

    private String gxdz;

    private Date fbrq;

    private String zxbb;

    private String gxlx;

    private String cjrid;

    private Date cjsj;

    public String getAppkey() {
        return appkey;
    }

    public void setAppkey(String appkey) {
        this.appkey = appkey == null ? null : appkey.trim();
    }

    public Short getByh() {
        return byh;
    }

    public void setByh(Short byh) {
        this.byh = byh;
    }

    public String getBbh() {
        return bbh;
    }

    public void setBbh(String bbh) {
        this.bbh = bbh == null ? null : bbh.trim();
    }

    public String getRjdx() {
        return rjdx;
    }

    public void setRjdx(String rjdx) {
        this.rjdx = rjdx == null ? null : rjdx.trim();
    }

    public String getGxsm() {
        return gxsm;
    }

    public void setGxsm(String gxsm) {
        this.gxsm = gxsm == null ? null : gxsm.trim();
    }

    public String getGxdz() {
        return gxdz;
    }

    public void setGxdz(String gxdz) {
        this.gxdz = gxdz == null ? null : gxdz.trim();
    }

	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm")
    public Date getFbrq() {
        return fbrq;
    }

    public void setFbrq(Date fbrq) {
        this.fbrq = fbrq;
    }

    public String getZxbb() {
        return zxbb;
    }

    public void setZxbb(String zxbb) {
        this.zxbb = zxbb == null ? null : zxbb.trim();
    }

    public String getGxlx() {
        return gxlx;
    }

    public void setGxlx(String gxlx) {
        this.gxlx = gxlx == null ? null : gxlx.trim();
    }

    public String getCjrid() {
        return cjrid;
    }

    public void setCjrid(String cjrid) {
        this.cjrid = cjrid == null ? null : cjrid.trim();
    }

	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm")
    public Date getCjsj() {
        return cjsj;
    }

    public void setCjsj(Date cjsj) {
        this.cjsj = cjsj;
    }
}