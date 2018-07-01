package com.cd.zjyf.base.exception;

import com.cd.zjyf.pojo.Response;
import com.cd.zjyf.utils.CodeMessage;

/**
 * @author chen.shuodong
 *消息绑定
 */
@Deprecated
public interface ResponseBind  {

	/**
	 * 
	 */
    //绑定消息的方法

	Response getResponse();
	 
	
	

}
