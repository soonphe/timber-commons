package com.soonphe.common.constants;

/**
 * 通用枚举依赖
 *
 * @author soonphe
 * @since 1.0
 */
public interface IBaseEnum<T extends Enum<T> & IBaseEnum<T>> {

    Integer getCode();

    String getMessage();

    /**
     * 返回指定编码的'枚举'
     *
     * @param clazz
     * @param code
     * @param <T>
     * @return
     */
    static <T extends Enum<T> & IBaseEnum<T>> T getEnumBycode(Class<T> clazz, Integer code) {
        for (T inner : clazz.getEnumConstants()) {
            if (code.equals(inner.getCode())) {
                return inner;
            }
        }
        return null;
    }

    /**
     * 返回指定描述的'枚举'
     *
     * @param clazz
     * @param desc
     * @param <T>
     * @return
     */
    static <T extends Enum<T> & IBaseEnum<T>> T getEnumByDesc(Class<T> clazz, String desc) {
        for (T inner : clazz.getEnumConstants()) {
            if (desc.equals(inner.getMessage())) {
                return inner;
            }
        }
        return null;
    }
}