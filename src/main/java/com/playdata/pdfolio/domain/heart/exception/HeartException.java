package com.playdata.pdfolio.domain.heart.exception;

public class HeartException extends RuntimeException{
    public HeartException(HeartExceptionMessage message) {
        super(message.name());
    }
}
