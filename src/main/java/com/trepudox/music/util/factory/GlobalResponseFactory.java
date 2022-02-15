package com.trepudox.music.util.factory;

import com.trepudox.music.entrypoint.response.GlobalResponse;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class GlobalResponseFactory {

    public static <T> GlobalResponse<T> create(T content) {
        return GlobalResponse.<T>builder()
                .content(content)
                .selflink("localhost")
                .timestamp(ZonedDateTime.now())
                .build();
    }

}
