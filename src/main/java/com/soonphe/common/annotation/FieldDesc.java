package com.soonphe.common.annotation;

/**
 * 属性描述注解
 *
 * @author soonphe
 * @since 1.0
 */
public @interface FieldDesc {
    String name() default "";
}
