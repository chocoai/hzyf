package com.cd.zjyf.mapper;

import com.cd.zjyf.pojo.qc.HomePageQC;
import com.cd.zjyf.pojo.qr.HomePage.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by chen.shuodong on 2018/5/3.
 */
@Mapper
public interface HomePageMapper {



    //本区域近6个月废物收集情况按月份统计
    List<MonthZL> listYFZLByMonth(HomePageQC r);

    //本区域本月废物收集情况按类型统计
    List<LX> listYFZLByOne(HomePageQC r);

    //长期未收集单位列表
    List<DWnocollect> listDWnocollect(HomePageQC r);

    //查找字典表
    String selectConfig(String str);
    //地区下拉
    List<AreaDropdown> areaDropdown(HomePageQC r);
    //地区年总收集重量（清算时间）
    YearTotal yearTotalZL(HomePageQC r);
    //16年开始近5年的垃圾收集情况和单位数量(清算时间)
    List<QST> qst(HomePageQC r);

    //实际接收情况
    List<SJSJQK> sjjsqk(HomePageQC r);




}
