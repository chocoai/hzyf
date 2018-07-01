package com.cd.zjyf.management.util;

import java.net.URLDecoder;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.alibaba.fastjson.JSON;
/**
 * Created by ma.xiaofeng on 2018/4/17.
 */
public class RequestValidationUtils {

    /**
     * 从请求头（header）中拿到用户类型("rylx")，
     */
    @SuppressWarnings("unchecked")
    public static Map<String, Object> appUserInfo() throws Exception {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		String userInfo = request.getHeader("userInfo");
		userInfo=URLDecoder.decode(userInfo,"UTF-8");
		if (StringUtils.isEmpty(userInfo)) {
			throw new Exception("无法获取该用户信息");
		}
		Map<String, Object> userInfoMap = (Map<String, Object>) JSON.parse(userInfo);
		return userInfoMap;
	}

    /**
     * 从用户userinfo的map中拿到用户类型，然后判断是否在允许的 类型数组当中
     */
    public static boolean userValid(Map<String, Object> userMap, String[] arr) {
        String rylx1 = (String)userMap.get("rylx");
        List<String> list = Arrays.asList(arr);
        if (list.contains(rylx1)) {
            return true;
        }
        return false;
    }
}
