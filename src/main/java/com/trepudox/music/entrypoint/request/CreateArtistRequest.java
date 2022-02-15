package com.trepudox.music.entrypoint.request;

import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
public class CreateArtistRequest {

    @NotBlank
    private String name;

}
