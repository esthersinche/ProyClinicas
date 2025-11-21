package com.Clinica1.myApp.appointments.application.dto;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PacienteDtoTest {

    @Test
    void testConstructorVacio() {
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
    void testConstructorConParametros() {
        PacienteDto dto = new PacienteDto(
                1L,
                "Juan Pérez",
                "Peruana",
                "12345678",
                "987654321",
                "juan@test.com"
        );

        assertEquals(1L, dto.getId());
        assertEquals("Juan Pérez", dto.getNombre());
        assertEquals("Peruana", dto.getNacionalidad());
        assertEquals("12345678", dto.getDni());
        assertEquals("987654321", dto.getTelefono());
        assertEquals("juan@test.com", dto.getEmail());
    }

    @Test
    void testGettersYSetters() {
        PacienteDto dto = new PacienteDto();

        dto.setId(10L);
        dto.setNombre("María López");
        dto.setNacionalidad("Argentina");
        dto.setDni("87654321");
        dto.setTelefono("912345678");
        dto.setEmail("maria@test.com");

        assertEquals(10L, dto.getId());
        assertEquals("María López", dto.getNombre());
        assertEquals("Argentina", dto.getNacionalidad());
        assertEquals("87654321", dto.getDni());
        assertEquals("912345678", dto.getTelefono());
        assertEquals("maria@test.com", dto.getEmail());
    }
}

