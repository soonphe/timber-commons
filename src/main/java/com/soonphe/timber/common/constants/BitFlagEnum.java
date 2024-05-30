package com.soonphe.timber.common.constants;

import java.util.Optional;

/**
 * 标志位枚举
 *
 * @author soonphe
 * @since 1.0
 */
public enum BitFlagEnum implements IBaseEnum<BitFlagEnum> {
    /**
     *
     */
    Y(1, "是"),
    N(0, "否");

    private Integer code;
    private String msg;

    private BitFlagEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public Integer getCode() {
        return this.code;
    }

    @Override
    public String getMessage() {
        return this.msg;
    }

    public static Optional<BitFlagEnum> of(Integer code) {
        return Optional.ofNullable(IBaseEnum.getEnumBycode(BitFlagEnum.class, code));
    }
}
