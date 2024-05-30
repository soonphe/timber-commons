package com.soonphe.timber.common.constants;

import lombok.Data;

import java.io.Serializable;

/**
 * 通用返回对象
 *
 * @author soonphe
 * @since 1.0
 */
@Data
public class CommonResult<T>  implements Serializable {
    /**
     * 状态码
     */
    private long code;
    /**
     * 提示信息
     */
    private String message;
    /**
     * 数据封装
     */
    private T data;
    /**
     * 额外信息
     */
    private String ext = "";

    protected CommonResult() {
    }

    protected CommonResult(long code, String message) {
        this.code = code;
        this.message = message;
    }

    protected CommonResult(long code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    protected CommonResult(long code, String message, T data, String ext) {
        this.code = code;
        this.message = message;
        this.data = data;
        this.ext = ext;
    }

    /**
     * 成功返回结果
     */
    public static <T> CommonResult<T> success() {
        return new CommonResult<T>(ResultCodeEnum.SUCCESS.getCode(), ResultCodeEnum.SUCCESS.getMessage(), null);
    }

    /**
     * 成功返回结果
     *
     * @param data 获取的数据
     */
    public static <T> CommonResult<T> success(T data) {
        return new CommonResult<T>(ResultCodeEnum.SUCCESS.getCode(), ResultCodeEnum.SUCCESS.getMessage(), data);
    }

    /**
     * 成功返回结果
     *
     * @param data 获取的数据
     * @param  message 提示信息
     */
    public static <T> CommonResult<T> success(T data, String message) {
        return new CommonResult<T>(ResultCodeEnum.SUCCESS.getCode(), message, data);
    }

    /**
     * 成功返回结果
     *
     * @param data    获取的数据
     * @param message 提示信息
     */
    public static <T> CommonResult<T> success(T data, String message, String ext) {
        return new CommonResult<T>(ResultCodeEnum.SUCCESS.getCode(), message, data, ext);
    }

    /**
     * 失败返回结果 错误码500
     */
    public static <T> CommonResult<T> failed() {
        return failed(ResultCodeEnum.FAILED);
    }

    /**
     * 失败返回结果
     * @param message 提示信息
     */
    public static <T> CommonResult<T> failed(String message) {
        return new CommonResult<T>(ResultCodeEnum.FAILED.getCode(), message, null);
    }

    /**
     * 失败返回结果
     * @param code 错误码
     * @param message 提示信息
     */
    public static <T> CommonResult<T> failed(Long code, String message) {
        return new CommonResult<T>(code, message, null);
    }

    /**
     * 失败返回结果
     * @param code 错误码
     * @param message 提示信息
     * @param data 获取的数据
     */
    public static <T> CommonResult<T> failed(Long code, String message, T data) {
        return new CommonResult<T>(code, message, data);
    }

    /**
     * 失败返回结果
     * @param baseEnum 错误码枚举
     */
    public static <T> CommonResult<T> failed(IBaseEnum baseEnum) {
        return new CommonResult<T>(baseEnum.getCode(), baseEnum.getMessage(), null);
    }

    /**
     * 失败返回结果
     * @param baseEnum 错误码枚举
     * @param message 错误信息
     */
    public static <T> CommonResult<T> failed(IBaseEnum baseEnum,String message) {
        return new CommonResult<T>(baseEnum.getCode(), message, null);
    }
}
