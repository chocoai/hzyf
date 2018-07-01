package com.cd.zjyf.utils;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.net.URLDecoder;
import java.security.Principal;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;

import com.cd.zjyf.mapper.CommonMapper;
import com.cd.zjyf.pojo.LoginUserInfo;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cd.zjyf.annotation.NumberIint;
import com.cd.zjyf.annotation.RealField;
import com.cd.zjyf.enums.ServiceRangeCode;
import com.cd.zjyf.exception.ValidateException;
import com.cd.zjyf.pojo.PageBean;
import com.github.pagehelper.Page;

@Component
public class CommonUtil {

	private static  CommonMapper cm;

     @Autowired
    public void setCommonMapper(CommonMapper cm){
		        CommonUtil.cm = cm;
	 }

	private static Logger log = LoggerFactory.getLogger(CommonUtil.class);

	/**
	 * 车辆定位的坐标转化
	 * @param zb
	 * @return
	 */
	public static String getLocation(String zb){
		int a=Integer.valueOf(zb);
		int d,f; float m;//度分秒
		for(int i=0;;i++){
			if(3600*100*i>a) {
				d=i-1;a=a-3600*100*(i-1);
				break;
			}
		}

		for(int i=0;;i++){
			if(60*100*i>a) {
				f=i-1;a=a-60*100*(i-1);
				break;
			}
		}

		m=a/100f;

		float xs= (f+m/60f)/60f;

		return String.valueOf(d+xs);
	}


	public static int getLevelByRegionCode(String regionCode) {
		return regionCode!=null?regionCode.split(",").length:0;
		//return regionCode.split(",").length;
	}


	//把市直辖的编码转化成市级的编码330000000, 330500000, 330500000->330000000, 330500000
	public static String translateXZQH(String xzqh){
		if(xzqh!=null&&xzqh.split(",").length>1){
			String[] split = xzqh.split(",");
			if(split[split.length-1].equals(split[split.length-2])){
				xzqh= xzqh.substring(0,xzqh.lastIndexOf(","));
			}
		}
		return xzqh;
	}

	/**
	 * 通过set去重, 不打乱原有list的顺序
	 *       list中相同的对象会被去重复
	 *
	 * @param List<T> list
	 * @return List<T>
	 * */
	public static <T>  List<T> distinctBySetOrder(List<T> list){
		Set<T> set = new  HashSet<T>();
		List<T> newList = new  ArrayList<T>();
		for (T t :list) {
			if(set.add(t)){
				newList.add(t);
			}
		}
		return newList;
	}

	/**
	 * 通过set去重, 顺序可能会乱
	 *       list中相同的对象会被去重复
	 *
	 * @param List<T> list
	 * @return List<T>
	 * */
	public static <T> List<T> distinctBySet(List<T> list){
		return new ArrayList<T>(new HashSet<T>(list));
	}
	public static Map<String, Object> getAppUserInfo() throws Exception {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		String userInfo = request.getHeader("userInfo");
		if(userInfo==null) return null;
		userInfo= URLDecoder.decode(userInfo,"UTF-8");
		if (StringUtils.isEmpty(userInfo)) {
			throw new Exception("无法获取该用户信息");
		}
		@SuppressWarnings("unchecked")
		Map<String, Object> userInfoMap = (Map<String, Object>) JSON.parse(userInfo);
		return userInfoMap;
	}

	//LocalDateTime转换为Date
	public static Date convertLDTToDate(LocalDateTime time) {
		return Date.from(time.atZone(ZoneId.systemDefault()).toInstant());
	}

	public static <T> List<T> getListRangValue(List<T> list) {
		list.stream().forEach(t -> getRangValue(t));
		return list;
	}

	/**
	 * 获取分页封装类，带总条数
	 * 
	 * @param list
	 * @param page
	 * @return
	 */
	public static <T> PageBean<T> getPageBean(List<T> list, Page<?> page) {
		// 创建查询结果封装对象
		PageBean<T> pageBean = new PageBean<>();
		// 封装查询条件
		pageBean.setItems(list);
		pageBean.setTotalNum(page.getTotal());
		log.info("分页总条数：{}", pageBean.getTotalNum());
		return pageBean;
	}

	/**
	 * 获取分页封装类，带总条数
	 * 
	 * @param list
	 * @return
	 */
	public static <T> PageBean<T> getPageBean(List<T> list) {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
				.getRequest();
		// 创建查询结果封装对象
		PageBean<T> pageBean = new PageBean<>();
		// 封装查询条件
		pageBean.setItems(list);
		Page<?> page = (Page<?>) request.getAttribute("pageObj");
		if(page!=null) {
			//-1代表没分页，从自定义分页取
			pageBean.setTotalNum(page.getTotal()!=-1?page.getTotal():cm.getTotal());
		}
		log.info("分页总条数：{}", pageBean.getTotalNum());
		return pageBean;
	}

	/**
	 * 获取user
	 *
	 * @param list
	 * @return
	 */
	public static LoginUserInfo getUserInfo() {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
				.getRequest();
		return (LoginUserInfo)request.getAttribute("loginUserInfo");
	}

/*
	public static Map<String, Object> getUserInfo(Principal principal) throws Exception {
		OAuth2Authentication auth2Authentication = (OAuth2Authentication) principal;
		String userJson = auth2Authentication.getName();
		if (StringUtils.isEmpty(userJson)) {
			throw new Exception("无法获取该用户信息");
		}
		@SuppressWarnings("unchecked")
		Map<String, Object> userInfoMap = (Map<String, Object>) JSON.parse(userJson);

		return userInfoMap;
	}
*/


	public static <T> String getRequestJsonParams(T t) {
		Class<? extends Object> userCla = t.getClass();
		JSONObject jsonObject = new JSONObject();
		Field[] fs = userCla.getDeclaredFields();
		for (Field f : fs) {
			Class<?> type = f.getType();
			jsonObject.put(f.getName(), ReflectUtils.getFieldValue(f.getName(), t));
		}
		return jsonObject.toJSONString();
	}

	/**
	 * 对象的中的部分字段值域转化
	 * 
	 * @param t
	 */
	public static <T> T getRangValue(T t) {
		if (t == null)
			return null;
		// 得到类对象
		Class userCla = t.getClass();
		t.getClass();

		try {
			/*
			 * 得到类中的所有属性集合
			 */
			Field[] fs = userCla.getDeclaredFields();
			for (int i = 0; i < fs.length; i++) {
				Field f = fs[i];
				f.setAccessible(true); // 设置些属性是可以访问的
				String fieldName = f.getName();
				String fieldValue = f.get(t) != null ? f.get(t).toString() : null;
				// 空值返回
				if (StringUtil.isBlank(fieldValue)) {
					// 如果有这个数字初始化注解，那么将转化数字
					NumberIint numberIint = f.getAnnotation(NumberIint.class);
					if (numberIint != null) {
						f.set(t, "0");
					}
					continue;
				}

				RealField realField = f.getAnnotation(RealField.class);
				if (realField != null) {
					fieldName = realField.reference();
				}

				// 通过枚举类的字段值域转化
				ServiceRangeCode enumByCode = ServiceRangeCode.getServiceCode(fieldName, fieldValue);

				if (enumByCode != null)
					f.set(t, enumByCode.getValue());

			}
		} catch (Exception e) {
			log.error(e.toString());
			e.printStackTrace();
		}
		return t;
	}



	public static String objectToJson(Object o) {
		return JSON.toJSONString(o);
	}

	public static String getUUID() {
		String uuid = UUID.randomUUID().toString();
		// 去掉“-”符号
		return uuid.replaceAll("-", "");
	}

	/**
	 * 主要解决分页返回到前端的数据，数据字典的转化。
	 * 
	 * @param list
	 */
	public static <T> void translate(List<T> list) {
		for (T obj : list) {
			Method method1;
			try {
				method1 = obj.getClass().getDeclaredMethod("translate");
				method1.invoke(obj);
			} catch (Exception e) {
				log.error(e.toString());
				e.printStackTrace();
			}
		}
	}

	/**
	 * 用于基本字段的校验
	 * 
	 * @param obj
	 * @param groups
	 * @throws ValidateException
	 */
	public static <T> void basicValidate(T obj, Class<?>... groups) throws ValidateException {
		StringBuilder errorMsg = new StringBuilder();
		Set<ConstraintViolation<T>> validateSet = Validation.buildDefaultValidatorFactory().getValidator().validate(obj,
				groups);
		for (ConstraintViolation<T> constraintViolation : validateSet) {
			errorMsg.append(constraintViolation.getMessage());
		}
		if (errorMsg.length() > 0) {
			throw new ValidateException(errorMsg.toString());
		}
	}

	// TODO 输出流转输入流
	// TODO 输入流转输出流

	// BufferedImage转输入流
	public static InputStream bufferedImageToInputStream(BufferedImage bi) throws IOException {
		ByteArrayOutputStream bs = new ByteArrayOutputStream();
		ImageOutputStream imOut = ImageIO.createImageOutputStream(bs);
		ImageIO.write(bi, "png", imOut);
		InputStream is = new ByteArrayInputStream(bs.toByteArray());
		return is;
	}


	
	
	public static BigDecimal getDeafualtBigDecimal() {
		BigDecimal bigDecimal = new BigDecimal("0.00");
		bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP);
		return bigDecimal;
	}


}
