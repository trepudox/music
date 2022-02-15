package com.trepudox.music.entity.enums;

import com.trepudox.music.core.exception.EnumMappingException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@AllArgsConstructor
public enum EntityEnums {

    ALBUM("Album"),
    ARTIST("Artist"),
    GENRE("Genre"),
    MUSIC("Music");

    private String label;


    public EntityEnums of(String entityName) {
        try {
            return EntityEnums.valueOf(entityName.toUpperCase());
        } catch(Exception ex) {
            log.error("There was an error while trying to convert '{}' into EntityEnums. Exception: {}", entityName, ex);
            throw new EnumMappingException(EntityEnums.class, entityName);
        }
    }

}
