package com.trepudox.music.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Builder
public class Music {

    private String name;
    private Genre genre;
    private Artist artist;
    private Album album;
    private LocalDate releaseDate;

}
