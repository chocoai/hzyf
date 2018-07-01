package com.cd.zjyf.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import com.github.pagehelper.Page;

@Component
@ConfigurationProperties
@PropertySource(value = "classpath:applicationConfig.properties", encoding = "UTF-8")
public class ApplicationConfig {


	public static String NGINX_SERVER_ADDR;

	public static String getNginxServerAddr() {
		return NGINX_SERVER_ADDR;
	}

	@Value("${FTP.NGINX_SERVER_ADDR}")
	public static void setNginxServerAddr(String nginxServerAddr) {
		NGINX_SERVER_ADDR = nginxServerAddr;
	}

	// #ftp用户照片存储路径
	private String USER_PHOTO_PATH;

	// #ftp用户二维码存储路径
	private String USER_QRCODE_PATH;


	
	public static final int pageNum = 1;
	public static final int pageSize = 10;

	//长期未收集的天数
	public static  final String  LONG_NOCOLLECT_DAYS="LONG_NOCOLLECT_DAYS";
		
	
	/**
	 * @return the uSER_PHOTO_PATH
	 */
	public String getUSER_PHOTO_PATH() {
		return USER_PHOTO_PATH;
	}

	/**
	 * @param uSER_PHOTO_PATH
	 *            the uSER_PHOTO_PATH to set
	 */
	public void setUSER_PHOTO_PATH(String uSER_PHOTO_PATH) {
		USER_PHOTO_PATH = uSER_PHOTO_PATH;
	}

	/**
	 * @return the uSER_QRCODE_PATH
	 */
	public String getUSER_QRCODE_PATH() {
		return USER_QRCODE_PATH;
	}

	/**
	 * @param uSER_QRCODE_PATH
	 *            the uSER_QRCODE_PATH to set
	 */
	public void setUSER_QRCODE_PATH(String uSER_QRCODE_PATH) {
		USER_QRCODE_PATH = uSER_QRCODE_PATH;
	}


	// 项目ip和端口配置，用于动态配置二维码路径（是不是还有一个跟新二维码的需求）
	// workBriefName=workBrief.doc
	// WorkBriefTemplateName=workbrief.ftl
	// WordBriefBasePath=zzws_mental/workbrief/

}
