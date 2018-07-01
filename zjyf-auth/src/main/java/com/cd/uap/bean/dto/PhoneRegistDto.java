package com.cd.uap.bean.dto;

import com.cd.uap.entity.User;

/**
 * Created by li.mingyang on 2018/4/20.
 */
public class PhoneRegistDto extends User {

    private String validateCode;

    public String getValidateCode() {
        return validateCode;
    }

    public void setValidateCode(String validateCode) {
        this.validateCode = validateCode;
    }
}
