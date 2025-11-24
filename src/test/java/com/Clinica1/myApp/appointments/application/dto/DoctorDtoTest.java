package com.Clinica1.myApp.appointments.application.dto;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DoctorDtoTest {

    @Test
    void deberiaCrearDoctorDtoVacio() {
        DoctorDto dto = new DoctorDto();

        assertNotNull(dto);
        assertNull(dto.getId());
        assertNull(dto.getNombre());
        assertNull(dto.getCmp());
        assertNull(dto.getConsultorio());
        assertNull(dto.getEspecialidades());
    }

    @Test
    void deberiaCrearDoctorDtoConDatos() {
        List<String> especialidades = Arrays.asList("Cardiología", "Medicina Interna");

        DoctorDto dto = new DoctorDto(
                "DOC001",
                "Dr. López",
                "CMP-12345",
                "Consultorio 101",
                especialidades
        );

        assertEquals("DOC001", dto.getId());
        assertEquals("Dr. López", dto.getNombre());
        assertEquals("CMP-12345", dto.getCmp());
        assertEquals("Consultorio 101", dto.getConsultorio());
        assertEquals(especialidades, dto.getEspecialidades());
    }

    @Test
    void deberiaPermitirModificarDatos() {
        DoctorDto dto = new DoctorDto();

        dto.setId("DOC002");
        dto.setNombre("Dra. Martínez");
        dto.setCmp("CMP-77777");

        assertEquals("DOC002", dto.getId());
        assertEquals("Dra. Martínez", dto.getNombre());
        assertEquals("CMP-77777", dto.getCmp());
    }

    @Test
    void metodosVaciosDeberianRetornarValoresPorDefecto() {
        DoctorDto dto = new DoctorDto();

        // Estos métodos retornan valores fijos (vacíos)
        assertEquals("", dto.nombreCompleto());
        assertEquals("", dto.cmp());
        assertEquals("", dto.consultorio());
        assertTrue(dto.especialidades().isEmpty());
    }
}
