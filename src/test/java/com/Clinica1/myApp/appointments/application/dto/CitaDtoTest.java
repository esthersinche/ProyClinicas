package com.Clinica1.myApp.appointments.application.dto;

import com.Clinica1.myApp.SharedKernel.IDEntidad;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class CitaDtoTest {

    @Test
    void deberiaCrearCitaDtoConConstructorCorrectamente() {
        IDEntidad id = IDEntidad.generar();
        String motivo = "Dolor de cabeza";
        String estado = "Pendiente";
        String canal = "Presencial";
        LocalDateTime inicio = LocalDateTime.now();
        LocalDateTime fin = inicio.plusMinutes(30);

        PacienteInfoDto paciente = new PacienteInfoDto("Luis Ramos", "12345678");
        DoctorInfoDto doctor = new DoctorInfoDto("Dr. Pérez", "Cardiología", "Consultorio 3");
        String clinica = "Clinica Internacional";
        String especialidad = "Cardiología";

        CitaDto dto = new CitaDto(
                id,
                motivo,
                estado,
                canal,
                inicio,
                fin,
                paciente,
                doctor,
                clinica,
                especialidad);

        assertNotNull(dto, "✔ El DTO no debe ser nulo");
        assertEquals(id, dto.getId(), "✔ El ID debe coincidir");
        assertEquals(motivo, dto.getMotivo(), "✔ El motivo debe coincidir");
        assertEquals(estado, dto.getEstado(), "✔ El estado debe coincidir");
        assertEquals(canal, dto.getCanal(), "✔ El canal debe coincidir");
        assertEquals(inicio, dto.getInicio(), "✔ El inicio debe coincidir");
        assertEquals(fin, dto.getFin(), "✔ El fin debe coincidir");
        assertEquals(paciente, dto.getPaciente(), "✔ El paciente debe coincidir");
        assertEquals(doctor, dto.getDoctor(), "✔ El doctor debe coincidir");
        assertEquals(clinica, dto.getClinica(), "✔ La clínica debe coincidir");
        assertEquals(especialidad, dto.getEspecialidad(), "✔ La especialidad debe coincidir");
    }

    @Test
    void deberiaCrearCitaDtoConBuilderCorrectamente() {
        IDEntidad id = IDEntidad.generar();
        LocalDateTime inicio = LocalDateTime.now();
        LocalDateTime fin = inicio.plusHours(1);

        CitaDto dto = CitaDto.builder()
                .id(id)
                .motivo("Consulta general")
                .estado("Pendiente")
                .canal("Virtual")
                .inicio(inicio)
                .fin(fin)
                .paciente(new PacienteInfoDto("Ana López", "87654321"))
                .doctor(new DoctorInfoDto("Dr. Ramírez", "Dermatología", "Consultorio 5"))
                .clinica("San Pablo")
                .especialidad("Dermatología")
                .build();

        assertNotNull(dto, "✔ El DTO no debe ser nulo");
        assertEquals("Consulta general", dto.getMotivo(), "✔ El motivo debe coincidir");
        assertEquals("Virtual", dto.getCanal(), "✔ El canal debe coincidir");
        assertEquals("Dermatología", dto.getEspecialidad(), "✔ La especialidad debe coincidir");
    }
}
