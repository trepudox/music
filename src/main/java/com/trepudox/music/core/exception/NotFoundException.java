package com.trepudox.music.core.exception;

import com.trepudox.music.entity.enums.EntityEnums;
import lombok.Getter;

@Getter
public class NotFoundException extends RuntimeException {

    private final Long id;

    public NotFoundException(EntityEnums entityEnum, Long id) {
        super(String.format("%s with id %d not found", entityEnum.getLabel(), id));
        this.id = id;
    }

}
