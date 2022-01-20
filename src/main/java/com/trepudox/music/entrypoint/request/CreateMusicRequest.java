package com.trepudox.music.entrypoint.request;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class CreateMusicRequest {

    private String name;
    private ObjectId genre;
    private ObjectId artist;
    private ObjectId album;

    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate releaseDate;

}
