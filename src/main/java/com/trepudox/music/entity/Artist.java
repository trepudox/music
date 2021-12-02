package com.trepudox.music.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class Artist {

    private String name;
    private List<Album> albums;

}
