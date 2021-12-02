package com.trepudox.music.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Builder
public class Album {

    private String name;
    private Artist artist;
    private List<Music> tracks;
    private LocalDate releaseDate;

}
