package com.Clinica1.myApp.IAMusuario.infrastructure.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;

import com.Clinica1.myApp.IAMusuario.application.TokenProvider;
import org.springframework.stereotype.Component;

@Component
public class JWTTokenProvider implements TokenProvider {
    private final Key key
}
