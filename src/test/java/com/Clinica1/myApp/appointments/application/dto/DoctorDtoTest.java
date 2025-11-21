package com.Clinica1.myApp.appointments.application.dto;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DoctorDtoTest {

    @Test
    void testConstructorVacio() {
        DoctorDto dto = new DoctorDto();

        assertNotNull(dto);
        assertNull(dto.getId());
        assertNull(dto.getNombre());
        assertNull(dto.getCmp());
        assertNull(dto.getConsultorio());
        assertNull(dto.getEspecialidades());
    }

    @Test
    void testConstructorConParametros() {
        List<String> especialidades = List.of("Cardiología", "Emergencias");

        DoctorDto dto = new DoctorDto(
                1L,
                "Carlos Ramírez",
                "CMP1234",
                "Consultorio 5",
                especialidades
        );

        assertEquals(1L, dto.getId());
        assertEquals("Carlos Ramírez", dto.getNombre());
        assertEquals("CMP1234", dto.getCmp());
        assertEquals("Consultorio 5", dto.getConsultorio());
        assertEquals(especialidades, dto.getEspecialidades());
    }

    @Test
    void testGettersYSetters() {
        DoctorDto dto = new DoctorDto();

        dto.setId(10L);
        dto.setNombre("María López");
        dto.setCmp("CMP5678");
        dto.setConsultorio("Consultorio 2");
        dto.setEspecialidades(List.of("Pediatría"));

        assertEquals(10L, dto.getId());
        assertEquals("María López", dto.getNombre());
        assertEquals("CMP5678", dto.getCmp());
        assertEquals("Consultorio 2", dto.getConsultorio());
        assertEquals(List.of("Pediatría"), dto.getEspecialidades());
    }
}
