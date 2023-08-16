package com.playdata.pdfolio.domain.gather.exception;

public class GatherException extends RuntimeException{
    public GatherException(GatherExceptionMessage message) {
        super(message.name());
    }
}
