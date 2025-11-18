package com.Clinica1.myApp.IAMusuario.domain.model.valueobjects;

import java.util.Objects;

public record Email(String email_valor) {
    //para validacion
    public Email{
        if (email_valor == null || email_valor.trim().isBlank()){
            throw new IllegalArgumentException("Email cannot be null or be empty");
        }

        if (!email_valor.matches("^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$")){
            throw new IllegalArgumentException("Invalid Email");
        }
    }

    //public static Email el of es un metodo estatico q permite no usar el constructor luego
    public static Email of(String email_valor){
        return new Email(email_valor);
    }

    //vo siempre deben tener hashcode e equals pq se comparan por valor no identidad, record los tiene
    //automaticamente


}
