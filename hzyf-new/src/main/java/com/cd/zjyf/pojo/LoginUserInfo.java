package com.cd.zjyf.pojo;


/**
 * 用户登陆信息(双向bean)
 * Created by chen.shuodong on 2018/4/10.
 */
public class LoginUserInfo {

    private String rylx;//人员类型

    private String userid;//用户

    private String userxm;//用户姓名

    private String userxzqh;//用户行政区划

    private String issh;//审核状态

    private int level;//级别

    //针对医院管理员
    private String zcdid;//暂存点id
    private String jgdwid;//监管点位id
    private String zcdmc;//暂存点名称
    private String zcdjc;//暂存点简称
    private String isSewage;//是否有污水监测


    public String getIsSewage() {
        return isSewage;
    }

    public void setIsSewage(String isSewage) {
        this.isSewage = isSewage;
    }

    public String getZcdmc() {
        return zcdmc;
    }

    public void setZcdmc(String zcdmc) {
        this.zcdmc = zcdmc;
    }

    public String getZcdjc() {
        return zcdjc;
    }

    public void setZcdjc(String zcdjc) {
        this.zcdjc = zcdjc;
    }

    public String getZcdid() {
        return zcdid;
    }

    public void setZcdid(String zcdid) {
        this.zcdid = zcdid;
    }

    public String getJgdwid() {
        return jgdwid;
    }

    public void setJgdwid(String jgdwid) {
        this.jgdwid = jgdwid;
    }

    public int getLevel() {
        return userxzqh != null ? userxzqh.split(",").length : 999;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getUserxzqh() {
        return userxzqh;
    }

    public void setUserxzqh(String userxzqh) {
        this.userxzqh = userxzqh;
    }

    public String getRylx() {
        return rylx;
    }

    public void setRylx(String rylx) {
        this.rylx = rylx;
    }

    public String getUserxm() {
        return userxm;
    }

    public void setUserxm(String userxm) {
        this.userxm = userxm;
    }

    public String getIssh() {
        return issh;
    }

    public void setIssh(String issh) {
        this.issh = issh;
    }

    public void translate(LoginUserInfo loginUserInfo) {
        this.userid = loginUserInfo.getUserid();
        this.userxzqh = loginUserInfo.getUserxzqh();
    }

    //把市直辖的编码转化成市级的编码330000000, 330500000, 330500000->330000000, 330500000
    public  LoginUserInfo translateXZQH(){
        if(userxzqh!=null&&userxzqh.split(",").length>1){
            String[] split = userxzqh.split(",");
            if(split[split.length-1].equals(split[split.length-2])){
                userxzqh= userxzqh.substring(0,userxzqh.lastIndexOf(","));
            }
        }
        return this;
    }



}
