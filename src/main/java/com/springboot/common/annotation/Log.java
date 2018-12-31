package com.springboot.common.annotation;

import java.lang.annotation.*;

/**
 * @Author :yan
 * @Date :Create in 12/31/18
 * @Description :自定义系统日志注解
 */

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Log {
    String value() default "";
}
