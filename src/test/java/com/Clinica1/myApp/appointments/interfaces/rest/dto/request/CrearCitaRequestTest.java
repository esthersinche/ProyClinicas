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

class CrearCitaRequestTest {

    private static Validator validator;

    @BeforeAll
    static void setupValidator() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    void getterSetter_ok() {
        Pac_info_citaRequest pac = new Pac_info_citaRequest("Ana Pérez", "12345678");
        Doc_info_citaRequest doc = new Doc_info_citaRequest("Luis Ramos", "Cardiología", "C-202", "CMP12345");

        CrearCitaRequest req = new CrearCitaRequest();
        req.setDni_pac("12345678");
        req.setMotivo_cita("Dolor de pecho");
        req.setEspe_cita("Cardiología");
        req.setEstado_cita("Pendiente");
        req.setCanal_cita("Online");
        req.setInicio_cita(LocalDateTime.of(2025, 1, 10, 10, 0));
        req.setFin_cita(LocalDateTime.of(2025, 1, 10, 10, 30));
        req.setId_pac("PAC001");
        req.setId_doc("DOC001");
        req.setPac_info_req(pac);
        req.setDoc_info_req(doc);

        assertEquals("12345678", req.getDni_pac());
        assertEquals("Dolor de pecho", req.getMotivo_cita());
        assertEquals("Cardiología", req.getEspe_cita());
        assertEquals("Pendiente", req.getEstado_cita());
        assertEquals("Online", req.getCanal_cita());
        assertEquals(LocalDateTime.of(2025, 1, 10, 10, 0), req.getInicio_cita());
        assertEquals(LocalDateTime.of(2025, 1, 10, 10, 30), req.getFin_cita());
        assertEquals("PAC001", req.getId_pac());
        assertEquals("DOC001", req.getId_doc());
        assertEquals(pac, req.getPac_info_req());
        assertEquals(doc, req.getDoc_info_req());
    }

    @Test
    void validation_fails_whenMissingValues() {
        CrearCitaRequest req = new CrearCitaRequest();

        Set<ConstraintViolation<CrearCitaRequest>> violations = validator.validate(req);

        // Campos obligatorios: 11
        assertEquals(11, violations.size());
    }

    @Test
    void validation_ok_whenAllFieldsValid() {
        CrearCitaRequest req = new CrearCitaRequest(
                "12345678",
                "Dolor fuerte",
                "Cardiología",
                "Pendiente",
                "Online",
                LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(30),
                "PAC111",
                "DOC222",
                new Pac_info_citaRequest("Juan Pérez", "99999999"),
                new Doc_info_citaRequest("Luis Ramos", "Cardiología", "C-202"));

        Set<ConstraintViolation<CrearCitaRequest>> violations = validator.validate(req);

        assertTrue(violations.isEmpty());
    }
}
