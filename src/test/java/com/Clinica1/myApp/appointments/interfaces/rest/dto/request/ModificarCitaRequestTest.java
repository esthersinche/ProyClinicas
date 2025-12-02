package com.Clinica1.myApp.appointments.interfaces.rest.dto.request;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class ModificarCitaRequestTest {

    private static Validator validator;

    @BeforeAll
    static void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    void gettersSetters_ok() {
        LocalDateTime ini = LocalDateTime.of(2025, 2, 10, 15, 0);
        LocalDateTime fin = LocalDateTime.of(2025, 2, 10, 15, 30);

        ModificarCitaRequest req = new ModificarCitaRequest();
        req.setInicio(ini);
        req.setFin(fin);

        assertEquals(ini, req.getInicio());
        assertEquals(fin, req.getFin());
    }

    @Test
    void validation_fails_whenMissingFields() {
        ModificarCitaRequest req = new ModificarCitaRequest();

        Set<ConstraintViolation<ModificarCitaRequest>> violations = validator.validate(req);

        // Deben fallar 2: inicio y fin
        assertEquals(2, violations.size());
    }

    @Test
    void validation_ok_whenValid() {
        ModificarCitaRequest req = new ModificarCitaRequest(
                LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(20));

        Set<ConstraintViolation<ModificarCitaRequest>> violations = validator.validate(req);

        assertTrue(violations.isEmpty());
    }
}
