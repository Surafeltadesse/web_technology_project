package com.hilcoe.web_technology_project.exception;

public class AlreadyCheckedInException extends RuntimeException {
    public AlreadyCheckedInException(String message) {
        super(message);
    }
}
