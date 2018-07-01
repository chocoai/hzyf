package com.cd.zjyf.mapper;

import com.cd.zjyf.annotation.NoPaging;
import com.cd.zjyf.pojo.qc.CarLocationPlayback;
import com.cd.zjyf.pojo.qc.Region;
import com.cd.zjyf.pojo.qr.*;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
@NoPaging
public interface ScreenMapper {

	


	//辖区本月废物收集情况按地区统计
	List<OneMonthSJ> listYFZLByOneMonth(Region r);
	//本区域本月废物收集情况按类型统计
	List<LX> listYFZLByOne(Region r);

	//地理信息获取
	List<DLXX> listDLXX(Region r);
	//单位列表信息获取

	List<DLXX> listDWinfo(Region r);
	//暂存点
	@Deprecated
	List<DLXX> listZCD(Region r);
	//诊所
	@Deprecated
	List<DLXX> listZC(Region r);


	//长期未收集单位列表
	List<DWnocollect> listDWnocollect(Region r);
	//医废视频监控查看
	//Object lookSP(Region r);
	//具体单位收集情况
	String preListDWsjqk(Region r);
	List<SJQK2> listDWsjqk2(Region r);
	
	//查找字典表
	String selectConfig(String str);
	//地区下拉
	List<AreaDropdown> areaDropdown(Region r);
	//地区年总收集重量（清算时间）
	String yearTotalZL(Region r);
	//16年开始近5年的垃圾收集情况和单位数量(清算时间)
	List<QST> qst(Region r);
	
	//实际接收情况
	List<SJSJQK> sjjsqk(Region r);
	//地区产生点列表
	List<CSDlist> csdList(Region r);
	//地区暂存点列表
	List<ZCDlist> zcdList(Region r);
	//车辆定位
	List <CarLocation> carLocation(Region r);

	//今年收集各地区重量
	List <AreaZL> areaZL(Region r);
	
	//智能监管
	ZNJG znjg(Region r);
	
	String queryHKDevice(String id);

	List<CarLocation> carLocationPlayback(CarLocationPlayback carLocationPlayback);

	@Delete("DELETE FROM tbl_carlocation \n" +
			"where   date(create_time)<DATE_SUB(CURDATE(), INTERVAL ${day} DAY)")
	int removeCarlocation(@Param("day") int day);



}