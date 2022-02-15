package com.trepudox.music.util.factory;

import com.trepudox.music.entrypoint.response.global.GlobalResponse;
import com.trepudox.music.entrypoint.response.global.Metadata;
import com.trepudox.music.util.workaround.PropertiesWorkaround;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class GlobalResponseFactory {

    public static <T> GlobalResponse<T> build(T content) {
        Metadata metadata = Metadata.builder()
                .timestamp(ZonedDateTime.now())
                .selflink(PropertiesWorkaround.retrieveSelflink())
                .build();

        return GlobalResponse.<T>builder()
                .content(content)
                .metadata(metadata)
                .build();
    }

}
