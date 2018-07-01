package com.cd.zjyf.service;

import com.cd.zjyf.annotation.ClearReidsCache;
import com.cd.zjyf.bean.YlfwJsdj;
import com.cd.zjyf.bean.YlfwJsdjExample;
import com.cd.zjyf.enums.ServiceRangeCode;
import com.cd.zjyf.exception.SystemException;
import com.cd.zjyf.exception.ValidateException;
import com.cd.zjyf.mapper.AppMapper;
import com.cd.zjyf.mapper.YlfwJsdjMapper;
import com.cd.zjyf.mapper.YlwsJbxxMapper;
import com.cd.zjyf.pojo.qc.YSZDetailQC;
import com.cd.zjyf.pojo.qr.SummaryByQRcodeQR;
import com.cd.zjyf.pojo.qr.YSZindexQR;
import com.cd.zjyf.utils.CodeMessage;
import com.cd.zjyf.utils.CommonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
public class YSZService {

	@Autowired
	private AppMapper appMapper;


	
	@Autowired
	private YlfwJsdjMapper ylfwJsdjMapper;
	

	
	
	private static Logger log = LoggerFactory.getLogger(YSZService.class);
	
	


	//运输者首页
	public List<YSZindexQR> selectYSZindex(String id) {
		return appMapper.selectYSZindex(id);
	}

	//运输者首页点入详情列表
	public List<YSZindexQR> selectYSZindexDetailList(YSZDetailQC qc) {
		//分页放拦截器？
		return appMapper.selectYSZindexDetailList(qc);
	}


	/**
	 * 运输者清算
	 * @param o 接收等级信息表
	 * @return
	 * @throws ValidateException
	 * @throws SystemException
	 */
	@ClearReidsCache
	public String update(YlfwJsdj o) throws ValidateException, SystemException {
		CommonUtil.basicValidate(o);
		YlfwJsdjExample ylfwJsdjExample = new YlfwJsdjExample();
		ylfwJsdjExample.createCriteria().andZcdidEqualTo(o.getZcdid())
		.andJsqkEqualTo(ServiceRangeCode.WJS.getCode());
		o.setEndtime(new Date());//修改结算时间为当前时间
		try { 
			//Selective选择不为null的插入，防止破坏sql表中的默认值
			ylfwJsdjMapper.updateByExampleSelective(o, ylfwJsdjExample);
		}catch(Exception be) {
			throw new SystemException();
		}
		 return CodeMessage.OPERATION_SUCCESS.getCode();//与前端的约定，所有操作必须有返回值，null则视为操作失败
	}


	public  SummaryByQRcodeQR selectSummaryZCD(String zcdid) {
		return appMapper.selectSummaryZCD(zcdid);
	}


}


