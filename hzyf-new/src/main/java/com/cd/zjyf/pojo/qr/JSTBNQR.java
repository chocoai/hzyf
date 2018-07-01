/**
 * Copyright 2018 bejson.com
 */
package com.cd.zjyf.pojo.qr;

import com.cd.zjyf.utils.CommonUtil;

import java.math.BigDecimal;

/**
 * Auto-generated: 2018-06-11 9:57:5
 *接收同比new
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class JSTBNQR {

    private String name;//地区名/暂存点名
    private BigDecimal jzl= CommonUtil.getDeafualtBigDecimal();//今年的重量
    private BigDecimal qzl= CommonUtil.getDeafualtBigDecimal();//去年的重量


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getJzl() {
        return jzl;
    }

    public void setJzl(BigDecimal jzl) {
        this.jzl = jzl;
    }

    public BigDecimal getQzl() {
        return qzl;
    }

    public void setQzl(BigDecimal qzl) {
        this.qzl = qzl;
    }

    public static void main(String[] args) {
        new JSTBNQR();
    }

}