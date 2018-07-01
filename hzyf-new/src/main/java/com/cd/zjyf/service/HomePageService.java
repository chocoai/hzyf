package com.cd.zjyf.service;

import com.cd.zjyf.annotation.NoPaging;
import com.cd.zjyf.annotation.ReidsCache;
import com.cd.zjyf.config.ApplicationConfig;
import com.cd.zjyf.mapper.HomePageMapper;
import com.cd.zjyf.pojo.qc.HomePageQC;
import com.cd.zjyf.pojo.qr.HomePage.*;
import com.cd.zjyf.utils.CommonUtil;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by chen.shuodong on 2018/5/3.
 */
@Service
@ReidsCache
@NoPaging
public class HomePageService {


    @Autowired
    private HomePageMapper mapper;



    private static Logger log = LoggerFactory.getLogger(HomePageService.class);



 /*   public List<DWcount> listDWByRegion(HomePageQC qc) {
        return mapper.listDWByRegion(qc);
    }*/

    public List<MonthZL>  listYFZLByMonth(HomePageQC qc) {
        return mapper.listYFZLByMonth(qc);
    }



    public LXobj  listYFZLByOne(HomePageQC qc) {
        List<LX> lxs = mapper.listYFZLByOne(qc);
        if(lxs.size()==0) return null;
        LX total = lxs.get(lxs.size()-1);
        lxs.remove(lxs.size()-1);//移除总数的那个值
        float zCount = total.getCount();
        //设置LXobj作为返回对象
        LXobj lXobj = new LXobj();
        lXobj.setLxs(CommonUtil.getListRangValue(lxs));
        lXobj.setzCount(zCount);
        return lXobj;
    }

    /**
     * (ol)
     * @param qc
     * @return
     */
    public List<DWnocollect>  listDWnocollect(HomePageQC qc) {
        //PageHelper.startPage(ApplicationConfig.pageNum,ApplicationConfig.pageSize);
        qc.setSqlSegment(getLONG_NOCOLLECT_DAYS(ApplicationConfig.LONG_NOCOLLECT_DAYS));
        PageHelper.startPage(1, 5);
        return mapper.listDWnocollect(qc);
    }

    private String getLONG_NOCOLLECT_DAYS(String str) {
        return mapper.selectConfig(str);
    }



    //地区年总收集重量（清算时间）
    public YearTotal yearTotalZL(HomePageQC qc) {
        return mapper.yearTotalZL(qc);
    }

    //16年开始近5年的垃圾收集情况和单位数量(清算时间)
    public List<QST>  qst(HomePageQC qc) {
        return mapper.qst(qc);
    }

    //实际接收情况
    @ReidsCache(false)
    public List<SJSJQK>  sjjsqk(HomePageQC qc) {
        PageHelper.startPage(1, 5);
        return mapper.sjjsqk(qc);
    }






}
