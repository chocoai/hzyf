package com.cd.zjyf.management.bean.dto;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

/**
 * Created by li.mingyang on 2018/5/22.
 */
public class WxBindDto {

	@NotBlank(message="code不能为空")
	@Size(min=32, max=32, message="code长度有误,请输入正确的code")
    private String code;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

    
}
