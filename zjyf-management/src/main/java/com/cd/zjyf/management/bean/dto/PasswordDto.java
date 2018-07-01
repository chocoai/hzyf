package com.cd.zjyf.management.bean.dto;

import io.swagger.annotations.ApiModelProperty;

public class PasswordDto {
	
	@ApiModelProperty("用户密码")
	private String password;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}

