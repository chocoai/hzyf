package com.cd.zjyf.base.controller;

import com.cd.zjyf.base.exception.BaseException;

/**
 * @author chen.shuodong 这是一个适配器模式写法，是对ServiceHandler的一种适配
 */
public abstract class ServiceHandlerAdapter implements ServiceHandler {

	/**
	 * 对services中查询操作的匹配
	 */
	@Override
	public Object serviceQueryOperate(Object o) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 对services中查询操作的匹配
	 */
	public Object serviceQueryOperate() {
		// TODO Auto-generated method stub
		return null;
	}

	
	/**
	 * 对services中带异常查询操作的匹配
	 */
	@Override
	public Object serviceQueryOperateHasExcpetoin(Object o) throws BaseException {
		return null;
	}

	/**
	 * 对services中带异常查询操作的匹配
	 */
	public Object serviceQueryOperateHasExcpetoin() throws BaseException {
		return null;
	}
	
	/**
	 * 对services中新增或修改操作的匹配
	 */
	@Override
	public Object serviceSaveOrUpdateOperate(Object o) throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public Object serviceSaveOrUpdateOperate()  throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

}
