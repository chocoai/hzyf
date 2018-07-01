package com.cd.zjyf;

import com.alibaba.fastjson.JSONObject;
import com.cd.zjyf.bean.TblYlwsDlxx;
import com.cd.zjyf.exception.ValidateException;
import org.springframework.web.client.RestTemplate;

import java.io.*;

/**
 * 获取经纬度脚本
 * Created by chen.shuodong on 2018/5/7.
 */

public class JwdScript {

    public static void main(String[] args) throws IOException {
        InputStream resourceAsStream = JwdScript.class.getResourceAsStream("/JwdScript.txt");
           /* 读入TXT文件 */
      //  InputStreamReader reader = new InputStreamReader(new FileInputStream(filename)); // 建立一个输入流对象reader
        InputStreamReader reader = new InputStreamReader(resourceAsStream); // 建立一个输入流对象reader


        BufferedReader br = new BufferedReader(reader); // 建立一个对象，它把文件内容转成计算机能读懂的语言
        String sqlLine="";
        String line = br.readLine();//过滤掉第一行
        while ((line = br.readLine()) != null) {
           // System.out.println(line);
            //if(line.split("\\s+").length!=2) continue;
            String fkid=line.split("\\s+")[1];
            String addr=line.split("\\s+")[2];
           // System.out.println("fkid:"+fkid+"----addr:"+addr);
            TblYlwsDlxx dlxx = null;
            try {
                dlxx = getDLXX(addr);
            } catch (ValidateException e) {
                e.printStackTrace();
                continue;
            }
            String sql="insert into TBL_YLWS_DLXX (ID, FKID, LONGITUDE, LATITUDE) values (sys_guid(), '{0}', '{1}', '{2}');";
            sql = sql.replace("{0}",fkid).replace("{1}",dlxx.getLongitude()).replace("{2}",dlxx.getLatitude());
           // System.out.println(sql);
            sqlLine+=sql+"\n";
        }
        System.out.println("===========生成的sql语句==========");
        System.out.println(sqlLine);
        System.out.println("===========生成的sql语句==========");
    }


    public static final String url="http://api.map.baidu.com/geocoder/v2/";
    public static final String ak="D60KcUO245tG5eUXTFqoPKUec0t7kGmU";
    /**
     * 通过单位具体地址获取单位坐标
     * @param dwdz
     */
    private static TblYlwsDlxx getDLXX(String dwdz) throws ValidateException {
        RestTemplate restTemplate = new RestTemplate();
        String forObject = restTemplate.getForObject(url+"?output=json&&address="+dwdz+"号&&ak="+ak, String.class);
        //   log.debug("通过单位具体地址获取单位坐标json:"+forObject);
        JSONObject jsonObject = JSONObject.parseObject(forObject);
        if(!jsonObject.get("status").equals(0)){
            throw  new ValidateException("单位地址不准确，无法获取经纬度！");
        }
        JSONObject result = (JSONObject) jsonObject.get("result");
        JSONObject location = (JSONObject) result.get("location");
        TblYlwsDlxx tblYlwsDlxx = new TblYlwsDlxx();
        String lng = String.valueOf(location.get("lng"));
        String lat = String.valueOf( location.get("lat"));
        tblYlwsDlxx.setLongitude(lng);
        tblYlwsDlxx.setLatitude(lat);
        return tblYlwsDlxx;
    }

}
