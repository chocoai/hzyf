/**
  * Copyright 2018 bejson.com 
  */
package com.cd.zjyf.pojo.qr;

/**
 * Auto-generated: 2018-02-06 9:33:3
 *本月医废收集情况
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class OneMonthSJ {

    private String regionCode;//区域编码
    private String regionName;//区域名称
    private int csCount;//总次数
    private float zlCount;//总重量
    public void setRegionCode(String regionCode) {
         this.regionCode = regionCode;
     }
     public String getRegionCode() {
         return regionCode;
     }

    public void setRegionName(String regionName) {
         this.regionName = regionName;
     }
     public String getRegionName() {
         return regionName;
     }

    public void setCsCount(int csCount) {
         this.csCount = csCount;
     }
     public int getCsCount() {
         return csCount;
     }

    public void setZlCount(float zlCount) {
         this.zlCount = zlCount;
     }
     public float getZlCount() {
         return zlCount;
     }

}