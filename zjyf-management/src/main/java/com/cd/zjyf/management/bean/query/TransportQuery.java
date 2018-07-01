package com.cd.zjyf.management.bean.query;

import io.swagger.annotations.ApiModelProperty;

/**
 * Created by li.mingyang on 2018/4/17.
 */
public class TransportQuery {

    @ApiModelProperty("运输者id")
    private String id;
 
    @ApiModelProperty("运输者姓名")
    private String xm;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getXm() {
		return xm;
	}

	public void setXm(String xm) {
		this.xm = xm;
	}

   
}
