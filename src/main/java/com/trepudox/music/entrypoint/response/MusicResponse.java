package com.trepudox.music.entrypoint.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MusicResponse {

    private Long id;
    private String name;
    private GenreResponse genre;
    private ArtistResponse artist;
    private AlbumResponse album;
    private LocalDate releaseDate;

}
