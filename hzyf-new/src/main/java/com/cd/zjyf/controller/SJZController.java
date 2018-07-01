package com.cd.zjyf.controller;

import com.cd.zjyf.base.controller.BaseController;
import com.cd.zjyf.base.controller.ServiceHandlerAdapter;
import com.cd.zjyf.base.exception.BaseException;
import com.cd.zjyf.bean.YlfwJsdj;
import com.cd.zjyf.exception.ValidateException;
import com.cd.zjyf.pojo.Response;
import com.cd.zjyf.pojo.qc.SJZSummaryQC;
import com.cd.zjyf.pojo.qc.SJZhistoryListQC;
import com.cd.zjyf.pojo.qc.SJZqueryByQRcodeQC;
import com.cd.zjyf.service.SJZService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/sjz")
public class SJZController extends BaseController {
	
	
	@Autowired
	private SJZService sJZService;
	
	private static Logger log = LoggerFactory.getLogger(SJZController.class);

	@RequestMapping(method = RequestMethod.GET,value="/index")
	public Response selectSJZindex(String id) {
		log.info("收集员首页查询");
		return super.query(new ServiceHandlerAdapter() {
			@Override
			public Object serviceQueryOperate(Object o) {
				return sJZService.selectSJZindex((String)o);
			}
		}, id);
		
	}

	@RequestMapping(method = RequestMethod.GET,value="/qrcodeCheckZCD")
	public Response selectBySJZqueryByQRcodeBeanIsZCD(SJZqueryByQRcodeQC qc) {
		log.info("收集员扫描判断扫的单位上级是否属于该收集员的暂存点单位");
		return super.queryHasException(new ServiceHandlerAdapter() {
			@Override
			public Object serviceQueryOperateHasExcpetoin(Object o) throws ValidateException {
				return sJZService.selectBySJZqueryByQRcodeBeanIsZCD(qc);
			}
		}, qc);
	}

	@RequestMapping(method = RequestMethod.GET,value="/qrcode")
	public Response selectBySJZqueryByQRcodeBean(String id) {
		log.info("用于展示收集废物列表、用户信息。收集废物列表按接收时间从远到近排序。");
		return super.queryHasException(new ServiceHandlerAdapter() {
			@Override
			public Object serviceQueryOperateHasExcpetoin(Object o) throws ValidateException {
				return sJZService.selectBySJZqueryByQRcodeBean((String)o);
			}
		}, id);
		
	}
	
	@RequestMapping(method = RequestMethod.GET,value="/queryTGZ")
	public Response selectTGZByCSDID( String id) {
		log.info("查询该产生点下的所有交接员");
		return super.query(new ServiceHandlerAdapter() {
			@Override
			public Object serviceQueryOperate(Object o) {
				return sJZService.selectTGZByCSDID((String)o);
			}
		}, id);
	}
	
	@RequestMapping(method = RequestMethod.PUT,value="/history")
	public Response updateHistoryInfo(@RequestBody YlfwJsdj ylfwJsdj) {
		log.info("修改该次医废收集历史信息");
		return super.genericSaveOrUpdate(new ServiceHandlerAdapter() {
			@Override
			public Object serviceSaveOrUpdateOperate(Object o) throws BaseException {
				return sJZService.updateHistoryInfo((YlfwJsdj)o);
			}
		}, ylfwJsdj);
	}
	
	@RequestMapping(method = RequestMethod.GET,value="/history")
	public Response selectTGZhistoryInfo( String id) {
		log.info("查询医废收集详细历史信息");
		return super.query(new ServiceHandlerAdapter() {
			@Override
			public Object serviceQueryOperate(Object o) {
				return sJZService.selectTGZhistoryInfo((String)o);
			}
		}, id);
		
	}
	
	@RequestMapping(method = RequestMethod.GET,value="/historylist")
	public Response selectTGZhistoryList(SJZhistoryListQC sJZhistoryListQC) {
		log.info("查询医废收集信息列表");
		return super.query(new ServiceHandlerAdapter() {
			@Override
			public Object serviceQueryOperate(Object o) {
				return sJZService.selectTGZhistoryList((SJZhistoryListQC)o);
			}
		}, sJZhistoryListQC);
		
	}
	
	@RequestMapping(method = RequestMethod.GET,value="/dw")
	public Response selectCSDdwList(String id) {
		log.info("查询该收集员所有产生点单位列表");
		return super.query(new ServiceHandlerAdapter() {
			@Override
			public Object serviceQueryOperate(Object o) {
				return sJZService.selectCSDdwList((String)o);
			}
		}, id);
		
	}

	@RequestMapping(method = RequestMethod.POST,value="/save")
	public Response save(@RequestBody YlfwJsdj ylfwJsdj) {
		log.info("保存本次医废收集信息");
		return super.genericSaveOrUpdate(new ServiceHandlerAdapter() {
			@Override
			public Object serviceSaveOrUpdateOperate(Object o) throws BaseException {
				return sJZService.save((YlfwJsdj)o);
			}
		}, ylfwJsdj);
	}

	@RequestMapping(method = RequestMethod.GET,value="/summary")
	public Response selectSummaryCSD(SJZSummaryQC qc ) {
		log.info("扫描汇总");
		return super.queryHasException(new ServiceHandlerAdapter() {
			@Override
			public Object serviceQueryOperateHasExcpetoin(Object o) throws ValidateException {
				return sJZService.selectSummaryCSD(qc);
			}
		}, qc);
		
	}

	@RequestMapping(method = RequestMethod.GET,value="/summarynew")
	public Response selectSummaryZCD(SJZSummaryQC qc ) {
		log.info("收集员扫运输者二维码清算汇总");
		return super.queryHasException(new ServiceHandlerAdapter() {
			@Override
			public Object serviceQueryOperateHasExcpetoin(Object o) throws ValidateException {
				return sJZService.selectSummaryZCD(qc);
			}
		}, qc);
		
	}
	
}










