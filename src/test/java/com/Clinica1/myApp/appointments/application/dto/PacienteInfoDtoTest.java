package com.Clinica1.myApp.appointments.application.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PacienteInfoDtoTest {
    @Test
    void testConstructorConParametros() {
        PacienteInfoDto dto = new PacienteInfoDto(
                "Juan Pérez",
                "12345678"
        );

        assertEquals("Juan Pérez", dto.getNombre());
        assertEquals("12345678", dto.getDni());
    }

    @Test
    void testConstructorVacioYSetters() {
        PacienteInfoDto dto = new PacienteInfoDto();

        dto.setNombre("Ana Torres");
        dto.setDni("87654321");

        assertEquals("Ana Torres", dto.getNombre());
        assertEquals("87654321", dto.getDni());
    }

    @Test
    void testValoresNulos() {
        PacienteInfoDto dto = new PacienteInfoDto(null, null);

        assertNull(dto.getNombre());
        assertNull(dto.getDni());
    }
}
