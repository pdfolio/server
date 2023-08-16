package com.playdata.pdfolio.domain.project.exception;

public class ProjectException extends RuntimeException{
    public ProjectException(ProjectExceptionMessage message) {
        super(message.name());
    }
}
