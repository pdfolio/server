package com.playdata.pdfolio.global.exception;

import lombok.AllArgsConstructor;

public record ExceptionResponse(String message) {

    public static ExceptionResponse from(RuntimeException e){
        return new ExceptionResponse(e.getMessage());
    }
}
