package com.trepudox.music.entrypoint.response;

import lombok.*;

import java.time.ZonedDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GlobalResponse<T> {

    private T content;
    private ZonedDateTime timestamp;
    private String selflink;

}
