package com.cd.zjyf.pojo.qc;

import com.cd.zjyf.pojo.LoginUserInfo;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class YlwsJbxxQC extends LoginUserInfo {

    private String xzqh;//行政区划

    private String id;

    private String shyxdm;//统一社会信用代码

    private Short yljgtype;//医疗机构类型

    private String dwmc;//单位名称

    private String dwjc;//单位名称

    private String dwdz;//单位地址

    private String dwdzbm;//单位地址编码

    private String zcdid;//暂存点id

    private String qrcode;

    private String yyzt;//营业状态

    private String djrid;//登记人id

    private Date djsj;//登记时间

    private String jgdwid;//监管单位id

    private String zcd;//暂存点

    public String getZcd() {
        return zcd;
    }

    public void setZcd(String zcd) {
        this.zcd = zcd;
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
    
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm")
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

    public String getXzqh() {
        return xzqh;
    }

    public void setXzqh(String xzqh) {
        this.xzqh = xzqh;
    }
}