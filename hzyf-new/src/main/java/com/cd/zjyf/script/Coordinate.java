package com.cd.zjyf.script;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;

/**
 * 根据地理名获取物流坐标经纬度
 */
public class Coordinate {

    public static void main(String[] args) {


    }

    @Test
    public void test(){
        RestTemplate restTemplate = new RestTemplate();
        String forObject = restTemplate.getForObject("http://api.map.baidu.com/geocoder/v2/?address=0号&&ak=D60KcUO245tG5eUXTFqoPKUec0t7kGmU&&output=json", String.class);
        System.out.println("打印："+forObject);
        JSONObject jsonObject = JSONObject.parseObject(forObject);
        System.out.println(jsonObject.get("status"));
        JSONObject result = (JSONObject) jsonObject.get("result");
        JSONObject location = (JSONObject) result.get("location");

        System.out.println(location.get("lng"));
        System.out.println();
        System.out.println();
    }
}
