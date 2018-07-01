package com.cd.zjyf.service;

import com.cd.zjyf.annotation.Paging;
import com.cd.zjyf.bean.JgdwJbxx;
import com.cd.zjyf.bean.YlfwJsdj;
import com.cd.zjyf.enums.ServiceRangeCode;
import com.cd.zjyf.exception.SystemException;
import com.cd.zjyf.exception.UpdateResultZeroException;
import com.cd.zjyf.exception.ValidateException;
import com.cd.zjyf.mapper.*;
import com.cd.zjyf.pojo.AreaTree;
import com.cd.zjyf.pojo.Dropdown;
import com.cd.zjyf.pojo.GenerSaveOrUpdateBean;
import com.cd.zjyf.pojo.qc.GLZdwnocollectQC;
import com.cd.zjyf.pojo.qc.GLZstatisticsQC;
import com.cd.zjyf.pojo.qr.*;
import com.cd.zjyf.utils.CommonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GLZService {

	@Autowired
	private AppMapper appMapper;

	@Autowired
	private YlwsJbxxMapper ylwsJbxxMapper;

	@Autowired
	private YlfwJsdjMapper ylfwJsdjMapper;

	@Autowired
	private JgdwJbxxMapper JgdwJbxxMapper;

	@Autowired
	private AreainfoMapper areainfoMapper;

	private static Logger log = LoggerFactory.getLogger(GLZService.class);


	/**
	 * 管理者首页
	 * @param id 管理员id
	 * @return
	 */
	public List<GLZindexQR> selectGLZindex(String id) {
		return appMapper.selectGLZindex(id);
	}


	/**
	 * 管理者拒收列表
	 * @param id 管理员id
	 * @return
	 */
	@Deprecated
	public List<GLZrefuseQR> selectGLZrefuseList(String id) {
		return appMapper.selectGLZrefuseList(id);
	}




	/**
	 * 管理者拒收处理
	 * @param bean
	 * @return
	 * @throws SystemException
	 * @throws UpdateResultZeroException
	 * @throws ValidateException
	 */
	public String updateGLZrefuse(GenerSaveOrUpdateBean bean) throws SystemException, UpdateResultZeroException  {
		YlfwJsdj ylfwJsdj = new YlfwJsdj();
		ylfwJsdj.setId(bean.getId());
		ylfwJsdj.setJsqk(ServiceRangeCode.JJYCL.getCode());
		int count=0;
		try {
			//Selective选择不为null的插入，防止破坏sql表中的默认值
			 count = ylfwJsdjMapper.updateByPrimaryKeySelective(ylfwJsdj);
		}catch(Exception be) {
			throw new SystemException();
		}
		if(count==0) {
			throw new UpdateResultZeroException("拒收失败：请检查参数！");
		}
		 return bean.getId();
	}

	/**
	 * 管理者统计
	 * @param id 管理者id
	 * @return
	 */
/*	public List<GLZstatisticsQR> selectGLZstatistics(GLZstatisticsQC qc) {
		 JgdwJbxx jgdwJbxx = JgdwJbxxMapper.selectGLZxzqh(qc.getId());
		 String xzqh = jgdwJbxx.getXzqh();//行政区划
		 qc.setXzqh(xzqh);//查出来该管理员的行政区划放入查询条件中
		 String bmjb = jgdwJbxx.getBmjb();//行政区划级别
		 List<GLZstatisticsQR> gLZstatisticsQR =null;
		 if(ServiceRangeCode.SJ.getCode().equals(bmjb)) {
			 gLZstatisticsQR=  appMapper.selectGLZstatisticsForCity(qc);
		 }else if(ServiceRangeCode.SHIJ.getCode().equals(bmjb)) {
			 gLZstatisticsQR= appMapper.selectGLZstatisticsForArea(qc);
		 }else {
			 gLZstatisticsQR=appMapper.selectGLZstatisticsForXian(qc);
		 }
		 return gLZstatisticsQR;
	}*/
	public List<GLZstatisticsQR> selectGLZstatistics(GLZstatisticsQC qc) {
	//	qc.setXzqh(CommonUtil.translateXZQH(qc.getXzqh()));
		JgdwJbxx jgdwJbxx = appMapper.selectGLZxzqh(qc.getId());
		jgdwJbxx.translateXZQH();
		String xzqh = jgdwJbxx.getXzqh();//行政区划
		qc.setXzqh(xzqh);//查出来该管理员的行政区划放入查询条件中
		String bmjb = jgdwJbxx.getBmjb();//行政区划级别
		List<GLZstatisticsQR> gLZstatisticsQR =null;
		qc.setBmjb(bmjb);

		gLZstatisticsQR=  appMapper.selectGLZstatistics(qc);

		return gLZstatisticsQR;
	}


	/**
	 * 管理者统计
	 * @param qc
	 * @return
	 */
	public GLZstat selectGLZstatisticsByType(GLZstatisticsQC qc) {
	//	qc.setXzqh(CommonUtil.translateXZQH(qc.getXzqh()));//市行政区划转化（这里不需要转化）
		GLZstat glZstat=null;
		if("1".equals(qc.getType())){
			 glZstat = new GLZstat();
			//行政区划等级可能要改动,先做下面两个
			String bmjb = String.valueOf(CommonUtil.getLevelByRegionCode(qc.getXzqh()));//行政区划级别
			qc.setBmjb(bmjb);
			glZstat.setgLZstatisticsQR(appMapper.selectGLZstatistics(qc));
		}else if("2".equals(qc.getType())){ //按暂存点统计
			glZstat = appMapper.gLZstatZCD(qc);
			if(glZstat!=null) {
				List<CSDlist> csDlists = appMapper.gLZstatCSD(qc);
				glZstat.setcSDlist(csDlists);
			}
		}else if("3".equals(qc.getType())){ //按产生点统计
			glZstat = new GLZstat();
			CSDlist csDlist = appMapper.gLZstatCSDsingle(qc);
			List<CSDlist> csDlists = new ArrayList<>();
			if(csDlist!=null) {
				csDlists.add(csDlist);
			}
			glZstat.setcSDlist(csDlists);
		}

		return glZstat;
	}

	/**
	 * 管理者统计产生点的流水列表（分页）
	 * @param qc
	 * @return
	 */
	@Paging(total=false)
	public List<Jsdj> gLZstatJSDJ(GLZstatisticsQC qc) {
		return 	CommonUtil.getListRangValue(appMapper.gLZstatJSDJ(qc));
	}


	public List<Dropdown> gLZstatDropdown(GLZstatisticsQC qc) {
		return 	appMapper.gLZstatDropdown(qc);
	}




	/**
	 * 地区级联,通过地区
	 * 	如果三级机构，那么=查一次，截取前两个机构名，各精确查一次
		如果二级机构，那么like_ 查一次，截取机构名，精确查一次
		如果一级机构，那么like_查两次
	 * @return AreaTree
	 */
	public AreaTree getArea(String areacode) {
		AreaTree areaTreelv1=null;
		int level=getLevelByRegionCode(areacode);
		if(level==1) {
			areaTreelv1 = appMapper.getArea(areacode);
			List<AreaTree> areaTreelv2 = appMapper.getAreaChildren(areacode);
			for(AreaTree areaTreelv2$:areaTreelv2) {
				List<AreaTree> areaTreelv3 = appMapper.getAreaChildren(areaTreelv2$.getCode());
				areaTreelv2$.setchildren(areaTreelv3);
			}
			areaTreelv1.setchildren(areaTreelv2);

		}else if(level==2){

			String areaCodelv1=getAreaCodelv1(areacode);
			areaTreelv1 = appMapper.getArea(areaCodelv1);
			AreaTree areaTreelv2 = appMapper.getArea(areacode);
			List<AreaTree> areaTreelv3 = appMapper.getAreaChildren(areacode);

			areaTreelv1.setItem(areaTreelv2);
			areaTreelv2.setchildren(areaTreelv3);

		}else if(level==3) {
			AreaTree areaTreelv3 = appMapper.getArea(areacode);
			String areaCodelv1=getAreaCodelv1(areaTreelv3.getCode());
			String areaCodelv2=getAreaCodelv2(areaTreelv3.getCode());
			areaTreelv1 = appMapper.getArea(areaCodelv1);
			AreaTree areaTreelv2 = appMapper.getArea(areaCodelv2);

			areaTreelv1.setItem(areaTreelv2);
			areaTreelv2.setItem(areaTreelv3);
		}
		return areaTreelv1;
	}



	/**
	 * 获取一级机构编码
	 * @param areaCode
	 * @return
	 */
	private String getAreaCodelv1(String areaCode) {
		return areaCode.split(",")[0];
	}
	
	/**
	 * 获取二级机构编码(warn:数据库地区编码中，之间带有空格)
	 * @param areaCode
	 * @return
	 */
	private String getAreaCodelv2(String areaCode) {
		return areaCode.split(",")[0]+","+areaCode.split(",")[1];
	}
	
	
	
	private int getLevelByRegionCode(String regionCode) {
		return regionCode!=null?regionCode.split(",").length:0;
		//return regionCode.split(",").length;
	}
	
	/**
	 * 管理者首页及条件查询
	 * @param qc
	 * @return
	 */
	public  List<GLZdwnocollectQR> selectGLZnocollect(GLZdwnocollectQC qc){
		//qc.setXzqh(CommonUtil.translateXZQH(qc.getXzqh()));
		return appMapper.selectGLZnocollect(qc);
	}
	
	/**
	 * 暂存点单位下来列表
	 */
	public List<GLZzcdlistQR> getGLZzcdlist(String xzqh) {
		return appMapper.getZcdlist(xzqh);
	}
}


