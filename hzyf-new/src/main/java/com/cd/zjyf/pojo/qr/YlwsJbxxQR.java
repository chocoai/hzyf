package com.cd.zjyf.pojo.qr;

import com.cd.zjyf.annotation.Invalid;
import com.cd.zjyf.pojo.LoginUserInfo;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class YlwsJbxxQR   {

    @Invalid
    private String id;

    private String dwmc;//单位名称

    private String yljgtype;//医疗机构类型

    private String dwdz;//单位地址


    private String jgdwmc;//所属机构（监管单位名称）


    @Invalid
    private String dwjc;//单位名称

    @Invalid
    private String dwdzbm;//单位地址编码

    @Invalid
    private String zcdid;//暂存点id

    @Invalid
    private String zcdmc;//暂存点名称

    @Invalid
    private String qrcode;

    @Invalid
    private String yyzt;//营业状态

    @Invalid
    private String djrid;//登记人id

    @Invalid
    private Date djsj;//登记时间

    @Invalid
    private String jgdwid;//监管单位id

    public String getZcdmc() {
        return zcdmc;
    }

    public void setZcdmc(String zcdmc) {
        this.zcdmc = zcdmc;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }


    public String getJgdwmc() {
        return jgdwmc;
    }

    public void setJgdwmc(String jgdwmc) {
        this.jgdwmc = jgdwmc;
    }

    public String getYljgtype() {
        return yljgtype;
    }

    public void setYljgtype(String yljgtype) {
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
    
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
   // @DateTimeFormat(pattern = "yyyy-MM-dd")
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