/*
package com.cd.zjyf.mapper;

import com.cd.zjyf.annotation.NoPaging;
import com.cd.zjyf.annotation.ReidsCache;
import com.github.pagehelper.PageHelper;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

*/
/**
 * Created by chen.shuodong on 2018/5/14.
 *//*

//证明是一个配置文件(使用@Component也可以,因为点入后会发现@Configuration还是使用了@Component)
@Configuration
//证明是一个切面
@Aspect
public class DAOAOP {


    private static Logger log = LoggerFactory.getLogger(DAOAOP.class);
    //环绕aop
    //execution表达式 此表达式表示扫描controller下所有类的所有方法都执行此aop

    */
/**
     *
     * @param pro
     * @return
     * @throws Throwable
     *//*

    @Around("execution (public * com.cd.zjyf.mapper..*.*(..))")
    public Object methodAroud(ProceedingJoinPoint pro) throws Throwable {

        Class<?> classTarget=pro.getTarget().getClass();
        //先判断类上的注解，再判断方法上的注解
        Class<?>[] par = ((MethodSignature) pro.getSignature()).getParameterTypes();
        String methodName = pro.getSignature().getName();
        Method objMethod = classTarget.getMethod(methodName, par);
  */
/*      //分页
       if(classTarget.getAnnotation(NoPaging.class)==null){
            if(objMethod.getAnnotation(NoPaging.class)==null) {
                HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
                String page = request.getParameter("page");
                String size = request.getParameter("size");
                if (page != null && size != null) {
                    log.info("DAOAOP进行分页:当前第{}页," + "每页{}条。", page, size);
                    request.setAttribute("pageObj", PageHelper.startPage(Integer.parseInt(page), Integer.parseInt(size),false));
                }
            }
       }*//*

        long beginTime = System.currentTimeMillis();//1、开始时间
        Object proceed = pro.proceed();
        long endTime = System.currentTimeMillis();
        log.info("DAO层执行方法名：{}，sql花费的时间：{} ms",methodName,endTime-beginTime);

        return proceed;
    }



}*/
