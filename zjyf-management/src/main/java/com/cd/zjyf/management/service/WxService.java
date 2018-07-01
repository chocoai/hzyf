package com.cd.zjyf.management.service;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSON;
import com.cd.zjyf.management.bean.WxResponse;
import com.cd.zjyf.management.bean.dto.WxBindDto;
import com.cd.zjyf.management.dao.WxDao;
import com.cd.zjyf.management.exception.LogicException;
import com.cd.zjyf.management.pojo.Wx;
import com.cd.zjyf.management.util.RequestValidationUtils;

@Service
@Transactional
public class WxService {
	
	@Autowired
	private WxDao wxDao;

	private static Logger log = LoggerFactory.getLogger(AppUserService.class);

	@Autowired
	private RestTemplate restTemplate;
	/**
	 * 用户绑定微信
	 * 
	 * @param wxBindDto
	 * @throws Exception
	 */
	public void bindWxAndAppUser(WxBindDto wxBindDto) throws Exception {
		//将code转为openId
		String code = wxBindDto.getCode();
		String entity = restTemplate.getForObject("https://api.weixin.qq.com/sns/jscode2session?appid=" + Wx.APP_ID + "&secret=" + Wx.SECRET + "&js_code=" + code + "&grant_type=authorization_code", String.class);
		WxResponse wxResponse = JSON.parseObject(entity, WxResponse.class);
		
		if(null != wxResponse.getErrcode()) {
			throw new LogicException("微信openId获取失败");
		}
		String openId = wxResponse.getOpenid();
		String userId = (String)RequestValidationUtils.appUserInfo().get("id");
		
		if (wxDao.existsByUserId(userId)) {
			throw new LogicException("该用户已经绑定微信");
		}
		if (wxDao.existsByOpenId(openId)) {
			throw new LogicException("该微信已经绑定用户");
		}
		
		Wx wx = new Wx(openId, userId);
		wxDao.save(wx);
		log.info("{}绑定了微信，openId:{}", userId, openId);
	}

	/**
	 * 用户解绑微信
	 * 
	 * @param wxBindDto
	 */
	public void deBindWxAndAppUser() throws Exception {
		String currentUserId = (String)RequestValidationUtils.appUserInfo().get("id");
		int colum = wxDao.deleteByUserId(currentUserId);
		if (0 == colum) {
			throw new LogicException("该用户尚未绑定微信");
		}
		log.info("{}解除绑定了微信", currentUserId);
	}
}
