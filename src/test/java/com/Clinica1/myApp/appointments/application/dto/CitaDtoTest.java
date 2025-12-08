package com.Clinica1.myApp.appointments.application.dto;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class CitaDtoTest {

    @Test
    void deberiaCrearCitaDtoConConstructorCompleto() {

        // Arrange
        LocalDateTime inicio = LocalDateTime.of(2025, 1, 10, 9, 0);
        LocalDateTime fin = LocalDateTime.of(2025, 1, 10, 10, 0);

        PacienteInfoDto paciente = new PacienteInfoDto("Juan Perez", "12345678");
        DoctorInfoDto doctor = new DoctorInfoDto(
                "Dr. House",
                "Cardiología",
                "C-12",
                "CMP12345"
        );

        // Act
        CitaDto dto = new CitaDto(
                "ID-1",
                "Chequeo",
                "Pendiente",
                "Presencial",
                inicio,
                fin,
                paciente,
                doctor,
                "Cardiología"
        );

        // Assert
        assertEquals("ID-1", dto.getId());
        assertEquals("Chequeo", dto.getMotivo());
        assertEquals("Pendiente", dto.getEstado());
        assertEquals("Presencial", dto.getCanal());
        assertEquals(inicio, dto.getInicio());
        assertEquals(fin, dto.getFin());
        assertEquals("Juan Perez", dto.getPaciente().getNombre());
        assertEquals("Dr. House", dto.getDoctor().getNombre());
        assertEquals("Cardiología", dto.getEspecialidad());
    }

    @Test
    void deberiaCrearCitaDtoUsandoBuilder() {

        // Arrange
        LocalDateTime inicio = LocalDateTime.of(2025, 2, 1, 8, 0);
        LocalDateTime fin = LocalDateTime.of(2025, 2, 1, 8, 30);

        // Act
        CitaDto dto = CitaDto.builder()
                .id("ID-2")
                .motivo("Consulta general")
                .estado("Confirmada")
                .canal("Virtual")
                .inicio(inicio)
                .fin(fin)
                .especialidad("Medicina General")
                .build();

        // Assert
        assertEquals("ID-2", dto.getId());
        assertEquals("Consulta general", dto.getMotivo());
        assertEquals("Confirmada", dto.getEstado());
        assertEquals("Virtual", dto.getCanal());
        assertEquals(inicio, dto.getInicio());
        assertEquals(fin, dto.getFin());
        assertEquals("Medicina General", dto.getEspecialidad());
    }

    @Test
    void deberiaPermitirModificarValoresConSetters() {

        // Arrange
        CitaDto dto = new CitaDto();

        // Act
        dto.setId("ID-3");
        dto.setMotivo("Emergencia");
        dto.setEstado("Atendida");
        dto.setCanal("Presencial");

        // Assert
        assertEquals("ID-3", dto.getId());
        assertEquals("Emergencia", dto.getMotivo());
        assertEquals("Atendida", dto.getEstado());
        assertEquals("Presencial", dto.getCanal());
    }
}