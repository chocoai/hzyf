package com.cd.zjyf.mapper;

import com.cd.zjyf.annotation.NoPaging;
import com.cd.zjyf.bean.*;
import com.cd.zjyf.pojo.AreaTree;
import com.cd.zjyf.pojo.Dropdown;
import com.cd.zjyf.pojo.qc.*;
import com.cd.zjyf.pojo.qr.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
@NoPaging
public interface AppMapper {

	AppUser selectByPrimaryKeyHasYLJG(String id);

	List<UserQueryDataQR> selectUserQuerydata(UserQuerydataQC qc);

	Areainfo selectByPrimaryKey(String code);

	AreaTree getArea(String areacode);

	List<AreaTree> getAreaChildren(String areacde);

	JgdwJbxx selectGLZxzqh(String id);

	TGZqueryByQRcodeQR selectByTGZqueryByQRcode(String id);

	//收集员扫码通过交接员ID查询
	SJZqueryByQRcodeQR selectBySJZqueryByQRcodeByTGZID(String o);
	//收集员扫码通过产生点ID查询
	SJZqueryByQRcodeQR selectBySJZqueryByQRcodeByCSDID(String o);


	//查询该收集员所有产生点单位列表,根据收集员id
	List<YlwsJbxx> selectCSDdwList(String id);

	//交接员收首页
	List<com.cd.zjyf.pojo.YlfwJsdj> selectTGZindex(String tgzid);
	//收集员首页
	List<SJZindexQR> selectSJZindex(String id);
	//运输者首页
	List<YSZindexQR> selectYSZindex(String id);
	List<YSZindexQR> selectYSZindexDetailList(YSZDetailQC qc);

	//管理者首页
	List<GLZindexQR> selectGLZindex(String id);

	List<GLZrefuseQR> selectGLZrefuseList(String id);

	List<TGZstatisticsFWQR> selectTGZstatisticsFW(TGZstatisticsFWQC qc);
	//扫描汇总产生点
	List<SummaryByQRcodeQR> selectSummaryCSD(SJZSummaryQC qc);
	//扫描汇总暂存点
	SummaryByQRcodeQR selectSummaryZCD(String zcdid);

	//收集历史信息详细查询
	SJZqueryByQRcodeQR selectTGZhistoryInfo(String id);

	//管理者行政区划统计，按市,区,县
	@Deprecated
	List<GLZstatisticsQR> selectGLZstatisticsForCity(GLZstatisticsQC qc);
	@Deprecated
	List<GLZstatisticsQR> selectGLZstatisticsForArea(GLZstatisticsQC qc);
	@Deprecated
	List<GLZstatisticsQR> selectGLZstatisticsForXian(GLZstatisticsQC qc);

	List<GLZstatisticsQR> selectGLZstatistics(GLZstatisticsQC qc);

	//暂存点
	GLZstat gLZstatZCD(GLZstatisticsQC qc);
	//产生点
	List<CSDlist> gLZstatCSD(GLZstatisticsQC qc);

	//产生点单个
	CSDlist gLZstatCSDsingle(GLZstatisticsQC qc);

	//流水
	List<Jsdj> gLZstatJSDJ(GLZstatisticsQC qc);


	int updateByZCDid(YlfwJsdj record);

	List<SJZqueryByQRcodeQR> selectTGZhistoryList(SJZhistoryListQC o);
	//管理者首页及条件查询
	List<GLZdwnocollectQR> selectGLZnocollect(GLZdwnocollectQC qc);

	List<GLZzcdlistQR> getZcdlist(String xzqh);

    List<Dropdown> gLZstatDropdown(GLZstatisticsQC qc);
}