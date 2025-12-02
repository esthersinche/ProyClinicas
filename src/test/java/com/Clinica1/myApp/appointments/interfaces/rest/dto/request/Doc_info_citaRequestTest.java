package com.Clinica1.myApp.appointments.interfaces.rest.dto.request;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class Doc_info_citaRequestTest {

    private static Validator validator;

    @BeforeAll
    static void setupValidator() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    void getterSetter_ok() {
        Doc_info_citaRequest req = new Doc_info_citaRequest();

        req.setNom_com_doc("Luis Ramos");
        req.setEspe_doc("Cardiología");
        req.setConsult_doc("C-202");

        assertEquals("Luis Ramos", req.getNom_com_doc());
        assertEquals("Cardiología", req.getEspe_doc());
        assertEquals("C-202", req.getConsult_doc());
    }

    @Test
    void validation_fails_whenBlank() {
        Doc_info_citaRequest req = new Doc_info_citaRequest();
        req.setNom_com_doc("");
        req.setEspe_doc("");
        req.setConsult_doc("");

        Set<ConstraintViolation<Doc_info_citaRequest>> violations = validator.validate(req);

        assertEquals(3, violations.size());
    }

    @Test
    void validation_ok_whenAllFieldsProvided() {
        Doc_info_citaRequest req = new Doc_info_citaRequest(
                "Luis Ramos",
                "Cardiología",
                "C-202");

        Set<ConstraintViolation<Doc_info_citaRequest>> violations = validator.validate(req);

        assertTrue(violations.isEmpty());
    }
}
