package com.cd.zjyf;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cd.zjyf.bean.TblYlwsDlxx;
import com.cd.zjyf.bean.YlfwJsdj;
import com.cd.zjyf.exception.ValidateException;
import com.cd.zjyf.proxy.carlocation.CarlocationClient;
import com.cd.zjyf.utils.ReflectUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalQuery;
import java.util.Date;

public class ToolsTest {

	@Test
	public void testFTPutil() throws IllegalArgumentException, IllegalAccessException, InstantiationException {
		YlfwJsdj obj = new YlfwJsdj();
		obj.setCsdid("1");
		obj.setJsrid("12");
		obj.setTgzid("1");
		obj.setZcdid("11");
		obj.setEndtime(new Date());
		obj.setJstime(new Date());
		obj.setLx("07");
		obj.setZl(new BigDecimal(1));
		obj.setSl(new BigDecimal(1));
		obj.setJsqk("9");

		Class userCla = obj.getClass();

		JSONObject jsonObject = new JSONObject();
		Field[] fs = userCla.getDeclaredFields();
		for(Field f:fs) {
			Class<?> type = f.getType();
			//if(type.newInstance() instanceof Date) continue;
		//	if(type.newInstance() instanceof java.math.BigDecimal) continue;
			//System.out.println(getValue_1(f.getName(),obj));
			//System.out.println(	ReflectUtils.getFieldValue(f.getName(),obj));
			jsonObject.put(f.getName(), ReflectUtils.getFieldValue(f.getName(),obj));
		}
		System.out.println(jsonObject.toJSONString());
		
	}


	@Test
	public void test2(){
		LocalDate date = LocalDate.parse("2013-01-12");
		date=LocalDate.now();
		TemporalQuery<Integer> IntegerOfYearQuery = new IntegerOfYearQuery();
		System.out.println(date.query(IntegerOfYearQuery));
	}

	static class IntegerOfYearQuery implements TemporalQuery<Integer> {
		@Override
		public Integer queryFrom(TemporalAccessor temporal) {
			LocalDate now = LocalDate.from(temporal);

			if (now.isBefore(now.with(Month.APRIL).withDayOfMonth(1))) {
				return 1;
			} else if (now.isBefore(now.with(Month.JULY).withDayOfMonth(1))) {
				return 2;
			} else if (now.isBefore(now.with(Month.NOVEMBER).withDayOfMonth(1))) {
				return 3;
			} else {
				return 4;
			}
		}

		@Test
		public void testAboutJSON() throws IllegalArgumentException, IllegalAccessException, InstantiationException {

			JSONObject jsonObject = new JSONObject();
			jsonObject.put("a", new Date());
			jsonObject.put("b", 123.33);
			jsonObject.put("c", "sdaf");
			System.out.println(jsonObject.toJSONString());

		}


		/**
		 * @param fieldName 获取属性值的属性名
		 * @param data      获取对象
		 * @return
		 * @category 利用反射机制通过属性名获取MongodbData对象的属性值
		 */
		public static Object getValue_1(String fieldName, Object data) {
			Object result = null;
			fieldName = fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);// 拼接获取属性get方法的名字
			Method m;
			try {
				m = data.getClass().getMethod("get" + fieldName);// 获取get方法
				result = m.invoke(data);// 获取属性值
			} catch (SecurityException e) {
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}

			return result;
		}


		/**
		 * @param fieldName 获取属性值的属性名
		 * @param data      获取对象
		 * @return
		 * @category 利用反射机制通过属性名获取MongodbData对象的属性值
		 */
		public static String getValue(String fieldName, Object data) {
			String result = null;
			fieldName = fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);// 拼接获取属性get方法的名字
			Method m;
			try {
				m = data.getClass().getMethod("get" + fieldName);// 获取get方法
				result = (String) m.invoke(data);// 获取属性值
			} catch (SecurityException e) {
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}

			return result;
		}

		@Test
		public void testBase64() {

		}

		@Test
		public void testQRCode() {

		}

		@Test
		public void testRegex() {
			String url = "http://api.map.baidu.com/geocoder/v2/?address=0号&&time=21231211&&dasdf=2";
			url = url.replaceAll("&+time=\\d+", "");
			System.out.println(url);
//		String url="12312";
			String regex = "\\d+";
			boolean matches = url.matches(regex);
			System.out.println(matches);

		}

		@Test
		public void testRegex1() {
			String url = "330500000";
			url = url.replaceAll("0+$", "");
			System.out.println(url);
			String code = "330324000";
			code = code.substring(0, 4);
			String target = "group by code||00000";//可以用oracle的右补齐函数

			String ck = "select RPAD(REGEXP_REPLACE('330500000','0+$'),9,0) from dual";//参考
		}

		@Test
		public void test() {
			RestTemplate restTemplate = new RestTemplate();
			String forObject = restTemplate.getForObject("http://api.map.baidu.com/geocoder/v2/?address=0号&&ak=D60KcUO245tG5eUXTFqoPKUec0t7kGmU&&output=json", String.class);
			System.out.println("打印：" + forObject);
			JSONObject jsonObject = JSONObject.parseObject(forObject);
			System.out.println(jsonObject.get("status"));
			JSONObject result = (JSONObject) jsonObject.get("result");
			JSONObject location = (JSONObject) result.get("location");

			System.out.println(location.get("lng"));
			System.out.println();
			System.out.println();
		}


		@Test
		public void test1() {
			String url = "http://api.map.baidu.com/geoconv/v1/?coords=114.21892734521,29.575429778924;114.21892734521,29.575429778924&from=1&to=5&ak=D60KcUO245tG5eUXTFqoPKUec0t7kGmU";
			RestTemplate restTemplate = new RestTemplate();

			//String forObject = restTemplate.getForObject(url+"?output=json&&address="+dwdz+"号&&ak="+ak, String.class);

			String forObject = restTemplate.getForObject(url, String.class);

			//log.debug("通过单位具体地址获取单位坐标json:"+forObject);
			JSONObject jsonObject = JSONObject.parseObject(forObject);
			if (!jsonObject.get("status").equals(0)) {
				//throw  new ValidateException("单位地址不准确，无法获取经纬度！");
				return;
			}

			JSONArray result1 = jsonObject.getJSONArray("result");
			JSONObject result = result1.getJSONObject(0);
			String lng = result.getString("x");
			String lat = result.getString("y");

			System.out.println(lng + "," + lat);

		}


		@Test
		public void testZB() {
			int a = 43229237;
			int d, f;
			float m;//度分秒
			for (int i = 0; ; i++) {
				if (3600 * 100 * i > a) {
					d = i - 1;
					a = a - 3600 * 100 * (i - 1);
					break;
				}
			}

			System.out.println(a);

			for (int i = 0; ; i++) {
				if (60 * 100 * i > a) {
					f = i - 1;
					a = a - 60 * 100 * (i - 1);
					break;
				}
			}

			System.out.println(a);


			m = a / 100f;

			System.out.println(d + "|" + f + "|" + m);


			float xs = (f + m / 60f) / 60f;

			System.out.println(xs);

			System.out.println(d + xs);
		}

		}
	}
