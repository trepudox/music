package com.trepudox.music.entrypoint.response;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class GenreResponse {

    private Long id;
    private String name;
    private String description;
    private List<MusicResponse> tracks;

}
