package com.cd.zjyf.annotation;
import java.lang.annotation.*;

/**
 * @author chen.shuodong
 *AOP中不使用分页的注解
 */
@Retention(RetentionPolicy.RUNTIME) // 注解会在class字节码文件中存在，在运行时可以通过反射获取到  
@Target({ElementType.METHOD,ElementType.FIELD,ElementType.TYPE})//定义注解的作用目标**作用范围字段、枚举的常量/方法
@Documented//说明该注解将被包含在javadoc中  
public @interface NoPaging {


}
