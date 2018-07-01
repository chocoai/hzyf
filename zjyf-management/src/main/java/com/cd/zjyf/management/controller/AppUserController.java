package com.cd.zjyf.management.controller;

import java.io.OutputStream;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cd.zjyf.management.bean.PageBean;
import com.cd.zjyf.management.bean.Response;
import com.cd.zjyf.management.bean.ResultCode;
import com.cd.zjyf.management.bean.dto.IsshDto;
import com.cd.zjyf.management.bean.dto.PasswordDto;
import com.cd.zjyf.management.bean.query.AbstarctQuery;
import com.cd.zjyf.management.bean.query.AppUserQuery;
import com.cd.zjyf.management.bean.query.TransportQuery;
import com.cd.zjyf.management.exception.LogicException;
import com.cd.zjyf.management.pojo.AppUser;
import com.cd.zjyf.management.service.AppUserService;
import com.cd.zjyf.management.util.RequestValidationUtils;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * Created by li.mingyang on 2018/4/14.
 */
@RestController
@RequestMapping("/user")
@Api(description = "用户相关接口")
public class AppUserController {

	@Autowired
	private AppUserService appUserService;

    @GetMapping
    @ApiOperation(value = "根据id查询用户", notes = "")
    public Response getUser(@ApiParam(value = "用户id") String id, HttpServletRequest request)  throws Exception{
        AppUser user = appUserService.getUser(id);
        return new Response(0, ResultCode.SUCCESS, user);
    }

	@GetMapping("/conditions")
	@ApiOperation(value = "根据条件查询用户")
	public Response findAppUserByConditions(AppUserQuery appUserQuery) throws Exception {
		return new Response(0, ResultCode.SUCCESS, appUserService.findAppUserByConditions(appUserQuery));
	}

	@PostMapping
	@ApiOperation(value = "新增用户")
	public Response addUser(@RequestBody @Validated AppUser user) throws Exception {
		appUserService.addUser(user);
		return new Response(0, ResultCode.SUCCESS, null);
	}

    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除用户")
    public Response deleteUser(@PathVariable("id") @ApiParam(value = "删除的用户id") @Validated String userId) throws Exception{
        appUserService.deleteUser(userId);
        return new Response(0, ResultCode.SUCCESS, null);
    }

    @PutMapping("/{id}")
    @ApiOperation("根据id修改用户")
    public Response updateUser(@PathVariable("id") @ApiParam(value = "用户id") String id,@Validated @RequestBody AppUser user) throws Exception{
       appUserService.updateUser(id, user);
        return new Response(0, ResultCode.SUCCESS, null);
    }

    @PutMapping("/{id}/mm")
    @ApiOperation("修改用户密码")
    public Response updatePassword(@PathVariable("id") @ApiParam(value = "用户id") String id, @RequestBody PasswordDto passwordDto) throws Exception{
       appUserService.updatePassword(id, passwordDto);
        return new Response(0, ResultCode.SUCCESS, null);
    }

    @PutMapping("/{id}/issh")
    @ApiOperation("修改用户审核状态")
    public Response updateIssh(@PathVariable("id") @ApiParam(value = "用户id") String id, @RequestBody @ApiParam(value = "审核条件") IsshDto isshDto) throws Exception{
        appUserService.updateIssh(id, isshDto);
        return new Response(0, ResultCode.SUCCESS, null);
    }

    @GetMapping("/export")
    @ApiOperation("用户条件查询结果导出")
    public Response export(AppUserQuery appUserQuery, HttpServletRequest request, HttpServletResponse response) {
        try {
            appUserQuery.setSize(-1);
            if (appUserQuery.getXm() == null) {
                appUserQuery.setXm("");
            }
            PageBean<AppUser> bean = appUserService.findAppUserByConditions(appUserQuery);
            OutputStream outputStream = response.getOutputStream();
            response.reset();
            String fileName = "用户表.xls";
            response.setContentType("application/msexcel");
            response.setHeader("Content-Disposition", "filename="
                    + new String(fileName.getBytes("UTF-8"), "ISO8859-1"));
            appUserService.exportExcel(bean, outputStream);
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Response(0, ResultCode.SUCCESS, null);
    }


	@PostMapping("/transporter")
	@ApiOperation("新增运输人员")
	public Response addTransportUser(@RequestBody AppUser user) throws Exception {
		appUserService.addTransportUser(user);
		return new Response(0, ResultCode.SUCCESS, null);
	}

    @GetMapping("/transporter")
    @ApiOperation("运输人员条件查询")
    public Response getTransporter(@ApiParam("运输者姓名") String xm, AbstarctQuery abstarctQuery) throws Exception {
        Map<String, Object> userInfoMap = RequestValidationUtils.appUserInfo();
        String rylx = (String)userInfoMap.get("rylx");
        if(!"7".equals(rylx))throw new LogicException("无操作权限");
            PageBean<AppUser> bean = appUserService.findTransportorByPageAndConditions(xm, abstarctQuery);
        return new Response(0, ResultCode.SUCCESS, bean);
    }

	@GetMapping("/exportTransporter")
	@ApiOperation("运输人员条件查询结果导出")
	public Response exportTransporter(TransportQuery transportQuery, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
        //获取运输管理员信息
        Map<String, Object> userInfoMap = RequestValidationUtils.appUserInfo();
        String rylx = (String)userInfoMap.get("rylx");
        if(!"7".equals(rylx))throw new LogicException("无操作权限");
        AbstarctQuery abstarctQuery = new AppUserQuery();
        abstarctQuery.setPage(-1);
        try {
            PageBean<AppUser> bean = appUserService.findTransportorByPageAndConditions(transportQuery.getXm(), abstarctQuery);
            OutputStream outputStream = response.getOutputStream();
            response.reset();
            response.setHeader("Content-disposition", "attachment; filename=details.xls");

            response.setContentType("application/msexcel");
            appUserService.exportTransportExcel(bean, outputStream);
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
		return new Response(0, ResultCode.SUCCESS, null);
	}
	
	@PostMapping("/regist")
    @ApiOperation(value = "用户注册")
    public Response registUser(@RequestBody AppUser user) throws Exception {
        appUserService.registUser(user);
        return new Response(0, ResultCode.SUCCESS, null);
    }

	@PutMapping("/{id}/resetMm")
    @ApiOperation(value = "管理员重置用户密码")
    public Response resetMm(@PathVariable("id") String id) throws Exception {
		appUserService.resetMm(id);
        return new Response(0, ResultCode.SUCCESS, null);
    }
	
}
