package com.trepudox.music.entrypoint.request;

import lombok.Getter;

@Getter
public class CreateAlbumRequest {

    private String name;
    private ObjectId artist;
    private String releaseDate;

}
