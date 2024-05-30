package com.soonphe.timber.common.exception;

import com.soonphe.timber.common.constants.IBaseEnum;
import com.soonphe.timber.common.constants.ResultCodeEnum;

/**
 * 断言处理类，用于抛出各种异常
 *
 * @author soonphe
 * @since 1.0
 */
public class Asserts {

    public static void fail(String message) {
        throw new BusinessException(ResultCodeEnum.FAILED);
    }

    public static void fail(IBaseEnum errorCode) {
        throw new BusinessException(errorCode);
    }
}
