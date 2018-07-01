package com.cd.zjyf.management.bean;

/**
 * Created by li.mingyang on 2018/5/26.
 */
public class WxResponse {

    private String session_key;

    private String openid;

    private Integer errcode;

    private String errmsg;

    public String getSession_key() {
        return session_key;
    }
    public void setSession_key(String session_key) {
        this.session_key = session_key;
    }

    public String getOpenid() {
        return openid;
    }
    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public Integer getErrcode() {
        return errcode;
    }
    public void setErrcode(Integer errcode) {
        this.errcode = errcode;
    }

    public String getErrmsg() {
        return errmsg;
    }
    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }
}
