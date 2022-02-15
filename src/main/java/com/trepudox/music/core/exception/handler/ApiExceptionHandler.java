package com.trepudox.music.core.exception.handler;

import com.trepudox.music.core.exception.EnumMappingException;
import com.trepudox.music.core.exception.NotFoundException;
import com.trepudox.music.entrypoint.response.ErrorResponse;
import com.trepudox.music.entrypoint.response.global.GlobalResponse;
import com.trepudox.music.util.factory.GlobalResponseFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.LinkedList;
import java.util.List;

@Slf4j
@RestControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    private static final String EXCEPTION_MESSAGE = "EXCEPTION: {}";

    @ExceptionHandler(NotFoundException.class)
    protected ResponseEntity<GlobalResponse<List<ErrorResponse>>> handleNotFoundException(NotFoundException ex, HttpServletRequest request) {
        ErrorResponse error = ErrorResponse.builder()
                .title("Entity not found")
                .detail(ex.getMessage())
                .build();

        log.error(EXCEPTION_MESSAGE, ex.toString());

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(GlobalResponseFactory.build(List.of(error), request.getRequestURI()));
    }

    @ExceptionHandler(EnumMappingException.class)
    protected ResponseEntity<GlobalResponse<List<ErrorResponse>>> handleEnumMappingException(EnumMappingException ex, HttpServletRequest request) {
        ErrorResponse error = ErrorResponse.builder()
                .title("Enum mapping error")
                .detail(ex.getMessage())
                .build();

        log.error(EXCEPTION_MESSAGE, ex.toString());

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(GlobalResponseFactory.build(List.of(error), request.getRequestURI()));
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<GlobalResponse<List<ErrorResponse>>> handleDataIntegrityViolationException(DataIntegrityViolationException ex,
                                                                                                     HttpServletRequest request) {
        ErrorResponse error = ErrorResponse.builder()
                .title("Internal server error")
                .detail("There was an internal server error that couldn't be processed")
                .build();

        log.error(EXCEPTION_MESSAGE, ex.toString());

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(GlobalResponseFactory.build(List.of(error), request.getRequestURI()));
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

        List<ErrorResponse> errorList = new LinkedList<>();
        String objectName = ex.getObjectName();

        for(FieldError fieldError : ex.getFieldErrors()) {
            String fieldName = fieldError.getField();

            String title = String.format("Field error in object %s on field %s", objectName, fieldName);
            String detail = String.format("%s.%s %s", objectName, fieldName, fieldError.getDefaultMessage());

            errorList.add(ErrorResponse.builder()
                    .title(title)
                    .detail(detail)
                    .build());
        }

        log.error(EXCEPTION_MESSAGE, ex.toString());

        ServletWebRequest servletWebRequest = (ServletWebRequest) request;
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(GlobalResponseFactory.build(errorList, servletWebRequest.getRequest().getRequestURI()));
    }


}
