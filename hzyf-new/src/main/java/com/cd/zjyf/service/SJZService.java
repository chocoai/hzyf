package com.cd.zjyf.service;

import com.cd.zjyf.annotation.ClearReidsCache;
import com.cd.zjyf.bean.AppUser;
import com.cd.zjyf.bean.AppUserExample;
import com.cd.zjyf.bean.YlfwJsdj;
import com.cd.zjyf.bean.YlwsJbxx;
import com.cd.zjyf.enums.ServiceRangeCode;
import com.cd.zjyf.exception.SystemException;
import com.cd.zjyf.exception.ValidateException;
import com.cd.zjyf.mapper.AppMapper;
import com.cd.zjyf.mapper.AppUserMapper;
import com.cd.zjyf.mapper.YlfwJsdjMapper;
import com.cd.zjyf.mapper.YlwsJbxxMapper;
import com.cd.zjyf.pojo.PageBean;
import com.cd.zjyf.pojo.qc.SJZSummaryQC;
import com.cd.zjyf.pojo.qc.SJZhistoryListQC;
import com.cd.zjyf.pojo.qc.SJZqueryByQRcodeQC;
import com.cd.zjyf.pojo.qr.SJZindexQR;
import com.cd.zjyf.pojo.qr.SJZqueryByQRcodeQR;
import com.cd.zjyf.pojo.qr.SJZvalidateResultQR;
import com.cd.zjyf.pojo.qr.SummaryByQRcodeQR;
import com.cd.zjyf.utils.CodeMessage;
import com.cd.zjyf.utils.CommonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SJZService {
	@Autowired
	private AppMapper appMapper;

	@Autowired
	private AppUserMapper appUserMapper;

	@Autowired
	private YlwsJbxxMapper ylwsJbxxMapper;

	@Autowired
	private YlfwJsdjMapper ylfwJsdjMapper;
	// 暂存点一致
	public static final String ZCD_IDENTICAL = "1";
	// 暂存点不一致
	public static final String ZCD_NOT_IDENTICAL = "0";

	private static Logger log = LoggerFactory.getLogger(SJZService.class);

	/**
	 * 收集员首页
	 * 
	 * @param id
	 *            收集员id
	 * @return
	 */
	public List<SJZindexQR> selectSJZindex(String id) {
		return appMapper.selectSJZindex(id);
	}

	/**
	 * 保存jsdj表
	 * 
	 * @param o
	 * @return
	 * @throws ValidateException
	 * @throws SystemException
	 */
	@ClearReidsCache
	public String save(YlfwJsdj o) throws ValidateException, SystemException {
		CommonUtil.basicValidate(o);
		try {
			// Selective选择不为null的插入，防止破坏sql表中的默认值
			ylfwJsdjMapper.insertSelective(o);
		} catch (Exception be) {
			throw new SystemException(be);
		}
		return o.getId();
	}

	/**
	 * sjz扫描判断扫的单位上级属于该sjz的暂存点单位
	 * 
	 * @param o
	 *            产生点单位或交接员主键
	 * @return
	 * @throws ValidateException
	 */
	public SJZvalidateResultQR selectBySJZqueryByQRcodeBeanIsZCD(SJZqueryByQRcodeQC qc) throws ValidateException {
		if (qc == null || qc.getId() == null)
			throw new ValidateException(CodeMessage.QRCODE_ERROR.getMsg());
		// 先根据交接员主键查，如果没有查产生点主键
		SJZqueryByQRcodeQR sJZqueryByQRcodeQR = appMapper.selectBySJZqueryByQRcodeByTGZID(qc.getId());
		if (sJZqueryByQRcodeQR == null) {
			sJZqueryByQRcodeQR = appMapper.selectBySJZqueryByQRcodeByCSDID(qc.getId());
		}
		// TODO 这边要处理如果二维码错误，要返回一个异常
		if (sJZqueryByQRcodeQR != null) {
			sJZqueryByQRcodeQR.setId(CommonUtil.getUUID());// 在扫描二维码时，返回给前端jsdj表的主键
		} else {
			throw new ValidateException(CodeMessage.QRCODE_ERROR.getMsg());
		}

		AppUser user = appMapper.selectByPrimaryKeyHasYLJG(qc.getUserid());
		String isZCD = null;
		String zcdmc = null;
		if (user.getYljgid().equals(sJZqueryByQRcodeQR.getZcdid())) {
			isZCD = ZCD_IDENTICAL;
		} else {
			isZCD = ZCD_NOT_IDENTICAL;
			zcdmc = sJZqueryByQRcodeQR.getZcdmc();
			if (zcdmc == null) {// 这里过滤了暂存点的二维码
				throw new ValidateException(CodeMessage.QRCODE_ERROR.getMsg());
			}
			// zcdmc=user.getYljgmc();
		}
		SJZvalidateResultQR qr = new SJZvalidateResultQR();
		qr.setIsZCD(isZCD);
		qr.setZcdmc(zcdmc);
		return qr;
	}

	/**
	 * sjz扫描显示的信息查询
	 * 
	 * @param o
	 *            产生点单位或交接员主键
	 * @return
	 * @throws ValidateException
	 */
	public SJZqueryByQRcodeQR selectBySJZqueryByQRcodeBean(String o) throws ValidateException {
		if (o == null)
			throw new ValidateException(CodeMessage.QRCODE_ERROR.getMsg());
		// 先根据交接员主键查，如果没有查产生点主键
		SJZqueryByQRcodeQR sJZqueryByQRcodeQR = appMapper.selectBySJZqueryByQRcodeByTGZID(o);
		if (sJZqueryByQRcodeQR == null) {
			sJZqueryByQRcodeQR = appMapper.selectBySJZqueryByQRcodeByCSDID(o);
		}
		if (sJZqueryByQRcodeQR != null) {
			sJZqueryByQRcodeQR.setId(CommonUtil.getUUID());// 在扫描二维码时，返回给前端jsdj表的主键
		} else {
			throw new ValidateException(CodeMessage.QRCODE_ERROR.getMsg());
		}
		return sJZqueryByQRcodeQR;
	}

	/**
	 * 根据产生点id 查询处所有改产生点下的交接员
	 * 
	 * @param csdid
	 * @return
	 */
	public List<AppUser> selectTGZByCSDID(String csdid) {
		AppUserExample appUserExample = new AppUserExample();
		appUserExample.createCriteria().andYljgidEqualTo(csdid)
				.andZgztEqualTo(ServiceRangeCode.ON_GUARD.getCode());//剔除离岗状态的人员
		return appUserMapper.selectByExample(appUserExample);
	}

	/**
	 * 收集历史信息详细查询
	 * 
	 * @param id
	 *            接收等级表主键
	 * @return
	 */
	public SJZqueryByQRcodeQR selectTGZhistoryInfo(String id) {
		return appMapper.selectTGZhistoryInfo(id);
	}

	/**
	 * 收集历史信息列表
	 * 
	 * @param o
	 *            SJZhistoryListQC对象
	 * @return
	 */
	public PageBean<SJZqueryByQRcodeQR> selectTGZhistoryList(SJZhistoryListQC o) {
		// Page<?> page = PageHelper.startPage(o.getPage(), o.getSize());
		List<SJZqueryByQRcodeQR> historyList = appMapper.selectTGZhistoryList(o);
		return CommonUtil.getPageBean(historyList);
	}

	// 查询该收集员所有产生点单位列表
	public List<YlwsJbxx> selectCSDdwList(String id) {
		return appMapper.selectCSDdwList(id);
	}

	/**
	 * 收集历史信息详情的修改
	 * 
	 * @param o
	 * @return
	 * @throws SystemException
	 * @throws ValidateException
	 */
	public String updateHistoryInfo(YlfwJsdj o) throws SystemException, ValidateException {
		CommonUtil.basicValidate(o);
		try {
			// Selective选择不为null的插入，防止破坏sql表中的默认值
			ylfwJsdjMapper.updateByPrimaryKeySelective(o);
		} catch (Exception be) {
			throw new SystemException();
		}
		return o.getId();
	}

	/**
	 * 扫描汇总各生产点情况
	 * 
	 * @param zcdid
	 *            暂存者id
	 * @return
	 * @throws ValidateException
	 */
	public List<SummaryByQRcodeQR> selectSummaryCSD(SJZSummaryQC qc) throws ValidateException {
		YlwsJbxx ylwsJbxx = ylwsJbxxMapper.selectByPrimaryKey(qc.getId());
		if (ylwsJbxx == null)
			throw new ValidateException(CodeMessage.QRCODE_ERROR.getMsg());

		List<SummaryByQRcodeQR> qr = appMapper.selectSummaryCSD(qc);

		//TODO 这里给对象中的qsrxm赋值
		return qr;
	}

	/**
	 * 收集员扫运输者二维码清算汇总（新）
	 * 
	 * @param qc（id：暂存点id;yszid）
	 * @return
	 * @throws ValidateException
	 */
	public SummaryByQRcodeQR selectSummaryZCD(SJZSummaryQC qc) throws ValidateException {
		AppUser user = appUserMapper.selectByPrimaryKey(qc.getQsrid());
		if (user == null)
			throw new ValidateException(CodeMessage.QRCODE_ERROR.getMsg());
		SummaryByQRcodeQR selectSummaryZCD = appMapper.selectSummaryZCD(qc.getId());
		if (selectSummaryZCD != null) {
			selectSummaryZCD.setQsrxm(user.getXm());
			selectSummaryZCD.setZcdid(qc.getId());
		}
		// return selectSummaryZCD==null?new SummaryByQRcodeQR():selectSummaryZCD;
		return selectSummaryZCD;
	}
}
