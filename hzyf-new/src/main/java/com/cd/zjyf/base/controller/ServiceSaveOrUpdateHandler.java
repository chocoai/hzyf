package com.cd.zjyf.base.controller;

import com.cd.zjyf.base.exception.BaseException;

/**
 * @author chen.shuodong
 *查询处理
 */
@Deprecated
public interface ServiceSaveOrUpdateHandler {

	Object serviceSaveOrUpdateOperate(Object o ) throws BaseException;
	
}
