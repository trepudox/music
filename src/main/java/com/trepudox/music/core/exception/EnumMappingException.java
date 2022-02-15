package com.trepudox.music.core.exception;

import lombok.Getter;

@Getter
public class EnumMappingException extends RuntimeException {

    public EnumMappingException(Class<?> clazz, String value) {
        super(String.format("An error was caught while trying to convert '%s' into %s", value, clazz.getSimpleName()));
    }

}
