package com.trepudox.music.entrypoint.response.global;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GlobalResponse<T> {

    private T content;
    private Metadata metadata;

}
