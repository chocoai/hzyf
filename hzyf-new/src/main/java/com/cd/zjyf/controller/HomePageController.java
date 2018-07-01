package com.cd.zjyf.controller;

import com.cd.zjyf.base.controller.BaseController;
import com.cd.zjyf.base.controller.ServiceHandlerAdapter;
import com.cd.zjyf.exception.SystemException;
import com.cd.zjyf.exception.ValidateException;
import com.cd.zjyf.mapper.HomePageMapper;
import com.cd.zjyf.pojo.LoginUserInfo;
import com.cd.zjyf.pojo.Response;
import com.cd.zjyf.pojo.qc.HomePageQC;
import com.cd.zjyf.service.HomePageService;
import com.cd.zjyf.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


@RestController
@RequestMapping("/home")
public class HomePageController extends BaseController {
	
	
	@Autowired
	private HomePageService homePageService;
	//@Autowired
	//private UAPService uAPService;//平台uap代理服务

	
	
	private static Logger log = LoggerFactory.getLogger(HomePageController.class);



	@RequestMapping(method = RequestMethod.GET,value="/listYFZLByMonth")
	public Response listYFZLByMonth(HomePageQC qc) {
		log.info("首页=>本区域近6个月废物收集情况按月份统计");
		return super.query(new ServiceHandlerAdapter() {
			@Override
			public Object serviceQueryOperate(Object o) {
				return homePageService.listYFZLByMonth(qc);
			}
		}, qc);

	}




	@RequestMapping(method = RequestMethod.GET,value="/listYFZLByOne")
	public Response listYFZLByOne(HomePageQC qc) {
		log.info("首页=>本区域本月废物收集情况按类型统计");
		return super.query(new ServiceHandlerAdapter() {
			@Override
			public Object serviceQueryOperate(Object o) {
				return homePageService.listYFZLByOne(qc);
			}
		}, qc);
	}



	@RequestMapping(method = RequestMethod.GET,value="/listDWnocollect")
	public Response listDWnocollect(HomePageQC qc) {
		log.info("首页=>查询本地区长期未收集单位列表，取前十条");
		return super.query(new ServiceHandlerAdapter() {
			@Override
			public Object serviceQueryOperate(Object o) {
				return homePageService.listDWnocollect(qc);
			}
		}, qc);
	}





	@RequestMapping(method = RequestMethod.GET,value="/yearTotalZL")
	public Response yearTotalZL(HomePageQC qc) {
		log.info("首页=>地区年总收集重量（清算时间）");
		return super.query(new ServiceHandlerAdapter() {
			@Override
			public Object serviceQueryOperate() {
				return homePageService.yearTotalZL(qc);
			}
		});
	}

	@RequestMapping(method = RequestMethod.GET,value="/qst")
	public Response qst(HomePageQC qc) {
		log.info("首页=>16年开始近5年的垃圾收集情况和单位数量(清算时间)");
		return super.query(new ServiceHandlerAdapter() {
			@Override
			public Object serviceQueryOperate() {
				return homePageService.qst(qc);
			}
		});

	}

	@RequestMapping(method = RequestMethod.GET,value="/sjjsqk")
	public Response sjjsqk(HomePageQC qc) {
		log.info("首页=>实际接收情况");
		return super.query(new ServiceHandlerAdapter() {
			@Override
			public Object serviceQueryOperate() {
				return homePageService.sjjsqk(qc);
			}
		});

	}






}



















