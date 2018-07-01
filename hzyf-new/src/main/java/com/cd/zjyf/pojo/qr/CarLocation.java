package com.cd.zjyf.pojo.qr;
/**
 * 车辆定位
 * @author chen.shuodong
 *
 */
public class CarLocation {
	private String xm;            //运输者姓名
	private String lng;     //经度
	private String lat;      //纬度
	private String devicename;    //车牌

	private Integer deviceStatus; //设备状态，0：离线；1：在线

	private String receiveTime; //GPS采样时间

	public String getReceiveTime() {
		return receiveTime;
	}

	public String getXm() {
		return xm;
	}

	public void setXm(String xm) {
		this.xm = xm;
	}

	public String getLng() {
		return lng;
	}

	public void setLng(String lng) {
		this.lng = lng;
	}

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public String getDevicename() {
		return devicename;
	}

	public void setDevicename(String devicename) {
		this.devicename = devicename;
	}

	public Integer getDeviceStatus() {
		return deviceStatus;
	}

	public void setDeviceStatus(Integer deviceStatus) {
		this.deviceStatus = deviceStatus;
	}

	public void setReceiveTime(String receiveTime) {
		this.receiveTime = receiveTime;
	}
}

