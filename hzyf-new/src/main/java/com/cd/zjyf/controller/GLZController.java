package com.cd.zjyf.controller;

import com.cd.zjyf.base.controller.BaseController;
import com.cd.zjyf.base.controller.ServiceHandlerAdapter;
import com.cd.zjyf.base.exception.BaseException;
import com.cd.zjyf.pojo.GenerSaveOrUpdateBean;
import com.cd.zjyf.pojo.Response;
import com.cd.zjyf.pojo.qc.GLZdwnocollectQC;
import com.cd.zjyf.pojo.qc.GLZstatisticsQC;
import com.cd.zjyf.service.GLZService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/glz")
public class GLZController extends BaseController {
	
	
	@Autowired
	private GLZService gLZService;
	
	private static Logger log = LoggerFactory.getLogger(GLZController.class);

	@RequestMapping(method = RequestMethod.GET,value="/index")
	public Response selectGLZindex(String id) {
		log.info("管理者首页");
		return super.query(new ServiceHandlerAdapter() {
			@Override
			public Object serviceQueryOperate(Object o) {
				return gLZService.selectGLZindex((String)o);
			}
		}, id);
		
	}
	
	@RequestMapping(method = RequestMethod.GET,value="/refuse")
	public Response selectGLZrefuseList(String id) {
		log.info("管理者拒收列表查询");
		return super.query(new ServiceHandlerAdapter() {
			@Override
			public Object serviceQueryOperate(Object o) {
				return gLZService.selectGLZrefuseList((String)o);
			}
		}, id);
		
	}
	
	
	@RequestMapping(method = RequestMethod.PUT,value="/refuse")
	public Response updateGLZrefuse(@RequestBody GenerSaveOrUpdateBean bean) {
		log.info("管理者拒收处理");
		return super.genericSaveOrUpdate(new ServiceHandlerAdapter() {
			@Override
			public Object serviceSaveOrUpdateOperate(Object o) throws BaseException {
				return gLZService.updateGLZrefuse(bean);
			}
		}, bean);
	}
	
	
	@RequestMapping(method = RequestMethod.GET,value="/tj")
	@Deprecated
	public Response selectGLZstatistics(GLZstatisticsQC qc) {
		log.info("管理者统计查询");
		return super.query(new ServiceHandlerAdapter() {
			@Override
			public Object serviceQueryOperate(Object o) {
				return gLZService.selectGLZstatistics((GLZstatisticsQC)o);
			}
		}, qc);
	}


	@RequestMapping(method = RequestMethod.GET,value="/typetj")
	public Response selectGLZstatisticsByType(GLZstatisticsQC qc) {
		log.info("管理者统计查询");
		return super.query(new ServiceHandlerAdapter() {
			@Override
			public Object serviceQueryOperate(Object o) {
				return gLZService.selectGLZstatisticsByType((GLZstatisticsQC)o);
			}
		}, qc);
	}


	@RequestMapping(method = RequestMethod.GET,value="/jsdj")
	public Response gLZstatJSDJ(GLZstatisticsQC qc) {
		log.info("管理者产生点接收登记流水明细");
		return super.query(new ServiceHandlerAdapter() {
			@Override
			public Object serviceQueryOperate(Object o) {
				return gLZService.gLZstatJSDJ((GLZstatisticsQC)o);
			}
		}, qc);
	}

	@RequestMapping(method = RequestMethod.GET,value="/gLZstatDropdown")
	public Response gLZstatDropdown(GLZstatisticsQC qc) {
		log.info("管理者统计查询单位下拉列表");
		return super.query(new ServiceHandlerAdapter() {
			@Override
			public Object serviceQueryOperate(Object o) {
				return gLZService.gLZstatDropdown((GLZstatisticsQC)o);
			}
		}, qc);
	}



	
	@RequestMapping(method = RequestMethod.GET,value="/area")
	public Response getArea(@RequestParam(value="xzqh") String areacode) {
		log.info("地区级联查询");
		return super.query(new ServiceHandlerAdapter() {
			@Override
			public Object serviceQueryOperate(Object o) {
				return gLZService.getArea(areacode);
			}
		}, areacode);
	}
	
	
	@RequestMapping(method = RequestMethod.GET,value="/nocollect")
	public Response selectGLZnocollect(GLZdwnocollectQC qc) {
		log.info("管理者首页及条件查询长期未接受单位");
		return super.query(new ServiceHandlerAdapter() {
			@Override
			public Object serviceQueryOperate(Object o) {
				return gLZService.selectGLZnocollect(qc);
			}
		}, qc);
		
	}
	
	
	
	@RequestMapping(method = RequestMethod.GET,value="/dw")
	public Response getGLZzcdlist(String xzqh) {
		log.info("管理者查询暂存点单位列表");
		return super.query(new ServiceHandlerAdapter() {
			@Override
			public Object serviceQueryOperate(Object o) {
				return gLZService.getGLZzcdlist(xzqh);
			}
		}, xzqh);
		
	}
}










