package com.Clinica1.myApp.appointments.application.dto;

import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class CitaDtoTest {

    @Test
    void deberiaCrearCitaDtoVacio() {
        CitaDto dto = new CitaDto();
        assertNotNull(dto);
    }

    @Test
    void deberiaCrearCitaDtoConDatos() {

        LocalDateTime inicio = LocalDateTime.now();
        LocalDateTime fin = inicio.plusHours(1);

        PacienteInfoDto paciente = new PacienteInfoDto(
                "Juan Pérez",
                "12345678"
        );

        DoctorInfoDto doctor = new DoctorInfoDto(
                "Dr. López",
                "Cardiología",
                "Consultorio 101"
        );

        CitaDto dto = new CitaDto(
                "CITA123",
                "Consulta",
                "Pendiente",
                "Presencial",
                inicio,
                fin,
                paciente,
                doctor,
                "Clínica Central",
                "Cardiología"
        );

        assertEquals("CITA123", dto.getId());
        assertEquals("Consulta", dto.getMotivo());
        assertEquals("Pendiente", dto.getEstado());
        assertEquals("Presencial", dto.getCanal());
        assertEquals(inicio, dto.getInicio());
        assertEquals(fin, dto.getFin());

        assertNotNull(dto.getPaciente());
        assertEquals("Juan Pérez", dto.getPaciente().getNombre());
        assertEquals("12345678", dto.getPaciente().getDni());

        assertNotNull(dto.getDoctor());
        assertEquals("Dr. López", dto.getDoctor().getNombre());
        assertEquals("Cardiología", dto.getDoctor().getEspecialidad());
        assertEquals("Consultorio 101", dto.getDoctor().getConsultorio());

        assertEquals("Clínica Central", dto.getClinica());
        assertEquals("Cardiología", dto.getEspecialidad());
    }

    @Test
    void deberiaPermitirModificarDatos() {
        CitaDto dto = new CitaDto();

        dto.setId("ABC123");
        dto.setMotivo("Consulta general");
        dto.setEstado("Confirmada");

        assertEquals("ABC123", dto.getId());
        assertEquals("Consulta general", dto.getMotivo());
        assertEquals("Confirmada", dto.getEstado());
    }
}
