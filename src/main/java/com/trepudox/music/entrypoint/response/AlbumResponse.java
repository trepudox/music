package com.trepudox.music.entrypoint.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AlbumResponse {

    private Long id;
    private String name;
    private ArtistResponse artist;
    private List<MusicResponse> tracks;
    private LocalDate releaseDate;

}
