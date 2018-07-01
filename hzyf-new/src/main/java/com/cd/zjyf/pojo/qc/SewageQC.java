package com.cd.zjyf.pojo.qc;

import com.cd.zjyf.pojo.LoginUserInfo;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class SewageQC extends LoginUserInfo {

    private String yljgid;//医疗机构id

    private String xzqh;//行政区划

    private String dwmc;//单位名称

    private String dwjc;//单位名称

    private String year;//年份

    private String uploadUser;//上传用户

    private String state;//上传状态

    public String getYljgid() {
        return yljgid;
    }

    public void setYljgid(String yljgid) {
        this.yljgid = yljgid;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getXzqh() {
        return xzqh;
    }

    public void setXzqh(String xzqh) {
        this.xzqh = xzqh;
    }

    public String getDwmc() {
        return dwmc;
    }

    public void setDwmc(String dwmc) {
        this.dwmc = dwmc;
    }

    public String getDwjc() {
        return dwjc;
    }

    public void setDwjc(String dwjc) {
        this.dwjc = dwjc;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getUploadUser() {
        return uploadUser;
    }

    public void setUploadUser(String uploadUser) {
        this.uploadUser = uploadUser;
    }
}