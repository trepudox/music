package com.trepudox.music.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class Genre {

    private String name;
    private String description;
    private List<Music> musics;

}
