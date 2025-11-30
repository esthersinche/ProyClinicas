package com.IAMusuario.interfaces.request;

import com.Clinica1.myApp.IAMusuario.interfaces.rest.dto.request.CrearUsuarioRequest;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import jakarta.validation.ConstraintViolation;

import org.junit.jupiter.api.Test;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class CrearUsuarioWebRequestTest {

    @Test
    void testCompletoCrearUsuarioRequest() {

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        CrearUsuarioRequest reqVacio = new CrearUsuarioRequest();
        Set<ConstraintViolation<CrearUsuarioRequest>> violaciones = validator.validate(reqVacio);

        assertEquals(6, violaciones.size());

        CrearUsuarioRequest reqEmailInvalido = new CrearUsuarioRequest();
        reqEmailInvalido.setUsername("usuario");
        reqEmailInvalido.setPassword("pass");
        reqEmailInvalido.setNombres("Juan");
        reqEmailInvalido.setApellidos("Lopez");
        reqEmailInvalido.setRol("Admin");
        reqEmailInvalido.setEmail("correo-invalido");

        Set<ConstraintViolation<CrearUsuarioRequest>> violEmail = validator.validate(reqEmailInvalido);

        assertTrue(violEmail.stream()
                .anyMatch(v -> v.getPropertyPath().toString().equals("email")));

        CrearUsuarioRequest reqCorrecto = new CrearUsuarioRequest();
        reqCorrecto.setUsername("juan123");
        reqCorrecto.setPassword("strongpass");
        reqCorrecto.setNombres("Juan");
        reqCorrecto.setApellidos("Lopez");
        reqCorrecto.setTelefono("999888777");
        reqCorrecto.setEmail("juan@mail.com");
        reqCorrecto.setRol("Admin");

        Set<ConstraintViolation<CrearUsuarioRequest>> sinViolaciones = validator.validate(reqCorrecto);

        assertTrue(sinViolaciones.isEmpty());

        assertEquals("juan123", reqCorrecto.getUsername());
        assertEquals("strongpass", reqCorrecto.getPassword());
        assertEquals("Juan", reqCorrecto.getNombres());
        assertEquals("Lopez", reqCorrecto.getApellidos());
        assertEquals("999888777", reqCorrecto.getTelefono());
        assertEquals("juan@mail.com", reqCorrecto.getEmail());
        assertEquals("Admin", reqCorrecto.getRol());

        reqCorrecto.setNombre("OtroNombre");
        reqCorrecto.setApellido("OtroApellido");

        assertEquals("Juan", reqCorrecto.getNombres());
        assertEquals("Lopez", reqCorrecto.getApellidos());
    }
}

