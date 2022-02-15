package com.trepudox.music.util.factory;

import com.trepudox.music.entrypoint.response.global.GlobalResponse;
import com.trepudox.music.entrypoint.response.global.Metadata;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class GlobalResponseFactory {

    public static <T> GlobalResponse<T> create(T content) {
        Metadata metadata = Metadata.builder()
                .timestamp(ZonedDateTime.now())
                .selflink("localhost")
                .build();

        return GlobalResponse.<T>builder()
                .content(content)
                .metadata(metadata)
                .build();
    }

}
