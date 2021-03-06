package com.trepudox.music.entrypoint.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateGenreRequest {

    @NotBlank
    private String name;

    @NotBlank
    private String description;

}
