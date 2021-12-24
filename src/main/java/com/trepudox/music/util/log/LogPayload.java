package com.trepudox.music.util.log;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.gson.JsonObject;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LogPayload {

    private String timestamp;
    private String method;
    private String path;
    private String status;
    private Object requestBody;
    private Object responseBody;

}
