package com.cd.uap.controller;

import com.cd.uap.bean.Response;
import com.cd.uap.bean.ResultCode;
import com.cd.uap.bean.dto.PhoneRegistDto;
import com.cd.uap.bean.dto.WxBindDto;
import com.cd.uap.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;

/**
 * Created by li.mingyang on 2018/4/20.
 */
@RestController
@RequestMapping("/user")
@Validated
public class UserController {

    @Autowired
    private UserService appUserService;

    @PostMapping("/regist")
    public Response registUser(@RequestBody PhoneRegistDto phoneRegistDto) throws Exception {
        appUserService.registUser(phoneRegistDto);
        return new Response(0, ResultCode.SUCCESS, null);
    }

    @PutMapping("/password")
    public Response updateUser(@RequestBody PhoneRegistDto phoneRegistDto) throws Exception {
        appUserService.updateUser(phoneRegistDto);
        return new Response(0, ResultCode.SUCCESS, null);
    }

    @GetMapping("/regist")
    public Response findIsRegist(@NotNull(message = "手机号不能为空") String sjh) throws Exception {
        Boolean isRegist = appUserService.isRegist(sjh);
        int data = isRegist? 1 : 0;
        return new Response(0, ResultCode.SUCCESS, data);
    }



}




















