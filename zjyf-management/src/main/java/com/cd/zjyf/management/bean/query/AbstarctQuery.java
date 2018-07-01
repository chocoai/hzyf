package com.cd.zjyf.management.bean.query;

import io.swagger.annotations.ApiModelProperty;

public class AbstarctQuery {
	//当前页数,第一页则传入1
	@ApiModelProperty("页数")
	private int page;

	//每页展示数
	@ApiModelProperty("每页显示数量")
	private int size;

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

}