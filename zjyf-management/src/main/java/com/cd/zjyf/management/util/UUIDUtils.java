package com.cd.zjyf.management.util;

public class UUIDUtils {
	/**
	 * 系统生32位唯一编号
	 */
	public static String generateID(){
		String uuid=java.util.UUID.randomUUID().toString();
		return uuid.replace("-", "");
	}
}
