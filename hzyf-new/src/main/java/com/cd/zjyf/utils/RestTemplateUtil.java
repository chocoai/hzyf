package com.cd.zjyf.utils;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by chen.shuodong on 2018/6/28.
 */
@Component
public class RestTemplateUtil {

    private static String url="https://dev.zjcdjk.cn/ryzp/hu002.jpg";



    private static void get() throws IOException {
        //final String APPLICATION_PDF = "application/pdf";
        //  final String APPLICATION_PDF = "application/x-jpg";


        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        InputStream inputStream = null;
        OutputStream outputStream = null;
        try {
            List<MediaType> list = new ArrayList<>();
            list.add(MediaType.APPLICATION_OCTET_STREAM);
            headers.setAccept(list);

            ResponseEntity<byte[]> response = restTemplate.exchange(
                    url,
                    HttpMethod.GET,
                    new HttpEntity<byte[]>(headers),
                    byte[].class);

            byte[] result = response.getBody();

            inputStream = new ByteArrayInputStream(result);

            File file = new File("C:\\Users\\chen.shuodong\\Desktop\\123.jpg");
            if (!file.exists())
            {
                file.createNewFile();
            }

            outputStream = new FileOutputStream(file);
            int len = 0;
            byte[] buf = new byte[1024];
            while ((len = inputStream.read(buf, 0, 1024)) != -1) {
                outputStream.write(buf, 0, len);
            }
            outputStream.flush();

        }finally {
            if(inputStream != null){
                inputStream.close();
            }
            if(outputStream != null){
                outputStream.close();
            }
        }
    }

    public static byte[] getByte(String url) throws IOException {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        List list = new ArrayList<>();
        list.add(MediaType.APPLICATION_OCTET_STREAM);
        headers.setAccept(list);
        ResponseEntity<byte[]> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                new HttpEntity<byte[]>(headers),
                byte[].class);
        return response.getBody();
    }




    @Test
    public void test() throws IOException {
        String url="https://dev.zjcdjk.cn/ryzp/bd0af054791211e8abd400155d160208/caijiyuan.svg";
        String encode = Base64Util.encode(getByte(url));
        System.out.println("encode||"+encode);
    }

    @Test
    public void test2() throws IOException {
        get();

    }





}

