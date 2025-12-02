package com.Clinica1.myApp.appointments.interfaces.rest.dto.response;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CrearCitaResponseTest {

    @Test
    void builder_ok() {
        CrearCitaResponse res = CrearCitaResponse.builder()
                .cita_id("CITA123")
                .message_cita("Cita creada correctamente")
                .build();

        assertEquals("CITA123", res.getCita_id());
        assertEquals("Cita creada correctamente", res.getMessage_cita());
    }

    @Test
    void gettersSetters_ok() {
        CrearCitaResponse res = new CrearCitaResponse();

        res.setCita_id("CITA999");
        res.setMessage_cita("OK");

        assertEquals("CITA999", res.getCita_id());
        assertEquals("OK", res.getMessage_cita());
    }

    @Test
    void allArgsConstructor_ok() {
        CrearCitaResponse res = new CrearCitaResponse(
                "CITA555",
                "Todo bien");

        assertEquals("CITA555", res.getCita_id());
        assertEquals("Todo bien", res.getMessage_cita());
    }

    @Test
    void noArgsConstructor_ok() {
        CrearCitaResponse res = new CrearCitaResponse();

        assertNull(res.getCita_id());
        assertNull(res.getMessage_cita());
    }
}
