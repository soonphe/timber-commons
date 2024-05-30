
package com.soonphe.timber.common.util;

import com.soonphe.timber.common.constants.ResultCodeEnum;
import com.soonphe.timber.common.exception.BusinessException;
import com.soonphe.timber.common.model.Request;
import jodd.vtor.Violation;
import jodd.vtor.Vtor;

import java.util.List;
import java.util.Optional;

/**
 * 通用校验
 *
 * @author soonphe
 * @since 1.0
 */
public class ValidatorUtils {

    private ValidatorUtils() {
    }

    public static void validateRequest(Request request) {
        Vtor vtor = Vtor.create();
        List<Violation> violations = vtor.validate(request);
        Optional.ofNullable(violations).ifPresent((s) -> {
            Optional<String> error = s.stream().map((v) -> {
                return v.getCheck().getMessage();
            }).findFirst();
            error.ifPresent((e) -> {
                throw new BusinessException(ResultCodeEnum.VALIDATE_FAILED, e);
            });
        });
    }
}
