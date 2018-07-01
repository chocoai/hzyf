package com.cd.zjyf.base.controller;

import com.cd.zjyf.base.exception.BaseException;

/**
 * @author chen.shuodong
 *service处理
 */
public interface ServiceHandler  {

	
	  Object serviceQueryOperate(Object o );

	  Object serviceQueryOperateHasExcpetoin(Object o ) throws BaseException;

	  Object serviceSaveOrUpdateOperate(Object o ) throws BaseException;
	
	  
}
