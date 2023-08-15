package com.playdata.pdfolio.global.exception;

public class CommonException extends RuntimeException{

    public CommonException(CommonExceptionMessage message) {
        super(message.name());
    }
}
