package com.Clinica1.myApp.appointments.interfaces.rest.dto.request;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class Pac_info_citaRequestTest {

    private static Validator validator;

    @BeforeAll
    static void setupValidator() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    void getterSetter_ok() {
        Pac_info_citaRequest req = new Pac_info_citaRequest();

        req.setNom_com_pac("Ana Pérez");
        req.setDni_pac("12345678");

        assertEquals("Ana Pérez", req.getNom_com_pac());
        assertEquals("12345678", req.getDni_pac());
    }

    @Test
    void validation_fails_whenBlank() {
        Pac_info_citaRequest req = new Pac_info_citaRequest();
        req.setNom_com_pac("");
        req.setDni_pac("");

        Set<ConstraintViolation<Pac_info_citaRequest>> violations = validator.validate(req);

        assertEquals(2, violations.size());
    }

    @Test
    void validation_ok_whenAllFieldsProvided() {
        Pac_info_citaRequest req = new Pac_info_citaRequest(
                "Ana Pérez",
                "12345678");

        Set<ConstraintViolation<Pac_info_citaRequest>> violations = validator.validate(req);

        assertTrue(violations.isEmpty());
    }
}
