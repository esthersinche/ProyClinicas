package com.Clinica1.myApp.mantenimiento.application.exception;

public class DomainException extends RuntimeException {
    public DomainException(String message) {
        super(message);
    }
}