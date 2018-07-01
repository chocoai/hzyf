/**
  * Copyright 2018 bejson.com 
  */
package com.cd.zjyf.pojo.qr.HomePage;

import com.cd.zjyf.utils.Constant;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * Auto-generated: 2018-02-06 9:57:5
 *地理信息
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class DLXX {

    private String dwmc;//单位名称/在线收集员名称
    private String id;//单位主键/在线收集员主键
    private String longitude;//经度
    private String latitude;//纬度
    private Date lastTime;//最近收集时间/最近提供时间
    private float lastZl;//最近收集重量/最近提供重量
    private String zdType;//信息类型（1暂存点2产生点3在线收集员）
    
    public DLXX() {}
    
    
    public DLXX(String dwmc, String id, String longitude, String latitude, Date lastTime, float lastZl, String zdType) {
		super();
		this.dwmc = dwmc;
		this.id = id;
		this.longitude = longitude;
		this.latitude = latitude;
		this.lastTime = lastTime;
		this.lastZl = lastZl;
		this.zdType = zdType;
	}
    
	public void setDwmc(String dwmc) {
         this.dwmc = dwmc;
     }
     public String getDwmc() {
         return dwmc;
     }

    public void setId(String id) {
         this.id = id;
     }
     public String getId() {
         return id;
     }

    public void setLongitude(String longitude) {
         this.longitude = longitude;
     }
     public String getLongitude() {
         return longitude;
     }

    public void setLatitude(String latitude) {
         this.latitude = latitude;
     }
     public String getLatitude() {
         return latitude;
     }

    public void setLastTime(Date lastTime) {
         this.lastTime = lastTime;
     }
	@JsonFormat(timezone = "GMT+8", pattern =Constant.DATE_PATTERN1)
     public Date getLastTime() {
         return lastTime;
     }

    public void setLastZl(float lastZl) {
         this.lastZl = lastZl;
     }
     public float getLastZl() {
         return lastZl;
     }

    public void setZdType(String zdType) {
         this.zdType = zdType;
     }
     public String getZdType() {
         return zdType;
     }
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DLXX other = (DLXX) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
     


     

}