package com.trepudox.music.entrypoint.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GenreResponse {

    private Long id;
    private String name;
    private String description;
    private List<MusicResponse> tracks;
    private List<AlbumResponse> albums;

}
