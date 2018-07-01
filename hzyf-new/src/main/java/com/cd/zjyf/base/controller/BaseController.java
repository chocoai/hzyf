package com.cd.zjyf.base.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.cd.zjyf.enums.ReportTemplateEnum;
import com.cd.zjyf.utils.ExcelUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.alibaba.fastjson.JSON;
import com.cd.zjyf.base.exception.BaseException;
import com.cd.zjyf.pojo.NullObject;
import com.cd.zjyf.pojo.Response;
import com.cd.zjyf.utils.CodeMessage;

import java.io.IOException;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Map;

@RestController
public class BaseController {

	private static Logger log = LoggerFactory.getLogger(BaseController.class);

	@Autowired
	private HttpServletResponse response;

	// 从拦截器中获取Response
	private Response getResponse() {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
				.getRequest();
		Response response = (Response) request.getAttribute("sysResponse");
		return response;
	}

	// 成功的情况
	protected Response success(Object data) {
        getResponse().setStatus(CodeMessage.STATUS_SUCCESS.getStatus());
        getResponse().setError(CodeMessage.OPERATION_SUCCESS.getCode(), CodeMessage.OPERATION_SUCCESS.getMsg());
        getResponse().setData(setNull(data));
        // response.setToken((String)request.getAttribute("token"));
		log.info("后端返回的数据：{}", JSON.toJSONStringWithDateFormat(getResponse(),"yyyy-MM-dd HH:mm:ss", SerializerFeature.WriteMapNullValue));
        return getResponse();
    }

	private Object setNull(Object data) {
		return data==null?new NullObject():data;
	}


	// 失败的情况
	protected Response fail() {
		getResponse().setStatus(CodeMessage.STATUS_FAILED.getStatus());
		getResponse().setError(CodeMessage.OPERATION_FAILED.getCode(), CodeMessage.OPERATION_FAILED.getMsg());
		return getResponse();
	}

	protected Response query(ServiceQueryHandler sh, Object... obj) {
		return success(sh.serviceQueryOperate(obj));
	}

	/**
	 * 普通的一个模板查询
	 *
	 * @param sh
	 * @param obj
	 * @return
	 */
	protected Response query(ServiceHandlerAdapter sh, Object obj) {
		return success(sh.serviceQueryOperate(obj));
	}

	public Response query(ServiceHandlerAdapter sh) {
		return success(sh.serviceQueryOperate());
	}

	/**
	 * 带异常的一个模板查询
	 *
	 * @param sh
	 * @param obj
	 * @return
	 */
	protected Response queryHasException(ServiceHandlerAdapter sh, Object obj) {
		Object o = null;
		try {
			o = sh.serviceQueryOperateHasExcpetoin(obj);
		} catch (BaseException e) {
			log.error("方法：queryHasException||错误码：{}||错误消息：{}", e.getResponse().getError().getCode(),
					e.getResponse().getError().getMessage());
			log.error("BaseException", e);
			return e.getResponse();
		}
		return success(o);
	}

	/**
	 * 带异常的一个模板查询
	 *
	 * @param sh
	 * @param obj
	 * @return
	 */
	protected Response queryHasException(ServiceHandlerAdapter sh) {
		Object o = null;
		try {
			o = sh.serviceQueryOperateHasExcpetoin();
		} catch (BaseException e) {
			log.error("方法：queryHasException||错误码：{}||错误消息：{}", e.getResponse().getError().getCode(),
					e.getResponse().getError().getMessage());
			log.error("BaseException", e);
			return e.getResponse();
		}
		return success(o);
	}


	// 普通的模板新增或修改操作
	protected Response genericSaveOrUpdate(ServiceHandlerAdapter sh, Object obj) {
		Object o = null;
		try {
			o = sh.serviceSaveOrUpdateOperate(obj);
		} catch (BaseException e) {
			log.error("方法：genericSaveOrUpdate||错误码：{}||错误消息：{}", e.getResponse().getError().getCode(),
					e.getResponse().getError().getMessage());
			log.error("BaseException", e);
			return e.getResponse();
		}
		return success(o);
	}

	// 普通的模板新增或修改操作
	protected Response genericSaveOrUpdate(ServiceHandlerAdapter sh) {
		Object o = null;
		try {
			o = sh.serviceSaveOrUpdateOperate();
		} catch (BaseException e) {
			log.error("方法：genericSaveOrUpdate||错误码：{}||错误消息：{}", e.getResponse().getError().getCode(),
					e.getResponse().getError().getMessage());
			log.error("BaseException", e);
			return e.getResponse();
		}
		return success(o);
	}

	/**
	 * 导出报表
	 * @param _enum
	 * @param dataset
	 * @return
	 * @throws IOException
	 */
	public <T>  Response exportRopert(ReportTemplateEnum _enum, Collection<T> dataset)  {
		response.setContentType("application/vnd.ms-excel;charset=UTF-8");
		Response result = new Response();
		try {
			response.addHeader("Content-Disposition",
					"attachment; filename=" + new String((_enum.getName()).getBytes("GB2312"), "iso8859-1") + ".xls");
			ExcelUtils.exportExcel(ReportTemplateEnum.REPORT_TEMPLATE_BATH, _enum.getSheet(), dataset, response.getOutputStream());
			//_enum=null;
			//	_enum.getClass();
		} catch (Exception e) {
			//	response.setHeader("Content-Type","text/plain");
			e.printStackTrace();
			result.setStatus(1);
			result.setError("1015", "导出失败");
		}
		return result;
	}

	@InitBinder
	public void initBinder(ServletRequestDataBinder binder) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	//	SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
	//	binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf2, true));
	}




}
