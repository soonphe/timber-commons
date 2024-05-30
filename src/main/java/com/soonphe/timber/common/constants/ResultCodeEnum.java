package com.soonphe.timber.common.constants;

/**
 * 通用返回码接口
 *
 * @author soonphe
 * @since 1.0
 */
public enum ResultCodeEnum implements IBaseEnum<ResultCodeEnum> {

    /**
     * 通用返回码接口
     */
    SUCCESS(200, "操作成功"),
    FAILED(500, "操作失败"),
    VALIDATE_FAILED(404, "参数检验失败"),
    UNAUTHORIZED(401, "暂未登录或token已经过期"),
    FORBIDDEN(403, "没有相关权限");

    private Integer code;
    private String message;

    private ResultCodeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public Integer getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
