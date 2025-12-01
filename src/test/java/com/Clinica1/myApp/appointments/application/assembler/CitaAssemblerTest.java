package com.Clinica1.myApp.appointments.application.assembler;

import com.Clinica1.myApp.SharedKernel.IDEntidad;
import com.Clinica1.myApp.appointments.application.dto.*;
import com.Clinica1.myApp.appointments.domain.model.aggregates.Cita;
import com.Clinica1.myApp.appointments.domain.model.aggregates.Doctor;
import com.Clinica1.myApp.appointments.domain.model.aggregates.Paciente;
import com.Clinica1.myApp.appointments.domain.model.valueobjects.*;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CitaAssemblerTest {

    private final CitaAssembler assembler = new CitaAssembler();

    @Test
    void deberiaConvertirCitaA_CitaDto_Correctamente() {

        IDEntidad id = IDEntidad.generar();

        Pac_info_cita pacInfo = new Pac_info_cita("Juan Pérez", "12345678");
        Doc_info_cita docInfo = Doc_info_cita.of("Dr. House", "Cardiología", "C-12");

        Cita cita = new Cita(
                id,
                "Dolor de cabeza",
                Estado.Pendiente,
                Canal.Presencial,
                LocalDateTime.of(2025, 1, 1, 10, 0),
                LocalDateTime.of(2025, 1, 1, 11, 0),
                IDEntidad.generar(),
                IDEntidad.generar(),
                pacInfo,
                docInfo,
                Especialidad.of("Neurología"));

        CitaDto dto = assembler.toDto(cita);

        assertNotNull(dto);
        assertEquals(id, dto.getId());
        assertEquals("Dolor de cabeza", dto.getMotivo());
        assertEquals("Pendiente", dto.getEstado());
        assertEquals("Presencial", dto.getCanal());
        assertEquals("Neurología", dto.getEspecialidad());
        assertEquals("Juan Pérez", dto.getPaciente().getNombre());
        assertEquals("Dr. House", dto.getDoctor().getNombre());

        System.out.println("✔ Conversión Cita → CitaDto correctamente realizada");
    }

    @Test
    void deberiaConvertirPacInfoCitaA_PacienteInfoDto() {
        Pac_info_cita pac = new Pac_info_cita("María López", "87654321");

        PacienteInfoDto dto = assembler.toPacienteInfoDto(pac);

        assertEquals("María López", dto.getNombre());
        assertEquals("87654321", dto.getDni());

        System.out.println("✔ Conversión Pac_info_cita → PacienteInfoDto correcta");
    }

    @Test
    void deberiaConvertirDocInfoCitaA_DoctorInfoDto() {
        Doc_info_cita doc = Doc_info_cita.of("Dr. Strange", "Trauma", "A-5");

        DoctorInfoDto dto = assembler.toDoctorInfoDto(doc);

        assertEquals("Dr. Strange", dto.getNombre());
        assertEquals("Trauma", dto.getEspecialidad());
        assertEquals("A-5", dto.getConsultorio());

        System.out.println("✔ Conversión Doc_info_cita → DoctorInfoDto correcta");
    }

    @Test
    void deberiaConvertirNombreEspecialidadA_ObjetoEspecialidad() {
        Especialidad esp = assembler.toEspecialidad("Dermatología");

        assertNotNull(esp);
        assertEquals("Dermatología", esp.nom_espe());

        System.out.println("✔ Conversión String → Especialidad correcta");
    }

    @Test
    void deberiaCrearEntidadCitaCorrectamente() {

        Paciente pac = new Paciente(
                IDEntidad.generar(),
                "Luis",
                "Peruano",
                "12345678",
                "987654321",
                Email.of("luis@example.com"),
                null,
                "M");

        Doctor doc = Doctor.creardoc(
                IDEntidad.generar(),
                NombreCompleto.of("Ana", "Martínez"),
                "CMP12345",
                "C-20",
                List.of(Especialidad.of("Cirugía")));

        Cita cita = assembler.toCita(
                "Chequeo general",
                "Presencial",
                LocalDateTime.of(2025, 2, 10, 9, 0),
                LocalDateTime.of(2025, 2, 10, 9, 30),
                pac,
                doc,
                "Cirugía");

        assertNotNull(cita);
        assertEquals("Chequeo general", cita.getMotivo_cita());
        assertEquals(Canal.Presencial, cita.getCanal_cita());
        assertEquals("Cirugía", cita.getEspe_cita().nom_espe());

        System.out.println("✔ Conversión datos → Entidad Cita correctamente creada");
    }

}
