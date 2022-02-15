package com.trepudox.music.entrypoint.request;

import lombok.Getter;

import javax.validation.constraints.Min;

@Getter
public class ObjectId {

    @Min(1)
    private Long id;

}
