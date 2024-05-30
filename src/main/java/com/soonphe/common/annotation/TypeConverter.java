package com.soonphe.common.annotation;

import java.lang.annotation.*;


/**
 * 属性转换注解
 *
 * @author soonphe
 * @since 1.0
 */
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Target({ElementType.FIELD})
public @interface TypeConverter {

    String toTypeFullName() default "java.lang.String";
}
