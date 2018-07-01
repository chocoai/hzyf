package com.cd.zjyf.management.validation;

import javax.validation.ConstraintViolationException;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

@Validated
@Configuration
public class AppUserValidation {
	/**
	 * 校验密码
	 * 
	 * @param mm
	 * @throws ConstraintViolationException
	 */
	public void checkMM(
			@NotEmpty(message = "密码不能为空") @Size(min = 8, max = 18, message = "密码必须大于8位小于18位") @Pattern(regexp = "^([A-Z]|[a-z]|[0-9]|[`~!@#$%^&*()+=|{}':;',\\\\\\\\[\\\\\\\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“'。，、？])+$", message = "密码格式错误") String mm)
			throws ConstraintViolationException {
	}

	public void checkSjh(@NotBlank(message = "手机号不能为空") String sjh) throws ConstraintViolationException {
	}

	public void checkXm(@NotBlank(message = "姓名不能为空") String xm) throws ConstraintViolationException {
	}

	public void checkId(@NotBlank(message = "用户名不能为空") @Size(max=16,message="用户名过长") String id) throws ConstraintViolationException {
	}
	public void checkIssh(@Size(min = 1, max = 1,message="审核状态只能是一位") String issh) throws ConstraintViolationException {
	}
	public void checkWgtyy(@NotBlank(message = "未通过原因不能为空") String wgtyy) throws ConstraintViolationException {
	}

}
