package com.Clinica1.myApp.appointments.application.handler;

import com.Clinica1.myApp.SharedKernel.IDEntidad;
import com.Clinica1.myApp.appointments.application.assembler.CitaAssembler;
import com.Clinica1.myApp.appointments.application.command.CrearCitaCommand;
import com.Clinica1.myApp.appointments.application.dto.CitaDto;
import com.Clinica1.myApp.appointments.application.exception.CitaNoEncontradaException;
import com.Clinica1.myApp.appointments.application.exception.DoctorNoDisponibleException;
import com.Clinica1.myApp.appointments.application.exception.FechaInvalidaException;
import com.Clinica1.myApp.appointments.domain.model.aggregates.Cita;
import com.Clinica1.myApp.appointments.domain.model.aggregates.Doctor;
import com.Clinica1.myApp.appointments.domain.model.aggregates.Paciente;
import com.Clinica1.myApp.appointments.domain.model.valueobjects.Especialidad;
import com.Clinica1.myApp.appointments.domain.model.valueobjects.NombreCompleto;
import com.Clinica1.myApp.appointments.domain.repository.CitaRepository;
import com.Clinica1.myApp.appointments.domain.repository.DoctorRepository;
import com.Clinica1.myApp.appointments.domain.repository.PacienteRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

class CrearCitaCommandHandlerTest {

    private CitaRepository citaRepository;
    private DoctorRepository doctorRepository;
    private PacienteRepository pacienteRepository;
    private CitaAssembler citaAssembler;
    private CrearCitaCommandHandler handler;

    @BeforeEach
    void setup() {
        citaRepository = mock(CitaRepository.class);
        doctorRepository = mock(DoctorRepository.class);
        pacienteRepository = mock(PacienteRepository.class);
        citaAssembler = mock(CitaAssembler.class);

        handler = new CrearCitaCommandHandler(
                citaRepository,
                doctorRepository,
                pacienteRepository,
                citaAssembler);
    }

    @Test
    void deberiaLanzarErrorPorFechaEnPasado() {

        CrearCitaCommand cmd = new CrearCitaCommand(
                "Dolor",
                "Presencial",
                LocalDateTime.now().minusDays(1),
                LocalDateTime.now().plusHours(1),
                IDEntidad.astring("PAC-1"),
                IDEntidad.astring("DOC-1"),
                IDEntidad.astring("CLI-1"),
                "Medicina");

        assertThrows(FechaInvalidaException.class, () -> handler.handle(cmd));
    }

    @Test
    void deberiaLanzarErrorSiPacienteNoExiste() {

        when(pacienteRepository.findById(any())).thenReturn(null);

        CrearCitaCommand cmd = new CrearCitaCommand(
                "Motivo",
                "Presencial",
                LocalDateTime.now().plusDays(1),
                LocalDateTime.now().plusDays(1).plusHours(1),
                IDEntidad.astring("PAC-404"),
                IDEntidad.astring("DOC-1"),
                IDEntidad.astring("CLI-1"),
                "Dermatología");

        assertThrows(CitaNoEncontradaException.class, () -> handler.handle(cmd));
    }

    @Test
    void deberiaLanzarErrorSiDoctorNoExiste() {

        Paciente paciente = mock(Paciente.class);
        when(pacienteRepository.findById(any())).thenReturn(paciente);
        when(doctorRepository.findById(any())).thenReturn(null);

        CrearCitaCommand cmd = new CrearCitaCommand(
                "Consulta",
                "Virtual",
                LocalDateTime.now().plusDays(2),
                LocalDateTime.now().plusDays(2).plusHours(1),
                IDEntidad.astring("PAC-1"),
                IDEntidad.astring("DOC-404"),
                IDEntidad.astring("CLI-1"),
                "Neurología");

        assertThrows(CitaNoEncontradaException.class, () -> handler.handle(cmd));
    }

    @Test
    void deberiaLanzarErrorPorDoctorNoDisponible() {

        Paciente paciente = mock(Paciente.class);
        Doctor doctor = mock(Doctor.class);

        when(doctor.getId_doc()).thenReturn(IDEntidad.astring("DOC-1"));

        when(pacienteRepository.findById(any())).thenReturn(paciente);
        when(doctorRepository.findById(any())).thenReturn(doctor);

        Cita citaExistente = mock(Cita.class);
        when(citaExistente.getInicio_cita()).thenReturn(LocalDateTime.now().plusDays(1));
        when(citaExistente.getFin_cita()).thenReturn(LocalDateTime.now().plusDays(1).plusHours(1));

        when(citaRepository.findByDoctorId(any())).thenReturn(List.of(citaExistente));

        CrearCitaCommand cmd = new CrearCitaCommand(
                "Molestia",
                "Virtual",
                LocalDateTime.now().plusDays(1).plusMinutes(10),
                LocalDateTime.now().plusDays(1).plusHours(1).plusMinutes(10),
                IDEntidad.astring("PAC-1"),
                IDEntidad.astring("DOC-1"),
                IDEntidad.astring("CLI-1"),
                "Oftalmología");

        assertThrows(DoctorNoDisponibleException.class, () -> handler.handle(cmd));
    }

    @Test
    void deberiaLanzarErrorPorCanalInvalido() {

        Paciente paciente = mock(Paciente.class);
        Doctor doctor = mock(Doctor.class);

        when(pacienteRepository.findById(any())).thenReturn(paciente);
        when(doctorRepository.findById(any())).thenReturn(doctor);
        when(citaRepository.findByDoctorId(any())).thenReturn(Collections.emptyList());

        CrearCitaCommand cmd = new CrearCitaCommand(
                "Evaluación",
                "PresencialesX",
                LocalDateTime.now().plusDays(1),
                LocalDateTime.now().plusDays(1).plusHours(1),
                IDEntidad.astring("PAC-1"),
                IDEntidad.astring("DOC-1"),
                IDEntidad.astring("CLI-1"),
                "Traumatología");

        assertThrows(FechaInvalidaException.class, () -> handler.handle(cmd));
    }

    void deberiaCrearCitaCorrectamente() throws Exception {

        Paciente paciente = mock(Paciente.class);
        Doctor doctor = mock(Doctor.class);

        when(paciente.getNombre_com_pac()).thenReturn("Juan Perez");
        when(paciente.getDni_pac()).thenReturn("12345678");

        when(doctor.getNom_com_doc()).thenReturn(NombreCompleto.of("Luis", "Ramos"));
        when(doctor.getEspecialidades()).thenReturn(List.of(Especialidad.of("Cardiología")));
        when(doctor.getConsultorio_doc()).thenReturn("C-305");

        when(doctor.getId_doc()).thenReturn(IDEntidad.astring("DOC-1"));

        when(pacienteRepository.findById(any())).thenReturn(paciente);
        when(doctorRepository.findById(any())).thenReturn(doctor);
        when(citaRepository.findByDoctorId(any())).thenReturn(Collections.emptyList());

        Cita citaMock = mock(Cita.class);
        when(citaRepository.insert(any())).thenReturn(citaMock);

        CitaDto dtoMock = new CitaDto();
        when(citaAssembler.toDto(any())).thenReturn(dtoMock);

        CrearCitaCommand cmd = new CrearCitaCommand(
                "Chequeo",
                "Presencial",
                LocalDateTime.now().plusDays(1),
                LocalDateTime.now().plusDays(1).plusHours(1),
                IDEntidad.astring("PAC-1"),
                IDEntidad.astring("DOC-1"),
                IDEntidad.astring("CLI-1"),
                "Cardiología");

        CitaDto result = handler.handle(cmd);

        assertNotNull(result);
        verify(citaRepository).insert(any());
        verify(citaAssembler).toDto(any());
    }

}
