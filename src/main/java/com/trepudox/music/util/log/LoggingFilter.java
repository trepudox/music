package com.trepudox.music.util.log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@Slf4j
@Component
public class LoggingFilter extends OncePerRequestFilter {

    private final Gson gson = new GsonBuilder().serializeNulls().create();

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        ContentCachingRequestWrapper request2 = new ContentCachingRequestWrapper(request);
        ContentCachingResponseWrapper response2 = new ContentCachingResponseWrapper(response);

        filterChain.doFilter(request2, response2);

        String jsonLog = gson.toJson(buildLogPayload(request2, response2));
        log.info(jsonLog);
    }

    private LogPayload buildLogPayload(ContentCachingRequestWrapper request, ContentCachingResponseWrapper response) {
        return LogPayload.builder()
                .timestamp(generateTimestamp())
                .method(request.getMethod())
                .path(request.getRequestURI())
                .status(HttpStatus.valueOf(response.getStatus()).toString())
                .requestBody(formatJson(request.getContentAsByteArray()))
                .responseBody(formatJson(response.getContentAsByteArray()))
                .build();
    }

    private Object formatJson(byte[] body) {
        try {
            return gson.fromJson(new String(body), Object.class);
        } catch(Exception e) {
            log.warn("Não foi possível converter o corpo da requisição e/ou da resposta.");
            return null;
        }
    }

    private String generateTimestamp() {
        return ZonedDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss.SSS VV"));
    }

}
