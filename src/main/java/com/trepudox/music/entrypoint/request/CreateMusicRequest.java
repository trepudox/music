package com.trepudox.music.entrypoint.request;

import lombok.Getter;

@Getter
public class CreateMusicRequest {

    private String name;
    private ObjectId genre;
    private ObjectId artist;
    private ObjectId album;
    private String releaseDate;

}
