package com.trepudox.music.entrypoint.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ArtistResponse {

    private Long id;
    private String name;

    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    private List<AlbumResponse> albums;

}
