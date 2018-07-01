/**
  * Copyright 2018 bejson.com 
  */
package com.cd.zjyf.pojo.qr.HomePage;

import com.cd.zjyf.utils.Constant;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * Auto-generated: 2018-02-06 10:6:36
 *具体单位收集情况
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class SJQK {

    private Date acceptTime;//最近接收日期
    private int ssxSl;//损伤性废物数量
    private float ssxZl;//损伤性废物重量
    private int grxSl;//感染性废物数量
    private float grxZl;//感染性废物重量
    private int blxSl;//病理性废物数量
    private float blxZl;//病理性废物重量
    private int ywxSl;//药物性废物数量
    private float ywxZl;//药物性废物重量
    private int hxxSl;//化学性废物数量
    private float hxxZl;//化学性废物重量
    private int countSl;//总计数量
    private float countZl;//总计重量

     
    
 	public int getSsxSl() {
		return ssxSl;
	}
	public void setSsxSl(int ssxSl) {
		this.ssxSl = ssxSl;
	}
	public float getSsxZl() {
		return ssxZl;
	}
	public void setSsxZl(float ssxZl) {
		this.ssxZl = ssxZl;
	}
	public int getGrxSl() {
		return grxSl;
	}
	public void setGrxSl(int grxSl) {
		this.grxSl = grxSl;
	}
	public float getGrxZl() {
		return grxZl;
	}
	public void setGrxZl(float grxZl) {
		this.grxZl = grxZl;
	}
	public int getBlxSl() {
		return blxSl;
	}
	public void setBlxSl(int blxSl) {
		this.blxSl = blxSl;
	}
	public float getBlxZl() {
		return blxZl;
	}
	public void setBlxZl(float blxZl) {
		this.blxZl = blxZl;
	}
	public int getYwxSl() {
		return ywxSl;
	}
	public void setYwxSl(int ywxSl) {
		this.ywxSl = ywxSl;
	}
	public float getYwxZl() {
		return ywxZl;
	}
	public void setYwxZl(float ywxZl) {
		this.ywxZl = ywxZl;
	}
	public int getHxxSl() {
		return hxxSl;
	}
	public void setHxxSl(int hxxSl) {
		this.hxxSl = hxxSl;
	}
	public float getHxxZl() {
		return hxxZl;
	}
	public void setHxxZl(float hxxZl) {
		this.hxxZl = hxxZl;
	}
	public int getCountSl() {
		return countSl;
	}
	public void setCountSl(int countSl) {
		this.countSl = countSl;
	}
	public float getCountZl() {
		return countZl;
	}
	public void setCountZl(float countZl) {
		this.countZl = countZl;
	}
	@JsonFormat(timezone = "GMT+8", pattern = Constant.DATE_PATTERN1)
	public Date getAcceptTime() {
		return acceptTime;
	}
	public void setAcceptTime(Date acceptTime) {
		this.acceptTime = acceptTime;
	}

}