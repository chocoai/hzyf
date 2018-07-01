package com.cd.zjyf.service;

import com.cd.zjyf.annotation.ClearReidsCache;
import com.cd.zjyf.bean.AppUser;
import com.cd.zjyf.config.ApplicationConfig;
import com.cd.zjyf.enums.ServiceRangeCode;
import com.cd.zjyf.exception.SystemException;
import com.cd.zjyf.exception.ValidateException;
import com.cd.zjyf.mapper.AppMapper;
import com.cd.zjyf.mapper.AppUserMapper;
import com.cd.zjyf.pojo.TGZstatisticsFWlist;
import com.cd.zjyf.pojo.qc.TGZstatisticsFWQC;
import com.cd.zjyf.pojo.qr.TGZqueryByQRcodeQR;
import com.cd.zjyf.pojo.qr.TGZstatisticsFWQR;
import com.cd.zjyf.utils.CodeMessage;
import com.cd.zjyf.utils.CommonUtil;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class TGZService {

	@Autowired
	private AppMapper appMapper;

	@Autowired
	private AppUserMapper appUserMapper;
	


	
	private static Logger log = LoggerFactory.getLogger(TGZService.class);
	
	
		
	/**
	 * 根据二维码ID查找
	 * @param id
	 * @param userid 
	 * @return
	 * @throws ValidateException 
	 */
	public TGZqueryByQRcodeQR selectByTGZqueryByQRcodeBean(String id, String userid) throws ValidateException {
		if(id==null) throw new ValidateException(CodeMessage.QRCODE_ERROR.getMsg());
		TGZqueryByQRcodeQR qr = appMapper.selectByTGZqueryByQRcode(id);
		//如果单位名称不存在，有可能扫的是暂存点的单位二维码
		 if(qr==null||qr.getDwmc()==null) 	throw new ValidateException(CodeMessage.QRCODE_ERROR.getMsg());
		 qr.setUserid(userid);
		return qr;
	}
	
	
	
	/**
	 * 根据人员ID绑定用户信息
	 * @param id
	 * @return 
	 * @return
	 * @throws SystemException 
	 * @throws ValidateException 
	 */
	@ClearReidsCache
	public String bondingAppUser(AppUser appUser) throws SystemException, ValidateException {
		CommonUtil.basicValidate(appUser);
		try {
			appUserMapper.updateByPrimaryKeySelective(appUser);
		}catch(Exception be) {
			throw new SystemException();
		}
		 return appUser.getId();
	}
	
	
/*	*//**
	 * 用于展示提供废物列表、用户信息。提供废物列表按时间从近到远排序最多显示10条。
	 * @param id
	 * @return
	 *//*
	public List<YlfwJsdj> selectTGZfirstPageList(String tgzid) {
		PageHelper.startPage(ApplicationConfig.pageNum,ApplicationConfig.pageSize);	
		YlfwJsdjExample ylfwJsdjExample = new YlfwJsdjExample();
		ylfwJsdjExample.createCriteria().andTgzidEqualTo(tgzid);
		ylfwJsdjExample.setOrderByClause("jstime desc");
		List<YlfwJsdj> selectByExample = ylfwJsdjMapper.selectByExample(ylfwJsdjExample);
		return selectByExample;
	}*/
	
	/**
	 * 用于展示提供废物列表、用户信息。提供废物列表按时间从近到远排序最多显示10条。
	 * @param id
	 * @return
	 */
	public List<com.cd.zjyf.pojo.YlfwJsdj> selectTGZfirstPageList(String tgzid) {
		PageHelper.startPage(ApplicationConfig.pageNum,ApplicationConfig.pageSize);	
		//重新写sql，返回一个新的bean
		 return appMapper.selectTGZindex(tgzid);
	}
	

	//交接员废物统计
	public TGZstatisticsFWlist selectTGZstatisticsFW(TGZstatisticsFWQC qc) {
		List<TGZstatisticsFWQR> qr = appMapper.selectTGZstatisticsFW(qc);
		if(qr.size()==0) return null;
		supplyType(qr);
	//	qr.stream().forEach(action);
//		qr.get(0).getLx().equals("");
		return new TGZstatisticsFWlist(qr,qr);
	}
	
	private void supplyType(List<TGZstatisticsFWQR> qr) {
		List<String> list=new ArrayList<String>();
		for(TGZstatisticsFWQR q: qr) {
			list.add(q.getLx());
		}
		if(!list.contains(ServiceRangeCode.SSXFW.getCode())) {
			qr.add(new TGZstatisticsFWQR(ServiceRangeCode.SSXFW.getCode()));
		}
		if(!list.contains(ServiceRangeCode.GRXFW.getCode())) {
			qr.add(new TGZstatisticsFWQR(ServiceRangeCode.GRXFW.getCode()));
		}
		if(!list.contains(ServiceRangeCode.BLXFW.getCode())) {
			qr.add(new TGZstatisticsFWQR(ServiceRangeCode.BLXFW.getCode()));
		}
		if(!list.contains(ServiceRangeCode.YWXFW.getCode())) {
			qr.add(new TGZstatisticsFWQR(ServiceRangeCode.YWXFW.getCode()));
		}
		if(!list.contains(ServiceRangeCode.HXXFW.getCode())) {
			qr.add(new TGZstatisticsFWQR(ServiceRangeCode.HXXFW.getCode()));
		}
		Collections.sort(qr,new Comparator<TGZstatisticsFWQR>() {
			@Override
			public int compare(TGZstatisticsFWQR o1, TGZstatisticsFWQR o2) {
				return o1.getLx().compareTo(o2.getLx());
			}
	    });
		
	}
	
/*	public static void main(String[] args) {
		List<TGZstatisticsFWQR> qr= new ArrayList<TGZstatisticsFWQR>();
		qr.add(new TGZstatisticsFWQR("03"));
		qr.add(new TGZstatisticsFWQR("02"));
		qr.add(new TGZstatisticsFWQR("08"));
		qr.add(new TGZstatisticsFWQR("合计"));
		qr.add(new TGZstatisticsFWQR("04"));
		Collections.sort(qr,new Comparator<TGZstatisticsFWQR>() {
			@Override
			public int compare(TGZstatisticsFWQR o1, TGZstatisticsFWQR o2) {
				return o1.getLx().compareTo(o2.getLx());
			}
	    });
		
		System.out.println(qr.get(0).getLx());
		System.out.println(qr.get(1).getLx());
		System.out.println(qr.get(2).getLx());
		System.out.println(qr.get(3).getLx());
		System.out.println(qr.get(4).getLx());
	}
	*/


}


