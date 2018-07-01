package com.cd.zjyf.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cd.zjyf.management.bean.Response;
import com.cd.zjyf.management.bean.ResultCode;
import com.cd.zjyf.management.bean.dto.WxBindDto;
import com.cd.zjyf.management.service.WxService;

@RestController
@RequestMapping("/wx")
public class WxController {
	
	@Autowired
	private WxService wxService;
	
	/**
	 * 用户绑定微信
	 * 
	 * @param wxBindDto
	 * @return
	 * @throws Exception
	 */
	@PostMapping
    public Response bindWxAndAppUser(@RequestBody @Validated WxBindDto wxBindDto) throws Exception {
		wxService.bindWxAndAppUser(wxBindDto);
        return new Response(0, ResultCode.SUCCESS, null);
    }
	
	/**
	 * 解除用户绑定微信
	 * 
	 * @return
	 * @throws Exception
	 */
	@DeleteMapping
    public Response deBindWxAndAppUser() throws Exception {
		wxService.deBindWxAndAppUser();
        return new Response(0, ResultCode.SUCCESS, null);
    }
}
