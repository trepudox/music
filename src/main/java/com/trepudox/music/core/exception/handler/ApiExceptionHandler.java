package com.trepudox.music.core.exception.handler;

import com.trepudox.music.core.exception.EnumMappingException;
import com.trepudox.music.core.exception.NotFoundException;
import com.trepudox.music.entrypoint.response.ErrorResponse;
import com.trepudox.music.entrypoint.response.global.GlobalResponse;
import com.trepudox.music.util.factory.GlobalResponseFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.LinkedList;
import java.util.List;

@RestControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<GlobalResponse<List<ErrorResponse>>> handleNotFoundException(NotFoundException ex) {
        ErrorResponse error = ErrorResponse.builder()
                .title("Entity not found")
                .detail(ex.getMessage())
                .build();

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(GlobalResponseFactory.create(List.of(error)));
    }

    @ExceptionHandler(EnumMappingException.class)
    public ResponseEntity<GlobalResponse<List<ErrorResponse>>> handleEnumMappingException(EnumMappingException ex) {
        ErrorResponse error = ErrorResponse.builder()
                .title("Enum mapping error")
                .detail(ex.getMessage())
                .build();

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(GlobalResponseFactory.create(List.of(error)));
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

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(GlobalResponseFactory.create(errorList));
    }


}
