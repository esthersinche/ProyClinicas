package com.Clinica1.myApp.IAMusuario.infrastructure.security;

import com.Clinica1.myApp.IAMusuario.application.services.ContraService;
import org.springframework.stereotype.Component;
import org.springframework.security.crypto.password.PasswordEncoder;

@Component
public class BCryptContraHasher implements ContraService {
    //
    private final PasswordEncoder encoder;

    public BCryptContraHasher(PasswordEncoder encoder) {
        this.encoder = encoder;
    }

    @Override
    public String hash(String valor_contra){
        return encoder.encode(valor_contra);

    }

    @Override
    public boolean matches(String valor_contra, String hashed){
        //verificacion segura
        return encoder.matches(valor_contra, hashed);
    }
}
