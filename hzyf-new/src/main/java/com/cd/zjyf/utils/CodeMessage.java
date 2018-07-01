package com.cd.zjyf.utils;
/**
 * 错误码及信息
 * @author li.mingyang
 *
 */
public enum CodeMessage {
	
	//成功状态
	STATUS_SUCCESS(0),
	//失败状态
	STATUS_FAILED(1),
	//操作成功
	OPERATION_SUCCESS("1000", "操作成功"),
	//添加失败
	INSERT_FAILED("1001", "添加失败"),
	//删除失败
	DELETE_FAILED("1002", "删除失败"),
	//修改失败
	UPDATE_FAILED("1003", "修改失败"),
	//查询失败
	SELECT_FAILED("1004", "查询失败"),

	UPDATE_CONDITION_IS_NULL_FAILED("1005", "修改条件的字段名或值不能为空"),
	
	TYPE_NOT_MATCH_FAILED("1006", "没有匹配的类型"),
	
	VALIDATE_FAILED("1007", "校验失败"),
   
	QRCODE_ERROR("1008","无效的二维码"),
	
	RYLX_ERROR("","人员类型不匹配"),
	
	OPERATION_FAILED("2000", "操作失败：系统异常"),
	
	
	SYSTEM_ERROR("2001", "操作失败：系统异常"),
	
	DOWNLOAD_ERROR("2002", "下载失败：系统异常");
	
    private String code;
    private String msg;
    private Integer status;
    
    private CodeMessage(Integer status) {
    	this.status = status;
    }
    
    private CodeMessage(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public Integer getStatus() {
        return status;
    }

}
