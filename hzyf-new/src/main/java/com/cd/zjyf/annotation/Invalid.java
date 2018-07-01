package com.cd.zjyf.annotation;
import java.lang.annotation.*;

/**
 * @author chen.shuodong
 *redis处理的对象里的属性标记为无效字段，不进行字段数据字典转化
 */
@Retention(RetentionPolicy.RUNTIME) // 注解会在class字节码文件中存在，在运行时可以通过反射获取到  
@Target({ElementType.FIELD})//定义注解的作用目标**作用范围字段、枚举的常量/方法  
@Documented//说明该注解将被包含在javadoc中  
public @interface Invalid {


}
