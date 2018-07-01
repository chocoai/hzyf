package com.cd.zjyf.bean;

import java.util.Date;

public class YlwsJbxx {
    private String id;

    private String shyxdm;

    private Short yljgtype;

    private String dwmc;

    private String dwjc;

    private String dwdz;

    private String dwdzbm;

    private String zcdid;

    private String qrcode;

    private String yyzt;

    private String djrid;

    private Date djsj;

    private String jgdwid;

    private String isSewage;

    private String isdelete;

    private String isMonitor;//是否关联监控

    private String regionUuid;//区域编码

    private String parentUuid;//父级区域编码

    public String getIsSewage() {
        return isSewage;
    }

    public void setIsSewage(String isSewage) {
        this.isSewage = isSewage;
    }

    public String getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(String isdelete) {
        this.isdelete = isdelete;
    }

    public String getIsMonitor() {
        return isMonitor;
    }

    public void setIsMonitor(String isMonitor) {
        this.isMonitor = isMonitor;
    }

    public String getRegionUuid() {
        return regionUuid;
    }

    public void setRegionUuid(String regionUuid) {
        this.regionUuid = regionUuid;
    }

    public String getParentUuid() {
        return parentUuid;
    }

    public void setParentUuid(String parentUuid) {
        this.parentUuid = parentUuid;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getShyxdm() {
        return shyxdm;
    }

    public void setShyxdm(String shyxdm) {
        this.shyxdm = shyxdm == null ? null : shyxdm.trim();
    }

    public Short getYljgtype() {
        return yljgtype;
    }

    public void setYljgtype(Short yljgtype) {
        this.yljgtype = yljgtype;
    }

    public String getDwmc() {
        return dwmc;
    }

    public void setDwmc(String dwmc) {
        this.dwmc = dwmc == null ? null : dwmc.trim();
    }

    public String getDwjc() {
        return dwjc;
    }

    public void setDwjc(String dwjc) {
        this.dwjc = dwjc == null ? null : dwjc.trim();
    }

    public String getDwdz() {
        return dwdz;
    }

    public void setDwdz(String dwdz) {
        this.dwdz = dwdz == null ? null : dwdz.trim();
    }

    public String getDwdzbm() {
        return dwdzbm;
    }

    public void setDwdzbm(String dwdzbm) {
        this.dwdzbm = dwdzbm == null ? null : dwdzbm.trim();
    }

    public String getZcdid() {
        return zcdid;
    }

    public void setZcdid(String zcdid) {
        this.zcdid = zcdid == null ? null : zcdid.trim();
    }

    public String getQrcode() {
        return qrcode;
    }

    public void setQrcode(String qrcode) {
        this.qrcode = qrcode == null ? null : qrcode.trim();
    }

    public String getYyzt() {
        return yyzt;
    }

    public void setYyzt(String yyzt) {
        this.yyzt = yyzt == null ? null : yyzt.trim();
    }

    public String getDjrid() {
        return djrid;
    }

    public void setDjrid(String djrid) {
        this.djrid = djrid == null ? null : djrid.trim();
    }

    public Date getDjsj() {
        return djsj;
    }

    public void setDjsj(Date djsj) {
        this.djsj = djsj;
    }

    public String getJgdwid() {
        return jgdwid;
    }

    public void setJgdwid(String jgdwid) {
        this.jgdwid = jgdwid == null ? null : jgdwid.trim();
    }
}