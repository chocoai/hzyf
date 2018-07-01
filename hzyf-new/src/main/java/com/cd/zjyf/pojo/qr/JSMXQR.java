/**
 * Copyright 2018 bejson.com
 */
package com.cd.zjyf.pojo.qr;

import com.cd.zjyf.utils.CommonUtil;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Auto-generated: 2018-02-06 9:57:5
 *接收明细列表
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class JSMXQR {

  private String zcd;//暂存点
//  private int ssl;
  private BigDecimal szl=CommonUtil.getDeafualtBigDecimal();
//  private int  gsl;
  private BigDecimal  gzl=CommonUtil.getDeafualtBigDecimal();
//  private int  bsl;
  private BigDecimal  bzl=CommonUtil.getDeafualtBigDecimal();
//  private int  ysl;
  private BigDecimal  yzl=CommonUtil.getDeafualtBigDecimal();
//  private int  hsl;
  private BigDecimal  hzl=CommonUtil.getDeafualtBigDecimal();
//  private int  sl;//总数量
  private BigDecimal zl= CommonUtil.getDeafualtBigDecimal();//总重量

    public String getZcd() {
        return zcd;
    }

    public void setZcd(String zcd) {
        this.zcd = zcd;
    }

    public BigDecimal getSzl() {
        return szl;
    }

    public void setSzl(BigDecimal szl) {
        this.szl = szl;
    }

    public BigDecimal getGzl() {
        return gzl;
    }

    public void setGzl(BigDecimal gzl) {
        this.gzl = gzl;
    }

    public BigDecimal getBzl() {
        return bzl;
    }

    public void setBzl(BigDecimal bzl) {
        this.bzl = bzl;
    }

    public BigDecimal getYzl() {
        return yzl;
    }

    public void setYzl(BigDecimal yzl) {
        this.yzl = yzl;
    }

    public BigDecimal getHzl() {
        return hzl;
    }

    public void setHzl(BigDecimal hzl) {
        this.hzl = hzl;
    }

    public BigDecimal getZl() {
        return zl;
    }

    public void setZl(BigDecimal zl) {
        this.zl = zl;
    }
}