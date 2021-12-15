package com.trepudox.music.entrypoint.response;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class MusicResponse {

    private Long id;
    private String name;
    private GenreResponse genre;
    private ArtistResponse artist;
    private AlbumResponse album;
    private LocalDate releaseDate;

}
