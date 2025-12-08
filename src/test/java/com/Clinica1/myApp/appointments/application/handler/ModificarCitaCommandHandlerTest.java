package com.Clinica1.myApp.appointments.application.handler;

import com.Clinica1.myApp.SharedKernel.IDEntidad;
import com.Clinica1.myApp.appointments.application.assembler.CitaAssembler;
import com.Clinica1.myApp.appointments.application.command.ModificarCitaCommand;
import com.Clinica1.myApp.appointments.application.dto.CitaDto;
import com.Clinica1.myApp.appointments.application.exception.CitaNoEncontradaException;
import com.Clinica1.myApp.appointments.application.exception.DoctorNoDisponibleException;
import com.Clinica1.myApp.appointments.application.exception.FechaInvalidaException;
import com.Clinica1.myApp.appointments.domain.model.aggregates.Cita;
import com.Clinica1.myApp.appointments.domain.model.aggregates.Doctor;
import com.Clinica1.myApp.appointments.domain.model.valueobjects.Canal;
import com.Clinica1.myApp.appointments.domain.model.valueobjects.Doc_info_cita;
import com.Clinica1.myApp.appointments.domain.model.valueobjects.Estado;
import com.Clinica1.myApp.appointments.domain.repository.CitaRepository;
import com.Clinica1.myApp.appointments.domain.repository.DoctorRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ModificarCitaCommandHandlerTest {

    @Mock
    private CitaRepository citaRepository;

    @Mock
    private DoctorRepository doctorRepository;

    @Mock
    private CitaAssembler citaAssembler;

    @InjectMocks
    private ModificarCitaCommandHandler handler;

    @Test
    void deberiaModificarCitaCorrectamente() throws Exception {

        IDEntidad citaId = IDEntidad.generar();
        IDEntidad doctorId = IDEntidad.generar();

        LocalDateTime inicioNuevo = LocalDateTime.now().plusDays(1);
        LocalDateTime finNuevo = inicioNuevo.plusHours(1);

        Cita cita = mock(Cita.class);
        Doctor doctor = mock(Doctor.class);
        CitaDto dtoEsperado = mock(CitaDto.class);

        when(citaRepository.findById(citaId)).thenReturn(Optional.of(cita));
        when(cita.getEstado_cita()).thenReturn(Estado.Pendiente);
        when(cita.getDoc_id()).thenReturn(doctorId);

        when(doctorRepository.findById(doctorId)).thenReturn(Optional.of(doctor));
        when(citaRepository.findByDoctorId(doctorId)).thenReturn(List.of());

        when(citaRepository.update(cita)).thenReturn(cita);
        when(citaAssembler.toDto(cita)).thenReturn(dtoEsperado);

        ModificarCitaCommand command = new ModificarCitaCommand(
                citaId,
                inicioNuevo,
                finNuevo
        );

        CitaDto resultado = handler.handle(command);

        assertNotNull(resultado);
        assertEquals(dtoEsperado, resultado);

        verify(cita).modificar(anyString(), eq(inicioNuevo), eq(finNuevo));
        verify(citaRepository).update(cita);
    }

    @Test
    void deberiaLanzarExcepcionSiCitaNoExiste() {

        IDEntidad citaId = IDEntidad.generar();

        when(citaRepository.findById(citaId)).thenReturn(Optional.empty());

        ModificarCitaCommand command = new ModificarCitaCommand(
                citaId,
                LocalDateTime.now().plusDays(1),
                LocalDateTime.now().plusDays(1).plusHours(1)
        );

        assertThrows(CitaNoEncontradaException.class, () ->
                handler.handle(command)
        );
    }

    @Test
    void deberiaLanzarExcepcionSiFechasSonInvalidas() {

        IDEntidad citaId = IDEntidad.generar();

        Cita cita = mock(Cita.class);

        when(citaRepository.findById(citaId)).thenReturn(Optional.of(cita));
        when(cita.getEstado_cita()).thenReturn(Estado.Pendiente);

        ModificarCitaCommand command = new ModificarCitaCommand(
                citaId,
                LocalDateTime.now().minusDays(1),
                LocalDateTime.now()
        );

        assertThrows(FechaInvalidaException.class, () ->
                handler.handle(command)
        );
    }

    @Test
    void deberiaLanzarExcepcionSiDoctorNoEstaDisponible() {

        IDEntidad citaId = IDEntidad.generar();
        IDEntidad doctorId = IDEntidad.generar();

        LocalDateTime inicio = LocalDateTime.now().plusDays(1);
        LocalDateTime fin = inicio.plusHours(1);

        Cita citaActual = mock(Cita.class);
        Cita citaExistente = mock(Cita.class);
        Doctor doctor = mock(Doctor.class);

        when(citaRepository.findById(citaId)).thenReturn(Optional.of(citaActual));
        when(citaActual.getEstado_cita()).thenReturn(Estado.Pendiente);
        when(citaActual.getDoc_id()).thenReturn(doctorId);

        when(doctorRepository.findById(doctorId)).thenReturn(Optional.of(doctor));

        when(citaExistente.getId_cita()).thenReturn(IDEntidad.generar());
        when(citaExistente.getEstado_cita()).thenReturn(Estado.Pendiente);
        when(citaExistente.getInicio_cita()).thenReturn(inicio.minusMinutes(30));
        when(citaExistente.getFin_cita()).thenReturn(fin.plusMinutes(30));

        when(citaRepository.findByDoctorId(doctorId))
                .thenReturn(List.of(citaExistente));

        ModificarCitaCommand command = new ModificarCitaCommand(
                citaId, inicio, fin
        );

        assertThrows(DoctorNoDisponibleException.class, () ->
                handler.handle(command)
        );
    }

    @Test
    void noDebePermitirModificarCitaCancelada() {

        IDEntidad citaId = IDEntidad.generar();
        Cita cita = mock(Cita.class);

        when(citaRepository.findById(citaId)).thenReturn(Optional.of(cita));
        when(cita.getEstado_cita()).thenReturn(Estado.Desercion);

        ModificarCitaCommand command = new ModificarCitaCommand(
                citaId,
                LocalDateTime.now().plusDays(1),
                LocalDateTime.now().plusDays(1).plusHours(1)
        );

        assertThrows(IllegalStateException.class, () ->
                handler.handle(command)
        );
    }
}
