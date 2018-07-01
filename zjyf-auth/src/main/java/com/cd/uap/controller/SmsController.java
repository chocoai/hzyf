package com.cd.uap.controller;

import com.cd.uap.bean.Response;
import com.cd.uap.bean.ResultCode;
import com.cd.uap.bean.dto.PhoneRegistDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;

import com.cd.uap.service.SmsService;


@RestController
@RequestMapping("/sms")
public class SmsController {
	
@Autowired
	private SmsService smsService;

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	/**
	 * 发送短信
	 * 
	 * 限制如下：业务限流
		isv.MOBILE_NUMBER_T_CONTROL	：使用同一个签名，对同一个手机号码发送短信验证码，支持1条/分钟，5条/小时 ，累计10条/天。
	 	短信验证码短信通知： 使用同一个签名和同一个短信模板ID，对同一个手机号码发送短信通知，支持50条/日
	 	isv.BUSINESS_LIMIILLEGAL	非法手机号
		isv.AMOUNT_NOT_ENOUGH		余额不足
		isp.SYSTEM_ERROR			系统错误
		OK 							请求成功
	 * @param phoneRegistVo
	 * @return
	 */
	@PostMapping
	public Response sendMessage(@RequestBody PhoneRegistDto phoneRegistVo) {
		try {
			String phoneNum = phoneRegistVo.getSjh();
			SendSmsResponse respMessage = smsService.sendMessage(phoneNum);
			
			if (null == respMessage) {
				logger.error("{}短信发送失败",phoneNum);
				return new Response(1, ResultCode.MESSAGE_SEND_FAILED, null);
			}
			
			//获取短信发送状态码
			String code = respMessage.getCode();
			if (!"OK".equals(code)) {
				
				logger.error("短信发送失败,错误原因：{}", respMessage.getMessage());
				
				if ("isv.BUSINESS_LIMIT_CONTROL".equals(code)) {
					return new Response(1,ResultCode.MESSAGE_LIMIT_CONTROL, null);
				}else if("isv.MOBILE_NUMBER_ILLEGAL".equals(code)) {
					return new Response(1,ResultCode.MOBILE_NUMBER_ILLEGAL, null);
				}else if("isv.AMOUNT_NOT_ENOUGH".equals(code)) {
					return new Response(1,ResultCode.AMOUNT_NOT_ENOUGH, null);
				}else if("isp.SYSTEM_ERROR".equals(code)) {
					return new Response(1,ResultCode.MESSAGE_SYSTEM_ERROR, null);
				}else {
					return new Response(1,ResultCode.MESSAGE_SEND_FAILED, null);
				}
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
			return new Response(1,ResultCode.MESSAGE_CLIENT_ERROR, null);
		}
		return new Response(0, ResultCode.SUCCESS, null);
	}
	
}
