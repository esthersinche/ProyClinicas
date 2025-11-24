package com.Clinica1.myApp.appointments.application.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PacienteDtoTest {

    @Test
    void deberiaCrearPacienteDtoVacio() {
        PacienteDto dto = new PacienteDto();

        assertNotNull(dto);
        assertNull(dto.getId());
        assertNull(dto.getNombre());
        assertNull(dto.getNacionalidad());
        assertNull(dto.getDni());
        assertNull(dto.getTelefono());
        assertNull(dto.getEmail());
    }


    @Test
    void deberiaCrearPacienteDtoConDatos() {

        PacienteDto dto = new PacienteDto(
                "PAC001",
                "Juan Pérez",
                "Peruana",
                "12345678",
                "987654321",
                "juan@email.com"
        );

        assertEquals("PAC001", dto.getId());
        assertEquals("Juan Pérez", dto.getNombre());
        assertEquals("Peruana", dto.getNacionalidad());
        assertEquals("12345678", dto.getDni());
        assertEquals("987654321", dto.getTelefono());
        assertEquals("juan@email.com", dto.getEmail());
    }

    @Test
    void deberiaPermitirModificarDatos() {
        PacienteDto dto = new PacienteDto();

        dto.setId("PAC002");
        dto.setNombre("María López");
        dto.setDni("87654321");

        assertEquals("PAC002", dto.getId());
        assertEquals("María López", dto.getNombre());
        assertEquals("87654321", dto.getDni());
    }
}

