package com.cd.uap.bean;

/**
 * Created by li.mingyang on 2018/4/20.
 */
public enum IsshCode {

    UNREVIEW("0"),      //未审核
    PASS("1"),          //审核通过
    UNPASS("2"),        //审核未通过
    REVIEW("3");   //待审核

    private String issh;

    IsshCode(String issh) {
        this.issh = issh;
    }

    public String getIssh() {
        return issh;
    }
}
