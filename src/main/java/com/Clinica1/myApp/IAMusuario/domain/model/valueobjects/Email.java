package com.Clinica1.myApp.IAMusuario.domain.model.valueobjects;

public final class Email {
    //para validacion
    private final String email_valor;

    private Email(String email_valor) {//VO siempre debe tener constructor private y metodos estaticos
        this.email_valor = email_valor;
    }

    //public static Email
    public static Email of(String email_valor){
        return new Email(email_valor);
    }
}
