package com.soonphe.common.exception;

/**
 * 系统异常
 *
 * @author soonphe
 * @since 1.0
 */
public class SystemException extends RuntimeException {
    private String msg;

    public SystemException(String msg) {
        super(msg);
        this.msg = msg;
    }
}
