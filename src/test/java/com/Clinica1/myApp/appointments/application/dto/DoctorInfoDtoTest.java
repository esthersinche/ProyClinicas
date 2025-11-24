package com.Clinica1.myApp.appointments.application.dto;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DoctorInfoDtoTest {
    @Test
    void testConstructorConParametros() {
        DoctorInfoDto dto = new DoctorInfoDto(
                "Luis Ramos",
                "Cardiología",
                "C101"
        );

        assertEquals("Luis Ramos", dto.getNombre());
        assertEquals("Cardiología", dto.getEspecialidad());
        assertEquals("C101", dto.getConsultorio());
    }

    @Test
    void testConstructorVacioYSetters() {
        DoctorInfoDto dto = new DoctorInfoDto();

        dto.setNombre("Ana Torres");
        dto.setEspecialidad("Dermatología");
        dto.setConsultorio("C202");

        assertEquals("Ana Torres", dto.getNombre());
        assertEquals("Dermatología", dto.getEspecialidad());
        assertEquals("C202", dto.getConsultorio());
    }

    @Test
    void testValoresNulos() {
        DoctorInfoDto dto = new DoctorInfoDto(null, null, null);

        assertNull(dto.getNombre());
        assertNull(dto.getEspecialidad());
        assertNull(dto.getConsultorio());
    }
}
