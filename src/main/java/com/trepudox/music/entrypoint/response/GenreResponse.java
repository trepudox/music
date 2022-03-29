package com.trepudox.music.entrypoint.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GenreResponse {

    private Long id;
    private String name;
    private String description;

}
