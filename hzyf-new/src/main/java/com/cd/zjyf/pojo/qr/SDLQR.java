package com.cd.zjyf.pojo.qr;

import com.cd.zjyf.utils.CommonUtil;

import java.math.BigDecimal;

/**
 * Created by chen.shuodong on 2018/4/12.
 * 产生点送达率汇总表
 */
public class SDLQR {
    private String month;//月份
    private String zcd;//暂存点
    private String csd;//产生点
    private int jsts;//接收天数
    private int sjsts;//损伤性接收天数
    private int gjsts;//感染性接收天数
    private int bjsts;//病理性接收天数
    private int yjsts;//药物性接收天数
    private int hjsts;//化学性接收天数
    private BigDecimal sjl = CommonUtil.getDeafualtBigDecimal();//收集率

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
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

    public int getJsts() {
        return jsts;
    }

    public void setJsts(int jsts) {
        this.jsts = jsts;
    }

    public int getSjsts() {
        return sjsts;
    }

    public void setSjsts(int sjsts) {
        this.sjsts = sjsts;
    }

    public int getGjsts() {
        return gjsts;
    }

    public void setGjsts(int gjsts) {
        this.gjsts = gjsts;
    }

    public int getBjsts() {
        return bjsts;
    }

    public void setBjsts(int bjsts) {
        this.bjsts = bjsts;
    }

    public int getYjsts() {
        return yjsts;
    }

    public void setYjsts(int yjsts) {
        this.yjsts = yjsts;
    }

    public int getHjsts() {
        return hjsts;
    }

    public void setHjsts(int hjsts) {
        this.hjsts = hjsts;
    }

    public BigDecimal getSjl() {
        return sjl;
    }

    public void setSjl(BigDecimal sjl) {
        this.sjl = sjl;
    }
}
