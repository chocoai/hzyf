package com.cd.zjyf.pojo.qc;

import com.cd.zjyf.pojo.LoginUserInfo;
import com.cd.zjyf.utils.AccountValidatorUtil;

import javax.validation.constraints.Pattern;

/**
 * 首页的查询条件
 */
public class HomePageQC extends LoginUserInfo {
        private int timeType;//1本日 2本周 3本月 4年
        private String SqlSegment;//sql片段

    public String getSqlSegment() {
        return SqlSegment;
    }

    public void setSqlSegment(String sqlSegment) {
        SqlSegment = sqlSegment;
    }

    public int getTimeType() {
        return timeType;
    }

    public void setTimeType(int timeType) {
        this.timeType = timeType;
    }
}