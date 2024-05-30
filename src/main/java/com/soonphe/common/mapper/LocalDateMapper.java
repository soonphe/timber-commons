package com.soonphe.common.mapper;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Objects;

/**
 * LocalDate转换
 *
 * @author soonphe
 * @since 1.0
 */
public class LocalDateMapper {
    public LocalDateMapper() {
    }

    public Long asLong(LocalDateTime date) {
        return Objects.nonNull(date) ? date.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli() : null;
    }

    public LocalDateTime asLocalDate(Long date) {
        return Objects.nonNull(date) ? LocalDateTime.ofInstant(Instant.ofEpochMilli(date), ZoneId.systemDefault()) : null;
    }
}
