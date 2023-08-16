package com.playdata.pdfolio.domain.member.exception;

public class MemberException extends RuntimeException{
    public MemberException(MemberExceptionMessage message) {
        super(message.name());
    }
}
