package com.hilcoe.web_technology_project.exception;

public class InvalidQRTokenException extends RuntimeException {
    public InvalidQRTokenException(String message) {
        super(message);
    }
}
