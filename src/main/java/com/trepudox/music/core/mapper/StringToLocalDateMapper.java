package com.trepudox.music.core.mapper;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class StringToLocalDateMapper {

    public static LocalDate map(String date) {
        return LocalDate.parse(date);
    }

}
