package com.trepudox.music.entrypoint.response.global;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Metadata {

    private ZonedDateTime timestamp;
    private String selflink;

}
