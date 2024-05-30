package com.soonphe.common.exception;

import com.soonphe.common.constants.IBaseEnum;

/**
 * 业务异常
 *
 * @author soonphe
 * @since 1.0
 */
public class BusinessException extends RuntimeException {
    private final IBaseEnum msg;
    private Object data;

    public BusinessException(IBaseEnum msg) {
        super(msg.getMessage());
        this.msg = msg;
    }

    public BusinessException(IBaseEnum msg, Object data) {
        super(msg.getMessage());
        this.msg = msg;
        this.data = data;
    }

    public IBaseEnum getMsg() {
        return this.msg;
    }

    public Object getData() {
        return this.data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}