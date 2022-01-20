package com.trepudox.music.entrypoint.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateGenreRequest {

    private String name;
    private String description;

}
