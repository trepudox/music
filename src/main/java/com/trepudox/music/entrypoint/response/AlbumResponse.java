package com.trepudox.music.entrypoint.response;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
public class AlbumResponse {

    private Long id;
    private String name;
    private ArtistResponse artist;
    private List<MusicResponse> tracks;
    private LocalDate releaseDate;

}
