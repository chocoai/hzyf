package com.cd.zjyf.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.cd.zjyf.annotation.ClearReidsCache;
import com.cd.zjyf.annotation.NoPaging;
import com.cd.zjyf.annotation.Paging;
import com.cd.zjyf.annotation.ReidsCache;
import com.github.pagehelper.PageHelper;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.BoundSetOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;


import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.concurrent.TimeUnit;

/**
 * Created by chen.shuodong on 2018/5/14.
 */
//证明是一个配置文件(使用@Component也可以,因为点入后会发现@Configuration还是使用了@Component)
@Configuration
//证明是一个切面
@Aspect
public class ServiceAOP {


    @Value("${ReidsCache.enable}")
    private boolean enable;

    @Value("${ReidsCache.time}")
    private long  time;


    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    private static Logger log = LoggerFactory.getLogger(ServiceAOP.class);

    //清缓存用，存放url的一个set
    public final static String urlCache="hzyf-new";



    //环绕aop
    //execution表达式 此表达式表示扫描controller下所有类的所有方法都执行此aop
    /**
     * 通过注解的方式是否启用缓存,分页（注意：当一个service有多个查询方法时候不适合分页）
     * @param pro
     * @return
     * @throws Throwable
     */
    @Around("execution (public * com.cd.zjyf.service..*.*(..))")
    public Object methodAroud(ProceedingJoinPoint pro) throws Throwable {


        Class<?> classTarget=pro.getTarget().getClass();
        //先判断类上的注解，再判断方法上的注解
        Class<?>[] par = ((MethodSignature) pro.getSignature()).getParameterTypes();
        String methodName = pro.getSignature().getName();
        Method objMethod = classTarget.getMethod(methodName, par);

        //分页
        //分页注解存在且分页标识为false，那么不进行分页
        if(classTarget.getAnnotation(NoPaging.class)==null){
            Paging paging = objMethod.getAnnotation(Paging.class);
            if(!(paging !=null&&paging.value()==false)) {
                HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
                String page = request.getParameter("page");
                String size = request.getParameter("size");
                boolean total = true;
                if(paging!=null&&paging.total()==false){
                    total=false;
                }
                if (page != null && size != null) {
                    log.info("DAOAOP进行分页:当前第{}页," + "每页{}条。", page, size);
                    request.setAttribute("pageObj", PageHelper.startPage(Integer.parseInt(page), Integer.parseInt(size),total));
                }
            }
        }

        //缓存开关
        if(enable!=true) return pro.proceed();
        //通过Query注解判断是否启用redis缓存
        ReidsCache reidsCache_class = classTarget.getAnnotation(ReidsCache.class);
        //先判断类上的注解，再判断方法上的注解
        ReidsCache reidsCache_method = objMethod.getAnnotation(ReidsCache.class);
        //当类注解不加且方法注解不加/方法注解加了，但是值为false==》不进行缓存
        if((reidsCache_class==null&&reidsCache_method==null)||(reidsCache_method != null&&reidsCache_method.value()==false)) {
                Object proceed = pro.proceed();
                //清除缓存
                if(objMethod.getAnnotation(ClearReidsCache.class)!=null){
                    BoundSetOperations<String, String> usls = redisTemplate.boundSetOps(urlCache);
                    redisTemplate.delete(usls.members());
                    log.debug("已清除redis缓存！");
//                    usls.getOperations()
                }
                return proceed;
        }

        //获取request请求提(需要时备用)
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

        //进入方法前执行的代码
        String requestURL = request.getRequestURL().toString();
        String queryString = request.getQueryString();

        String url=requestURL+"?"+queryString;
        //去除前端url中的time时间戳
        //http://122.225.118.58:8886/resource/api/zjyfscreen/yearTotalZL?regionCode=330000000%2C%20330500000&time=1526352422633
        url=url.replaceAll("&+time=\\d+","");

        String data=null;
        try {
            data = redisTemplate.boundValueOps(url).get();
        }catch (Exception e){
            log.error("redis连接异常",e);
        }
        if(data!=null){
            log.debug("已从redis缓存中获取数据！");
            //获取返回值类型
            Signature signature =  pro.getSignature();
            Class returnType = ((MethodSignature) signature).getReturnType();
            //不需要返回数组判断
          /*   if(Collection.class.isAssignableFrom(returnType)){
                return JSON.parseArray()t(data,returnType);
            }*/
            return JSON.parseObject(data,returnType);
        }
        //执行调用的方法
        Object proceed = pro.proceed();

        //方法执行完成后执行的方法
        //  redisTemplate.boundValueOps(url).set(JSON.toJSONString(proceed, SerializerFeature.WriteMapNullValue),time, TimeUnit.SECONDS);
        try {
            redisTemplate.boundValueOps(url).set(JSON.toJSONStringWithDateFormat(proceed,"yyyy-MM-dd HH:mm:ss",SerializerFeature.WriteMapNullValue),time, TimeUnit.SECONDS);
            //向集合中放入5分钟
//            redisTemplate.opsForSet().
            BoundSetOperations<String, String> usls = redisTemplate.boundSetOps(urlCache);
            usls.add(url);
            usls.expire(time, TimeUnit.SECONDS);
            log.debug("url:{}已放入缓存中，缓存时间{}秒",url,time);
        }catch (Exception e){
            log.error("redis连接异常",e);
        }

        return proceed;
    }

    /*@Around("execution (public * com.cd.zjyf.service..*.*(..))")
    public Object methodAroud1(ProceedingJoinPoint pro) throws Throwable {


        Class<?> classTarget=pro.getTarget().getClass();
        //先判断类上的注解，再判断方法上的注解
        Class<?>[] par = ((MethodSignature) pro.getSignature()).getParameterTypes();
        String methodName = pro.getSignature().getName();
        Method objMethod = classTarget.getMethod(methodName, par);

        //分页
        //分页注解存在且分页标识为false，那么不进行分页
        if(classTarget.getAnnotation(NoPaging.class)==null){
            Paging paging = objMethod.getAnnotation(Paging.class);
            if(!(paging !=null&&paging.value()==false)) {
                HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
                String page = request.getParameter("page");
                String size = request.getParameter("size");
                boolean total = true;
                if(paging!=null&&paging.total()==false){
                    total=false;
                }
                if (page != null && size != null) {
                    log.info("DAOAOP进行分页:当前第{}页," + "每页{}条。", page, size);
                    request.setAttribute("pageObj", PageHelper.startPage(Integer.parseInt(page), Integer.parseInt(size),total));
                }
            }
        }

        //缓存开关
        if(enable!=true) return pro.proceed();
        //通过Query注解判断是否启用redis缓存
        ReidsCache reidsCache = classTarget.getAnnotation(ReidsCache.class);
        //先判断类上的注解，再判断方法上的注解
        if(reidsCache==null) {
            ReidsCache annotation = objMethod.getAnnotation(ReidsCache.class);
            if (annotation == null) {
                Object proceed = pro.proceed();
                //清除缓存
                if(objMethod.getAnnotation(ClearReidsCache.class)!=null){

                }
                return proceed;
            }
        }

        //获取request请求提(需要时备用)
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

        //进入方法前执行的代码
        String requestURL = request.getRequestURL().toString();
        String queryString = request.getQueryString();

        String url=requestURL+"?"+queryString;
        //去除前端url中的time时间戳
        //http://122.225.118.58:8886/resource/api/zjyfscreen/yearTotalZL?regionCode=330000000%2C%20330500000&time=1526352422633
        url=url.replaceAll("&+time=\\d+","");

        String data=null;
        try {
            data = redisTemplate.boundValueOps(url).get();
        }catch (Exception e){
            log.error("redis连接异常",e);
        }
        if(data!=null){
            //获取返回值类型
            Signature signature =  pro.getSignature();
            Class returnType = ((MethodSignature) signature).getReturnType();
            //不需要返回数组判断
          *//*   if(Collection.class.isAssignableFrom(returnType)){
                return JSON.parseArray()t(data,returnType);
            }*//*
            return JSON.parseObject(data,returnType);
        }
        //执行调用的方法
        Object proceed = pro.proceed();

        //方法执行完成后执行的方法
        //  redisTemplate.boundValueOps(url).set(JSON.toJSONString(proceed, SerializerFeature.WriteMapNullValue),time, TimeUnit.SECONDS);
        try {
            redisTemplate.boundValueOps(url).set(JSON.toJSONStringWithDateFormat(proceed,"yyyy-MM-dd HH:mm:ss",SerializerFeature.WriteMapNullValue),time, TimeUnit.SECONDS);
        }catch (Exception e){
            log.error("redis连接异常",e);
        }

        return proceed;
    }*/


/*    *//**
     * 通过请求方式判断是否启用缓存
     * @param pro
     * @return
     * @throws Throwable
     *//*
    @Around("execution (* com.cd.zjyf.service..*.*(..))")
    public Object methodAroudByRequestMethod(ProceedingJoinPoint pro) throws Throwable {

        //获取request请求提(需要时备用)
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String method = request.getMethod();
        //如果不是get请求直接不调用缓存
        if(!method.equals("GET"))  return pro.proceed();

        //进入方法前执行的代码
        String requestURL = request.getRequestURL().toString();
        String queryString = request.getQueryString();
        String url=requestURL+"?"+queryString;

        String data =  redisTemplate.boundValueOps(url).get();

        if(data!=null){
            //获取返回值类型
            Signature signature =  pro.getSignature();
            Class returnType = ((MethodSignature) signature).getReturnType();
            //不需要返回数组判断
         *//*   if(Collection.class.isAssignableFrom(returnType)){
                return JSON.parseArray()t(data,returnType);
            }*//*
            return JSON.parseObject(data,returnType);
        }
        //执行调用的方法
        Object proceed = pro.proceed();

        //方法执行完成后执行的方法
        redisTemplate.boundValueOps(url).set(JSON.toJSONString(proceed),60*10, TimeUnit.SECONDS);

        return proceed;
    }*/
    public static void main(String[] args) {
        Paging paging = null
                ;
        if(!(paging !=null&&paging.value()!=true)){
            System.out.println("sdf");
        }
        System.out.println("dafsd");
    }
}