package com.cd.zjyf.enums;

import org.apache.commons.lang.StringUtils;



/**
 * @author chen.shuodong
 *
 */
//医疗机构类型	N	N1	Y	1暂存点2科室3诊所

//营业状态	S2	N1	Y	0正常1关闭2暂停营业


//LX	类型	S2	N2	Y	01损伤性废物（锐器盒）02感染性废物03病理性废物04药物性废物05化学性废物

//人员类型	S2	N1	N	1交接员2收集员3运输者4管理员

//在岗状态	S2	N1	Y	1在岗2离岗

//是否审核	S2	N1	Y	0未审核1审核通过2审核未通过

//部门级别	S1	N1	Y	1省级2市级3县级

//是否最新版本	S2	N1	Y	1是0否

//更新类型	S2	N1	Y	1非强制更新2强制更新

//结算情况	S2	N1	Y	0未清算1已清算2拒接3拒接已处理


/**
 * @author chen.shuodong
 *废物类型
 */
public enum FWLX {

    SSXFW("01","损伤性废物（锐器盒）"),
	
	GRXFW("02","感染性废物"),
	
	BLXFW("03","病理性废物"),
	
	YWXFW("04","药物性废物"),
	
	HXXFW("05","化学性废物");
	
    // 成员变量
    private String code;
    private String value;

    FWLX(String code, String value) {
        this.code = code;
        this.value = value;
    }

    /**
     * 根据业务码获得业务类型
     *
     * @param code 业务码
     * @return 业务类型
     */
    public static FWLX getEnumByCode(String code) {
    	FWLX[] values = FWLX.values();
        for (FWLX operate : values) {
            if (StringUtils.equals(operate.getCode(), code)) {
                return operate;
            }
        }
        return null;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
