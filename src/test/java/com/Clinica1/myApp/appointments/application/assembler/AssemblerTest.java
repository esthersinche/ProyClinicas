package com.Clinica1.myApp.appointments.application.assembler;

import com.Clinica1.myApp.SharedKernel.IDEntidad;
import com.Clinica1.myApp.appointments.application.dto.CitaDto;
import com.Clinica1.myApp.appointments.application.dto.DoctorInfoDto;
import com.Clinica1.myApp.appointments.application.dto.PacienteInfoDto;
import com.Clinica1.myApp.appointments.domain.model.aggregates.Cita;
import com.Clinica1.myApp.appointments.domain.model.valueobjects.*;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class CitaAssemblerTest {

    private final CitaAssembler assembler = new CitaAssembler();

    // ----- Helpers para crear value objects -----
    private Pac_info_cita crearPacInfoDummy() {
        return new Pac_info_cita("Juan Pérez", "12345678");
    }

    private Doc_info_cita crearDocInfoDummy() {
        return new Doc_info_cita("Luis Ramos", "Cardiología", "C101");
    }

    private Especialidad crearEspecialidadDummy() {
        return Especialidad.of("Dermatología");
    }

    @Test
    void testToPacienteInfoDto() {
        Pac_info_cita pac = crearPacInfoDummy();
        PacienteInfoDto dto = assembler.toPacienteInfoDto(pac);

        assertNotNull(dto);
        assertEquals("Juan Pérez", dto.getNombre());
        assertEquals("12345678", dto.getDni());
    }

    @Test
    void testToPacienteInfoDtoNull() {
        assertNull(assembler.toPacienteInfoDto(null));
    }

    @Test
    void testToDoctorInfoDto() {
        Doc_info_cita doc = crearDocInfoDummy();
        DoctorInfoDto dto = assembler.toDoctorInfoDto(doc);

        assertNotNull(dto);
        assertEquals("Luis Ramos", dto.getNombre());
        assertEquals("Cardiología", dto.getEspecialidad());
        assertEquals("C101", dto.getConsultorio());
    }

    @Test
    void testToDoctorInfoDtoNull() {
        assertNull(assembler.toDoctorInfoDto(null));
    }

    @Test
    void testToEspecialidad() {
        Especialidad esp = assembler.toEspecialidad("Cardiología");
        assertNotNull(esp);
        assertEquals("Cardiología", esp.nom_espe());

        assertNull(assembler.toEspecialidad(null));
        assertNull(assembler.toEspecialidad(""));
    }

    @Test
    void testToPacInfoCitaNull() {
        assertNull(assembler.toPacInfoCita(null));
    }

    @Test
    void testToDocInfoCitaNull() {
        assertNull(assembler.toDocInfoCita(null));
    }

    @Test
    void testToCitaDto() {
        Pac_info_cita pac = crearPacInfoDummy();
        Doc_info_cita doc = crearDocInfoDummy();
        Especialidad esp = crearEspecialidadDummy();

        LocalDateTime inicio = LocalDateTime.now();
        LocalDateTime fin = inicio.plusHours(1);

        // Crear cita dummy usando value objects
        Cita cita = new Cita(
                IDEntidad.generar(),
                "Dolor de cabeza",
                Estado.Asistio,
                Canal.Virtual,
                inicio,
                fin,
                IDEntidad.generar(), // pac id
                IDEntidad.generar(), // doc id
                pac,
                doc,
                esp
        );

        CitaDto dto = assembler.toDto(cita);

        assertNotNull(dto);
        assertEquals("Dolor de cabeza", dto.getMotivo());
        assertEquals("Asistio", dto.getEstado());
        assertEquals("Virtual", dto.getCanal());
        assertEquals(inicio, dto.getInicio());
        assertEquals(fin, dto.getFin());
        assertEquals("Dermatología", dto.getEspecialidad());

        assertNotNull(dto.getPaciente());
        assertEquals(pac.nomb_com_pac(), dto.getPaciente().getNombre());
        assertEquals(pac.dni_pac(), dto.getPaciente().getDni());

        assertNotNull(dto.getDoctor());
        assertEquals(doc.nombre_doc(), dto.getDoctor().getNombre());
        assertEquals(doc.espe_doc(), dto.getDoctor().getEspecialidad());
        assertEquals(doc.consult_doc(), dto.getDoctor().getConsultorio());

        // La clínica no se maneja todavía
        assertNull(dto.getClinica());
    }

    @Test
    void testToCitaDtoNull() {
        assertNull(assembler.toDto(null));
    }
}