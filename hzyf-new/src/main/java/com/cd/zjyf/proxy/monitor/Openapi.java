package com.cd.zjyf.proxy.monitor;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.hikvision.cms.api.common.util.Digests;
import com.hikvision.cms.api.common.util.HttpClientSSLUtils;
import org.junit.Test;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toList;

/**
 * openapi 测试DEMO
 * 客户开发的时候可以参考此代码编写自己的应用
 * 也可以使用demo中的jar包，不过jar包使用务必使用全套，
 * 万不可只取其中一部分，避免依赖破坏
 * @author shengyiling
 *
 */
@Component
public class Openapi {
	
	/**
	 * APPKEY需要到部署的平台服务器上生成。
	 * <p>
	 * 调用Openpai的操作码，需要去平台上生成，详见《海康威视iVMS-8700平台SDKV2.*.* HTTP-OpenAPI使用说明书.chm》中[获取AppKey和Secret]章节说明
	 * </p>
	 * <p>
	 * 《海康威视iVMS-8700平台SDKV2.*.* HTTP-OpenAPI使用说明书.chm》 该文档请找技术支持或者交付的同事提供
	 * </p>
	 */
	private static final String APPKEY = "8ad41157";
	
	/**
	 * SECRET需要到部署的平台服务器上生成。
	 * <p>
	 * 调用Openpai的操作码，需要去平台上生成，详见《海康威视iVMS-8700平台SDKV2.*.* HTTP-OpenAPI使用说明书.chm》中[获取AppKey和Secret]章节说明
	 * </p>
	 * <p>
	 * 《海康威视iVMS-8700平台SDKV2.*.* HTTP-OpenAPI使用说明书.chm》 该文档请找技术支持或者交付的同事提供
	 * </p>
	 */
	private static final String SECRET = "663b0337d4f741d7a8a71f7c6a6ea393";
	
	
	/**
	 * http请求地址
	 * <p>openapi的地址,默认情况下openapi的IP端口与基础应用的IP端口是一致的</p>
	 * <p>请将地址配置正确.</p>
	 * <p>默认情况下是127.0.0.1:80 ，如果地址不通请根据实际情况修改IP端口</p>
 	 */
	private static final String OPENAPI_IP_PORT_HTTP = "http://183.246.205.199:82";
	
	/**
	 * https请求地址
	 * <p>openapi的地址,默认情况下openapi的IP端口与基础应用的IP端口是一致的</p>
	 * <p>请将地址配置正确.</p>
	 * <p>默认情况下是127.0.0.1:443 ，如果地址不通请根据实际情况修改IP端口</p>
 	 */
	private static final String OPENAPI_IP_PORT_HTTPS = "https://127.0.0.1:443";
	
	/**
	 * 获取默认用户UUID的接口地址，此地址可以从《海康威视iVMS-8700平台SDKV2.*.* HTTP-OpenAPI使用说明书.chm》中具体的接口说明上获取
	 */
	private static final String ITF_ADDRESS_GET_DEFAULT_USER_UUID = "/openapi/service/base/user/getDefaultUserUuid";
	
	/**
	 * 分页获取监控点信息的接口地址，此地址可以从《海康威视iVMS-8700平台SDKV2.*.* HTTP-OpenAPI使用说明书.chm》中具体的接口说明上获取
	 */
	private static final String ITF_ADDRESS_GET_CAMERAS = "/openapi/service/vss/res/getCameras";

	//根据中心UUID分页获取下级区域 测试
	private static final String ITF_ADDRESS_GETREGIONSBYUNITUUID= "/openapi/service/base/org/getRegionsByUnitUuid";



	/**
	 * <p>操作用户UUID，即用户UUID，首次使用操作用户UUID可以通过接口 [获取默认用户UUID]来获取</p>
	 * <p>也可以通过接口[分页获取用户]来获取</p>
	 */
	private static final String OP_USER_UUID = "cc78be40ec8611e78168af26905e6f0f";





	/**
	 * 测试方法
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {

		/***http方式调用***/
		System.out.println(testGetDefaultUserUUID());
		System.out.println(testGetCameras());
		
		/***https方式调用***/
		System.out.println(testGetDefaultUserUUID_Https());
		System.out.println(testGetCameras_Https());
	}

	@Test
	public void testGetDefaultUserUUID1() throws Exception {
		System.out.println(testGetDefaultUserUUID());

	}

	@Test
	public void testGetRegionsByUnitUuid1() throws Exception {
		String x = testGetRegionsByUnitUuid();
		System.out.println(x);

		JSONObject jsonObject = JSONObject.parseObject(x);
		JSONObject data = (JSONObject) jsonObject.get("data");
		JSONArray list = (JSONArray)data.get("list");
		int i=0;
		for(Object o:list){
			JSONObject jo= (JSONObject) o;
			System.out.println(jo);
			//过滤父节点，例如XX县
			if(((Integer)jo.get("isParent")).intValue()==1) continue;
			//System.out.println(jo.get("name")+"\t"+jo.get("regionUuid"));
			//System.out.println("'"+jo.get("name")+"',");
			i++;
		}
		System.out.println(i);

	}


	@Test
	public void testGetRegionsByUnitUuid2() throws Exception {
		String x = testGetRegionsByUnitUuid();

		JSONObject jsonObject = JSONObject.parseObject(x);
		JSONObject data =  jsonObject.getJSONObject("data");
		//JSONArray list = data.getJSONArray("list");
		List<JSONObject> list = (List<JSONObject>) data.get("list");
		//Collection<Object> isParent = list.stream().filter(j->(((JSONObject) j).get("isParent")).toString().equals("1")).collect(toList());

		//List<Object> isParent = list.stream().filter(j -> (((JSONObject) j).get("parentNodeType")).toString().equals("1")).collect(toList());
		List<JSONObject> parentNodeType = list.stream().filter(j -> j.getInteger("parentNodeType")==1).collect(toList());

		//List<Object> huZ = list.stream().filter(j -> (((JSONObject) j).get("parentUuid")).toString().equals("9dc4fe5a0c714a3398d3ef8655bceabb")).collect(toList());

		for(Object o:list){
			JSONObject jo= (JSONObject) o;
			System.out.println(jo);
			//过滤父节点，例如XX县
			if(((Integer)jo.get("isParent")).intValue()==1) continue;
			//System.out.println(jo.get("name")+"\t"+jo.get("regionUuid"));
			//System.out.println("'"+jo.get("name")+"',");
		}

	}


	@Test
	public void testGetRegionsByUnitUuid3() throws Exception {
		System.out.println();
		String x = testGetRegionsByUnitUuid();

		JSONObject jsonObject = JSONObject.parseObject(x);
		JSONObject data =  jsonObject.getJSONObject("data");
		//JSONArray list = data.getJSONArray("list");
		List<JSONObject> all = (List<JSONObject>) data.get("list");

		List<JSONObject> parentNodeType = all.stream().filter(j -> j.getInteger("parentNodeType")==1).collect(toList());

		parentNodeType.stream().forEach(p->p.put("zcd",all.stream().filter(a->a.getString("parentUuid").equals(p.getString("regionUuid"))).collect(toList())));
		System.out.println("我的输出");
		System.out.println(parentNodeType);

		//List<Object> huZ = list.stream().filter(j -> (((JSONObject) j).get("parentUuid")).toString().equals("9dc4fe5a0c714a3398d3ef8655bceabb")).collect(toList());



	}







	/**
	 * HTTP方式
	 * 根据中心UUID分页获取下级区域 测试
	 * @return
	 * @throws Exception
	 */
	private static String testGetRegionsByUnitUuid() throws Exception{
		String url = OPENAPI_IP_PORT_HTTP + ITF_ADDRESS_GETREGIONSBYUNITUUID;
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("appkey", APPKEY);//设置APPKEY
		map.put("time", System.currentTimeMillis());//设置时间参数
		map.put("pageNo", 1);//设置分页参数
		map.put("pageSize", 1000);//设置分页参数
		map.put("opUserUuid", OP_USER_UUID);//设置操作用户UUID
		map.put("parentUuid","1048576");//上级中心UUID
		map.put("allChildren",1);//获取类型

		String params =  JSON.toJSONString(map);
		System.out.println(" ====== testGetDefaultUserUUID 请求参数：【" + params + "】");
		String data = HttpClientSSLUtils.doPost(url + "?token=" + Digests.buildToken(url + "?" + params, null, SECRET), params);
		System.out.println(" ====== testGetDefaultUserUUID 请求返回结果：【{" + data + "}】");

		return data;
	}


    public static String getRegionsByUnitUuid() {
        String url = OPENAPI_IP_PORT_HTTP + ITF_ADDRESS_GETREGIONSBYUNITUUID;
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("appkey", APPKEY);//设置APPKEY
        map.put("time", System.currentTimeMillis());//设置时间参数
        map.put("pageNo", 1);//设置分页参数
        map.put("pageSize", 1000);//设置分页参数
        map.put("opUserUuid", OP_USER_UUID);//设置操作用户UUID
        map.put("parentUuid","1048576");//上级中心UUID
        map.put("allChildren",1);//获取类型
        String params =  JSON.toJSONString(map);
        System.out.println(" ====== getRegionsByUnitUuid 请求参数：【" + params + "】");
        String data = null;
        try {
            data = HttpClientSSLUtils.doPost(url + "?token=" + Digests.buildToken(url + "?" + params, null, SECRET), params);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(" ====== getRegionsByUnitUuid 请求返回结果：【{" + data + "}】");
        return data;
    }



	@Test
	public void getDefaultUnit1() throws Exception {
		System.out.println(getDefaultUnit());

	}

	/**
	 * HTTP方式
	 * 根据中心UUID分页获取下级区域 测试
	 * @return
	 * @throws Exception
	 */
	private static String getDefaultUnit() throws Exception{
		String url = OPENAPI_IP_PORT_HTTP + "/openapi/service/base/org/getDefaultUnit";
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("appkey", APPKEY);//设置APPKEY
		map.put("time", System.currentTimeMillis());//设置时间参数

		map.put("opUserUuid", OP_USER_UUID);//设置操作用户UUID
		map.put("subSystemCode","2097152");


		String params =  JSON.toJSONString(map);
		System.out.println(" ====== testGetDefaultUserUUID 请求参数：【" + params + "】");
		String data = HttpClientSSLUtils.doPost(url + "?token=" + Digests.buildToken(url + "?" + params, null, SECRET), params);
		System.out.println(" ====== testGetDefaultUserUUID 请求返回结果：【{" + data + "}】");

		return data;
	}





	/**
	 * HTTP方式
	 * 获取默认用户UUID 测试
	 * @return
	 * @throws Exception
	 */
	private static String testGetDefaultUserUUID() throws Exception{
		String url = OPENAPI_IP_PORT_HTTP + ITF_ADDRESS_GET_DEFAULT_USER_UUID;
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("appkey", APPKEY);//设置APPKEY
		map.put("time", System.currentTimeMillis());//设置时间参数
		String params =  JSON.toJSONString(map);
		System.out.println(" ====== testGetDefaultUserUUID 请求参数：【" + params + "】");
		String data = HttpClientSSLUtils.doPost(url + "?token=" + Digests.buildToken(url + "?" + params, null, SECRET), params);
		System.out.println(" ====== testGetDefaultUserUUID 请求返回结果：【{" + data + "}】");
		
		return data;
	}
	
	/** 
	 * HTTP方式
	 * 分页获取监控点信息 测试
	 * @return
	 * @throws Exception
	 */
	private static String testGetCameras() throws Exception{
		 String url = OPENAPI_IP_PORT_HTTP + ITF_ADDRESS_GET_CAMERAS;
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("appkey", APPKEY);//设置APPKEY
        map.put("time", System.currentTimeMillis());//设置时间参数
        map.put("pageNo", 1);//设置分页参数
        map.put("pageSize", 5);//设置分页参数
        map.put("opUserUuid", OP_USER_UUID);//设置操作用户UUID
        String params = JSON.toJSONString(map);
        System.out.println(" ====== getCameras请求参数：【" + params + "】");
        String data = HttpClientSSLUtils.doPost(url + "?token=" + Digests.buildToken(url + "?" + params, null, SECRET), params);
        System.out.println(" ====== getCameras请求返回结果：【{" + data + "}】");
        
        return data;
	}
	
	/**
	 * HTTPS方式
	 * 获取默认用户UUID 测试
	 * @return
	 * @throws Exception
	 */
	private static String testGetDefaultUserUUID_Https() throws Exception{
		String url = OPENAPI_IP_PORT_HTTPS + ITF_ADDRESS_GET_DEFAULT_USER_UUID;
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("appkey", APPKEY);//设置APPKEY
		map.put("time", System.currentTimeMillis());//设置时间参数
		String params =  JSON.toJSONString(map);
		System.out.println("============" + params + "============");
		String data = HttpClientSSLUtils.doPost(url + "?token=" + Digests.buildToken(url + "?" + params, null, SECRET), params);
		System.out.println("============" + data + "============");
		
		return data;
	}
	
	/**
	 * HTTPS方式
	 * 分页获取监控点信息 测试
	 * @return
	 * @throws Exception
	 */
	private static String testGetCameras_Https() throws Exception{
		 String url = OPENAPI_IP_PORT_HTTPS + ITF_ADDRESS_GET_CAMERAS;
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("appkey", APPKEY);//设置APPKEY
        map.put("time", System.currentTimeMillis());//设置时间参数
        map.put("pageNo", 1);//设置分页参数
        map.put("pageSize", 5);//设置分页参数
        map.put("opUserUuid", OP_USER_UUID);//设置操作用户UUID
        String params = JSON.toJSONString(map);
        System.out.println(" ====== getCameras请求参数：【" + params + "】");
        String data = HttpClientSSLUtils.doPost(url + "?token=" + Digests.buildToken(url + "?" + params, null, SECRET), params);
        System.out.println(" ====== getCameras请求返回结果：【{" + data + "}】");
        
        return data;
	}
	
}
