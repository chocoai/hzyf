/**
  * Copyright 2018 bejson.com 
  */
package com.cd.zjyf.pojo.qr;

import com.cd.zjyf.annotation.RealField;

/**
 * Auto-generated: 2018-02-06 9:33:3
 *类型
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class LX {
	@RealField(reference = "lx")
    private String lxCode;//类型代码
    private float count;//本类型重量
	public String getLxCode() {
		return lxCode;
	}
	public void setLxCode(String lxCode) {
		this.lxCode = lxCode;
	}
	public float getCount() {
		return count;
	}
	public void setCount(float count) {
		this.count = count;
	}
    
    

}