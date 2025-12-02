package com.Clinica1.myApp.IAMusuario.application.exception;

public class JWTInvalidException extends RuntimeException {
    public JWTInvalidException(String mssg) {
        super(mssg);
    }
    public JWTInvalidException(String msg, Throwable causa){
        super(msg, causa);
    }
}
