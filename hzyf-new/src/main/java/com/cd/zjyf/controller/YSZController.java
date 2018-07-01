package com.cd.zjyf.controller;

import com.cd.zjyf.base.controller.BaseController;
import com.cd.zjyf.base.controller.ServiceHandlerAdapter;
import com.cd.zjyf.base.exception.BaseException;
import com.cd.zjyf.bean.YlfwJsdj;
import com.cd.zjyf.pojo.Response;
import com.cd.zjyf.pojo.qc.YSZDetailQC;
import com.cd.zjyf.service.YSZService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/ysz")
public class YSZController extends BaseController {
	
	
	@Autowired
	private YSZService ySZService;
	
	private static Logger log = LoggerFactory.getLogger(YSZController.class);

	
	@RequestMapping(method = RequestMethod.PUT,value="/summary")
	public Response update(@RequestBody YlfwJsdj ylfwJsdj) {
		log.info("运输者清算保存");
		return super.genericSaveOrUpdate(new ServiceHandlerAdapter() {
			@Override
			public Object serviceSaveOrUpdateOperate(Object o) throws BaseException {
				return ySZService.update((YlfwJsdj)o);
			}
		}, ylfwJsdj);
	}
	
	
	
	
	@RequestMapping(method = RequestMethod.GET,value="/index")
	public Response selectYSZindex(String id) {
		log.info("运输者首页查询");
		return super.query(new ServiceHandlerAdapter() {
			@Override
			public Object serviceQueryOperate(Object o) {
				return ySZService.selectYSZindex((String)o);
			}
		}, id);
	}

	
	@RequestMapping(method = RequestMethod.GET,value="/detaillist")
	public Response selectYSZindexDetailList(YSZDetailQC qc) {
		log.info("运输者首页列表点入的暂存点详细列表");
		return super.query(new ServiceHandlerAdapter() {
			@Override
			public Object serviceQueryOperate(Object o) {
				return ySZService.selectYSZindexDetailList(qc);
			}
		}, qc);
	}
	
	
	@RequestMapping(method = RequestMethod.GET,value="/summary")
	public Response selectSummaryZCD(String id) {
		log.info("扫描汇总,清算查询");
		return super.query(new ServiceHandlerAdapter() {
			@Override
			public Object serviceQueryOperate(Object o) {
				return ySZService.selectSummaryZCD((String)o);
			}
		}, id);
		
	}

	
	
}










