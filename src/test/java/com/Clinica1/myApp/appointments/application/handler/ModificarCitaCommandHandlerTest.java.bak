package com.Clinica1.myApp.appointments.application.handler;

import com.Clinica1.myApp.SharedKernel.IDEntidad;
import com.Clinica1.myApp.appointments.application.assembler.CitaAssembler;
import com.Clinica1.myApp.appointments.application.command.ModificarCitaCommand;
import com.Clinica1.myApp.appointments.application.dto.CitaDto;
import com.Clinica1.myApp.appointments.domain.model.aggregates.Cita;
import com.Clinica1.myApp.appointments.domain.model.aggregates.Doctor;
import com.Clinica1.myApp.appointments.domain.model.valueobjects.Estado;
import com.Clinica1.myApp.appointments.domain.repository.CitaRepository;
import com.Clinica1.myApp.appointments.domain.repository.DoctorRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ModificarCitaCommandHandlerTest {

    @Mock
    private CitaRepository citaRepository;

    @Mock
    private DoctorRepository doctorRepository;

    @Mock
    private CitaAssembler citaAssembler;

    @InjectMocks
    private ModificarCitaCommandHandler handler;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void deberiaModificarCitaCorrectamente() throws Exception {

        IDEntidad citaId = IDEntidad.astring("CITA-1");
        IDEntidad doctorId = IDEntidad.astring("DOC-1");

        Cita cita = mock(Cita.class);
        Doctor doctor = mock(Doctor.class);

        when(citaRepository.findById(citaId)).thenReturn(cita);
        when(doctorRepository.findById(any())).thenReturn(doctor);

        when(doctor.getId_doc()).thenReturn(doctorId);

        when(citaRepository.findByDoctorId(doctorId)).thenReturn(Collections.emptyList());

        LocalDateTime inicioNuevo = LocalDateTime.now().plusDays(1);
        LocalDateTime finNuevo = inicioNuevo.plusHours(1);

        ModificarCitaCommand cmd = new ModificarCitaCommand(
                citaId,
                inicioNuevo,
                finNuevo);

        Cita citaActualizada = mock(Cita.class);
        when(citaRepository.update(any())).thenReturn(citaActualizada);

        CitaDto dto = new CitaDto();
        when(citaAssembler.toDto(citaActualizada)).thenReturn(dto);

        CitaDto result = handler.handle(cmd);

        assertNotNull(result);
        verify(citaRepository).findById(citaId);
        verify(citaRepository).update(any());
        verify(citaAssembler).toDto(any());
    }
}
