/**
 * Copyright 2018 bejson.com
 */
package com.cd.zjyf.pojo.qr;

import com.cd.zjyf.pojo.LoginUserInfo;
import com.cd.zjyf.utils.CommonUtil;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Auto-generated: 2018-02-06 9:57:5
 *接收同比
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class JSTBQR {

    private String name;//地区名
    private BigDecimal zl= CommonUtil.getDeafualtBigDecimal();//重量
    private int cs;//次数


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getZl() {
        return zl;
    }

    public void setZl(BigDecimal zl) {
        this.zl = zl;
    }

    public int getCs() {
        return cs;
    }

    public void setCs(int cs) {
        this.cs = cs;
    }
}