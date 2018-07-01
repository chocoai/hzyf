package com.cd.uap.service;

import java.util.concurrent.TimeUnit;

import com.cd.uap.util.SMSUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundValueOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;


@Service
public class SmsService {

	@Autowired
	private RedisTemplate<String, String> redisTemplate;

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	/**
	 * 发送验证码
	 * @param phoneNum
	 * @throws ClientException 
	 */
	public SendSmsResponse sendMessage(String phoneNum) throws ClientException {
		//1.生成随机六位数
	    Integer code = (int)((Math.random()*9+1)*100000);
		//2.发送验证码
		SendSmsResponse response = SMSUtils.sendSms(phoneNum, code.toString());
		BoundValueOperations<String, String> boundValueOps = redisTemplate.boundValueOps("regist" + phoneNum);
		if (null != response && "OK".equals(response.getCode())) {
			//3.将验证码信息存储到redis中  格式为regist + phoneNum
			boundValueOps.set(code.toString(), 5, TimeUnit.MINUTES);
		}
		logger.info("短信发送：{}成功，验证码为：{}", phoneNum, boundValueOps.get());
		return response;
	}
	
	/**
	 * 校验短信验证码
	 * @param validateCode
	 * @param phoneNum
	 * @return
	 */
	public Boolean checkValidateCode(String validateCode, String phoneNum) {
		
		//从redis中取出短信验证码
		BoundValueOperations<String, String> boundValueOps = redisTemplate.boundValueOps("regist" + phoneNum);
		String currentCode = boundValueOps.get();
			
		if (null == validateCode) {
			return false;
		} else if (validateCode.equals(currentCode)) {
			return true;
		} else {
			return false;
		}
	}
	
}
















