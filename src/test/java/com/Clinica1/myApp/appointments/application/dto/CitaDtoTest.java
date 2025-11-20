package com.Clinica1.myApp.appointments.application.dto;

import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import java.util.Arrays;
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
        
        PacienteDto paciente = new PacienteDto(1L, "Juan Pérez", "Peruana", "12345678", "999888777", "juan@email.com");
        DoctorDto doctor = new DoctorDto(2L, "Dr. López", "CMP-12345", "Consultorio 101", Arrays.asList("Cardiología"));
        
        CitaDto dto = new CitaDto(
            1L, "Consulta", "Pendiente", "Presencial",
            inicio, fin, paciente, doctor, "Clínica Central", "Cardiología"
        );
        
        assertEquals(1L, dto.getId());
        assertEquals("Consulta", dto.getMotivo());
        assertEquals("Pendiente", dto.getEstado());
        assertEquals("Presencial", dto.getCanal());
        assertEquals(inicio, dto.getInicio());
        assertEquals(fin, dto.getFin());
        assertEquals("Juan Pérez", dto.getPaciente().getNombre());
        assertEquals("Dr. López", dto.getDoctor().getNombre());
        assertEquals("Clínica Central", dto.getClinica());
        assertEquals("Cardiología", dto.getEspecialidad());
    }

    @Test
    void deberiaPermitirModificarDatos() {
        CitaDto dto = new CitaDto();
        
        dto.setId(1L);
        dto.setMotivo("Consulta general");
        dto.setEstado("Confirmada");
        
        assertEquals(1L, dto.getId());
        assertEquals("Consulta general", dto.getMotivo());
        assertEquals("Confirmada", dto.getEstado());
    }
}
