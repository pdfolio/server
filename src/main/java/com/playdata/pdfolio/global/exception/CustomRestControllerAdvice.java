package com.playdata.pdfolio.global.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomRestControllerAdvice {

    @ExceptionHandler(PdFolioException.class)
    public ResponseEntity<ExceptionResponse> PdFolioExceptionHandler(PdFolioException e){
        return ResponseEntity
                .status(e.getHttpStatus())
                .body(ExceptionResponse.from(e));
    }
}
