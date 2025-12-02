package com.Clinica1.myApp.IAMusuario.interfaces.rest.request;

import com.Clinica1.myApp.IAMusuario.interfaces.rest.dto.request.LoginRequest;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import jakarta.validation.ConstraintViolation;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class LoginRequestTest {

    @Test
    void testCompletoLoginRequest() {

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        LoginRequest vacio = new LoginRequest();
        Set<ConstraintViolation<LoginRequest>> violaciones = validator.validate(vacio);

        assertEquals(2, violaciones.size());

        LoginRequest soloUsername = new LoginRequest();
        soloUsername.setUsername("user123");

        Set<ConstraintViolation<LoginRequest>> violSoloUser = validator.validate(soloUsername);

        assertTrue(violSoloUser.stream().anyMatch(v -> v.getPropertyPath().toString().equals("password")));

        LoginRequest soloPassword = new LoginRequest();
        soloPassword.setPassword("pass123");

        Set<ConstraintViolation<LoginRequest>> violSoloPass = validator.validate(soloPassword);

        assertTrue(violSoloPass.stream().anyMatch(v -> v.getPropertyPath().toString().equals("username")));

        LoginRequest valido = new LoginRequest();
        valido.setUsername("admin");
        valido.setPassword("12345");

        Set<ConstraintViolation<LoginRequest>> sinViolaciones = validator.validate(valido);

        assertTrue(sinViolaciones.isEmpty());

        assertEquals("admin", valido.getUsername());
        assertEquals("12345", valido.getPassword());
    }
}
