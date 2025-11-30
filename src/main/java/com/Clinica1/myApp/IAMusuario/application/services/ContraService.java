package com.Clinica1.myApp.IAMusuario.application.services;


public interface ContraService {
    //metodo q recibe texto y devuelve hasheado el String
    String hash(String valor_contra);
    //metodo q recibe texto y hashed y ve si coinciden
    boolean matches(String valor_contra, String contra_hashed);
}
