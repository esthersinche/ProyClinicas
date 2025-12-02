package com.Clinica1.myApp.IAMusuario.infrastructure.configuration;

import com.Clinica1.myApp.IAMusuario.application.TokenProvider;
import com.Clinica1.myApp.IAMusuario.infrastructure.security.JWTTokenProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JWTConfig {
    @Value("${app.jwt.secret}")
    private String jwtsecreto;

    @Value("${app.jwt.exp-seconds:900}")
    private long jwtexpiracionsg;

    @Bean
    public TokenProvider tokenProvider(){
        return new JWTTokenProvider(jwtsecreto, jwtexpiracionsg);
    }

}
