/*
package com.cd.zjyf.interceptor;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cd.zjyf.pojo.LoginUserInfo;
import com.cd.zjyf.utils.CommonUtil;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.NamedThreadLocal;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.cd.zjyf.pojo.Response;
import com.github.pagehelper.PageHelper;


*/
/**
 * 这个拦截器用于请求参数日志，token获取，分页等功能
 *
 * @author chen.shuodong
 *
 *//*

@Component
public class SystemInterceptor implements HandlerInterceptor {
    private static final Logger logger = LoggerFactory.getLogger(SystemInterceptor.class);

    private static final ThreadLocal<Long> startTimeThreadLocal =
            new NamedThreadLocal<Long>("ThreadLocal StartTime");

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        long beginTime = System.currentTimeMillis();//1、开始时间
        startTimeThreadLocal.set(beginTime);        //线程绑定变量（该数据只有当前请求的线程可见）
        logger.trace("开始计时: {}  URI: {}", new SimpleDateFormat("hh:mm:ss.SSS").format(beginTime), request.getRequestURI());

        String ip=getIpAddr(request);
        Map<String, Object> appUserInfo = CommonUtil.getAppUserInfo();
        String userid=appUserInfo!=null? (String) appUserInfo.get("id") :null;
        String username=appUserInfo!=null? (String) appUserInfo.get("username") :null;
        logger.info("==> 开始请求：ip地址：{}|当前用户id：{}|当前用户姓名:{}|请求的方法名：{}",ip,userid,username,handler);
		*/
/*	if(handler instanceof HandlerMethod){
		    HandlerMethod handlerMethod = (HandlerMethod)handler;
		    MethodParameter[] methodParameters = handlerMethod.getMethodParameters();
		    for(MethodParameter methodParameter : methodParameters){
		    	if(methodParameter.getParameterType() instanceof Object) {
		    		 param = CommonUtil.getRequestJsonParams(methodParameter);
		    	}
		    	param=methodParameter.getParameterName();
		    }
		}*//*

        Response sysResponse = new Response();//这个response可以放在request域中？
        //从平台传过来的token
        String token = request.getHeader("Authorization");
        if(token!=null) {
            //把token返回到相应头里
            response.setHeader("Authorization", token);
        }
        sysResponse.setAccess_token(token);//这里存放token名在系统返回对象
        request.setAttribute("sysResponse", sysResponse);
        String params=getJsonValue(request);//解析请求参数
        logger.info("前端请求的参数：{}",params);

//        if(!request.getMethod().equals("GET"))
//        System.out.println("post参数："+httpProcess1(request));

        return true;
    }




    public static String httpProcess1(HttpServletRequest request) throws IOException {
        StringBuffer sb = new StringBuffer() ;
        InputStream is = request.getInputStream();
        ByteArrayOutputStream baos = cloneInputStream(is);
        InputStream stream = new ByteArrayInputStream(baos.toByteArray());
        try ( BufferedReader br = new BufferedReader(new InputStreamReader(stream,"utf-8"))){
            String s ;
            while((s=br.readLine())!=null){
                sb.append(s) ;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(sb.toString().length()<=0){
            return null;
        }else {
            return sb.toString();
        }
    }

    private static ByteArrayOutputStream cloneInputStream(InputStream input) {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int len;
            while ((len = input.read(buffer)) > -1) {
                baos.write(buffer, 0, len);
            }
            baos.flush();
            return baos;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }


    */
/**
     * 获取访问者IP
     *
     * 在一般情况下使用Request.getRemoteAddr()即可，但是经过nginx等反向代理软件后，这个方法会失效。
     *
     * 本方法先从Header中获取X-Real-IP，如果不存在再从X-Forwarded-For获得第一个IP(用,分割)，
     * 如果还不存在则调用Request .getRemoteAddr()。
     *
     * @param request
     * @return
     *//*

    public static String getIpAddr(HttpServletRequest request) throws Exception{
        String ip = request.getHeader("X-Real-IP");
        if (!StringUtils.isBlank(ip) && !"unknown".equalsIgnoreCase(ip)) {
            return ip;
        }
        ip = request.getHeader("X-Forwarded-For");
        if (!StringUtils.isBlank(ip) && !"unknown".equalsIgnoreCase(ip)) {
// 多次反向代理后会有多个IP值，第一个为真实IP。
            int index = ip.indexOf(',');
            if (index != -1) {
                return ip.substring(0, index);
            } else {
                return ip;
            }
        } else {
            return request.getRemoteAddr();
        }
    }

    */
/**
     * 取得参数值
     * @author SHANSHAN
     *//*

    private  String getValue(HttpServletRequest request){
        String value = "";
        Enumeration<?> enu = request.getParameterNames();
        while(enu.hasMoreElements()){
            String paraName = (String)enu.nextElement();
            if (!"_dc".equals(paraName) && !"node".equals(paraName)){//_dc的参数不要
                String [] arr = request.getParameterValues(paraName);
                if (arr != null && arr.length > 1){
                    value += paraName+"="+ConvertObjectArrToStr(arr)+";";
                }else{
                    value += paraName+"="+request.getParameter(paraName)+";";
                }
            }
        }
        return value;
    }


    */
/**
     * 取得参数值
     * @author SHANSHAN
     *//*

    private  String getJsonValue(HttpServletRequest request){
        JSONObject jsonObject = new JSONObject();
        Enumeration<?> enu = request.getParameterNames();
        while(enu.hasMoreElements()){
            String paraName = (String)enu.nextElement();
            if (!"_dc".equals(paraName) && !"node".equals(paraName)){//_dc的参数不要
                String [] arr = request.getParameterValues(paraName);
                if (arr != null && arr.length > 1){
                    jsonObject.put(paraName, ConvertObjectArrToStr(arr));
                }else{
                    jsonObject.put(paraName, request.getParameter(paraName));
                }
            }
        }
        return jsonObject.toJSONString();
    }



    */
/**
     * 把对象列表,转化成逗号分隔的字符串
     * @author SHANSHAN
     *//*

    private static String ConvertObjectArrToStr(Object [] arr) {
        String result = "";
        if (arr != null && arr.length > 0) {
            for (int i = 0; i < arr.length; i++) {
                if (!"".equals(String.valueOf(arr[i]))) {
                    result += String.valueOf(arr[i]) + ",";
                }
            }
            if (!"".equals(result)) {
                result = result.substring(0, result.length() - 1);
            }
        }
        return result;
    }



    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        long beginTime = startTimeThreadLocal.get();//得到线程绑定的局部变量（开始时间）
        long endTime = System.currentTimeMillis();  //2、结束时间
        long costTime = endTime - beginTime;
        logger.info("<== 请求结束：耗时：{}ms  handler: {}  最大内存: {}m  已分配内存: {}m  已分配内存中的剩余空间: {}m  最大可用内存: {}m", costTime,
                handler, Runtime.getRuntime().maxMemory()/1024/1024, Runtime.getRuntime().totalMemory()/1024/1024, Runtime.getRuntime().freeMemory()/1024/1024,
                (Runtime.getRuntime().maxMemory()-Runtime.getRuntime().totalMemory()+Runtime.getRuntime().freeMemory())/1024/1024);
        if(costTime>2000) logger.warn("耗时：{}ms 过长，请检查性能！handler: {} ",costTime,handler);
    }
}

*/
