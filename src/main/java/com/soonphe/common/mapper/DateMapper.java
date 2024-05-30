package com.soonphe.common.mapper;

import java.time.Instant;
import java.util.Objects;

/**
 * Date转换
 *
 * @author soonphe
 * @since 1.0
 */
public class DateMapper {
    public DateMapper() {
    }

    public Long asLong(Instant date) {
        return Objects.nonNull(date) ? date.toEpochMilli() : null;
    }

    public Instant asInstant(Long date) {
        return Objects.nonNull(date) ? Instant.ofEpochMilli(date) : null;
    }
}
