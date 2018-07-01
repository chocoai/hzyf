package com.cd.zjyf.base.controller;

import com.cd.zjyf.base.exception.BaseException;

/**
 * @author chen.shuodong
 *service 处理
 */
@Deprecated
public abstract class ServicesHandler  {

 public	abstract Object serviceQueryOperate(Object o );

 public abstract Object serviceSaveOrUpdateOperate(Object o ) throws BaseException;
	
}
