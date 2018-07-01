/**
 * Copyright 2018 bejson.com
 */
package com.cd.zjyf.pojo.qr;

import com.cd.zjyf.utils.CommonUtil;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * Auto-generated: 2018-02-06 9:57:5
 *接收环比
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class JSHBQR {
   private String name;//地区名
   private BigDecimal zl=CommonUtil.getDeafualtBigDecimal();//重量
   private String time;//x轴时间

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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}