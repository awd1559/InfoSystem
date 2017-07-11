package com.bread.info.util;

import org.springframework.core.convert.converter.Converter;

import java.util.UUID;

public class StringToUUIDConverter implements Converter<String, UUID> {
    public UUID convert(String source) {
        return UUID.fromString(source);
    }
}