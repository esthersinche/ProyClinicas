package com.Clinica1.myApp.IAMusuario.domain.exception;

public class ExternalServiceException extends RuntimeException {
    public ExternalServiceException(String message, Throwable causa) {
        super(message, causa);
    }
}
