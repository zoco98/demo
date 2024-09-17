package com.example.demo.conrtolleradvice;

import com.example.demo.exception.EmptyRepositoryException;
import com.example.demo.exception.ErrorCodeResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(EmptyRepositoryException.class)
    public ResponseEntity<ErrorCodeResponse> handleEmptyRepositoryException(EmptyRepositoryException emptyRepositoryException){
        ErrorCodeResponse errorCodeResponse = ErrorCodeResponse.builder()
                .errorCode(emptyRepositoryException.getErrorCode())
                .errorMsg(emptyRepositoryException.getErrorMessage())
                .statusCode(HttpStatus.BAD_REQUEST.value()).build();
        return new ResponseEntity<>(errorCodeResponse, HttpStatus.BAD_REQUEST);
    }

}
