package com.cd.zjyf.utils;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Base64Convert {
	private static Logger log = LoggerFactory.getLogger(Base64Convert.class);

	public static void main(String[] args) throws IOException {
	      InputStream in = new FileInputStream("C:\\Users\\chen.shuodong\\Desktop\\xx.jpg");
	      String ioToBase64 = ioToBase64(in);
	      System.out.println(ioToBase64);
	}
	

    /**
     * 把输入流转成base64编码
     * @param in
     * @return
     * @throws IOException
     */
    public static String ioToBase64(InputStream in) throws IOException  {
        String strBase64 = null;
        try {
            // in.available()返回文件的字节长度
            byte[] bytes = new byte[in.available()];
            // 将文件中的内容读入到数组中
            in.read(bytes);
            strBase64 = new BASE64Encoder().encode(bytes);      //将字节流数组转换为字符串
            in.close();
        } catch (FileNotFoundException fe) {
        	log.error("FileNotFoundException",fe);
        	throw fe;
        } catch (IOException ioe) {
        	log.error("IOException",ioe);
        	throw ioe;
        }
        return strBase64;
    }
    
    
   /* public static OutputStream base64ToIo(String strBase64) throws IOException {
        OutputStream outputStream = new OutputStream();
        try {
            // 解码，然后将字节转换为文件
            byte[] bytes = new BASE64Decoder().decodeBuffer(strBase64);   //将字符串转换为byte数组
            ByteArrayInputStream in = new ByteArrayInputStream(bytes);
            byte[] buffer = new byte[1024];
            int bytesum = 0;
            int byteread = 0;
            while ((byteread = in.read(buffer)) != -1) {
                bytesum += byteread;
                out.write(buffer, 0, byteread); //文件写操作
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
		return null;
    }*/

    public void base64ToIo_1(String strBase64) throws IOException {
        String string = strBase64;
        String fileName = "d:/gril2.gif"; //生成的新文件
        try {
            // 解码，然后将字节转换为文件
            byte[] bytes = new BASE64Decoder().decodeBuffer(string);   //将字符串转换为byte数组
            ByteArrayInputStream in = new ByteArrayInputStream(bytes);
            byte[] buffer = new byte[1024];
            FileOutputStream out = new FileOutputStream(fileName);
            int bytesum = 0;
            int byteread = 0;
            while ((byteread = in.read(buffer)) != -1) {
                bytesum += byteread;
                out.write(buffer, 0, byteread); //文件写操作
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}