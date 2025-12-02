package com.Clinica1.myApp.appointments.interfaces.rest.dto.response;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ModificarCitaResponseTest {

    @Test
    void builder_ok() {
        ModificarCitaResponse res = ModificarCitaResponse.builder()
                .cita_id("CITA123")
                .message("Modificada correctamente")
                .build();

        assertEquals("CITA123", res.getCita_id());
        assertEquals("Modificada correctamente", res.getMessage());
    }

    @Test
    void gettersSetters_ok() {
        ModificarCitaResponse res = new ModificarCitaResponse();

        res.setCita_id("CITA777");
        res.setMessage("Actualizada");

        assertEquals("CITA777", res.getCita_id());
        assertEquals("Actualizada", res.getMessage());
    }

    @Test
    void allArgsConstructor_ok() {
        ModificarCitaResponse res = new ModificarCitaResponse(
                "CITA555",
                "Cambios aplicados");

        assertEquals("CITA555", res.getCita_id());
        assertEquals("Cambios aplicados", res.getMessage());
    }

    @Test
    void noArgsConstructor_ok() {
        ModificarCitaResponse res = new ModificarCitaResponse();

        assertNull(res.getCita_id());
        assertNull(res.getMessage());
    }
}
