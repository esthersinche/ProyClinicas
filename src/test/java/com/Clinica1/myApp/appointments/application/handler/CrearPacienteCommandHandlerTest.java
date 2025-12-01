package com.Clinica1.myApp.appointments.application.handler;

import com.Clinica1.myApp.SharedKernel.IDEntidad;
import com.Clinica1.myApp.appointments.application.command.CrearPacienteCommand;
import com.Clinica1.myApp.appointments.domain.model.aggregates.Paciente;
import com.Clinica1.myApp.appointments.domain.model.valueobjects.Email;
import com.Clinica1.myApp.appointments.domain.repository.PacienteRepository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CrearPacienteCommandHandlerTest {

    @Mock
    private PacienteRepository pacienteRepository;

    @InjectMocks
    private CrearPacienteCommandHandler handler;

    @Test
    void deberiaLanzarExcepcionSiSexoEsVacio() {

        CrearPacienteCommand command = CrearPacienteCommand.builder()
                .nombre("Juan Perez")
                .nacionalidad("Peruana")
                .dni("12345678")
                .tel("987654321")
                .email("juan@test.com")
                .fec_nac(new Date())
                .sexo("") // Inválido
                .build();

        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> handler.handle(command));

        assertEquals("El sexo no puede estar vacío.", exception.getMessage());

        System.out.println("✔ Test 'deberiaLanzarExcepcionSiSexoEsVacio' ejecutado con éxito");
    }

    @Test
    void deberiaLanzarExcepcionSiDniNoTiene8Digitos() {

        CrearPacienteCommand command = CrearPacienteCommand.builder()
                .nombre("Ana López")
                .nacionalidad("Peruana")
                .dni("1234") // Inválido
                .tel("987654321")
                .email("ana@test.com")
                .fec_nac(new Date())
                .sexo("F")
                .build();

        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> handler.handle(command));

        assertEquals("El DNI debe tener 8 dígitos.", exception.getMessage());

        System.out.println("✔ Test 'deberiaLanzarExcepcionSiDniNoTiene8Digitos' ejecutado con éxito");
    }

    @Test
    void deberiaCrearPacienteCorrectamente() {

        // Arrange
        IDEntidad id = IDEntidad.astring("PAC123");

        CrearPacienteCommand command = CrearPacienteCommand.builder()
                .id(id)
                .nombre("Juan Perez")
                .nacionalidad("Peruana")
                .dni("12345678")
                .tel("987654321")
                .email("juan@test.com")
                .fec_nac(new Date())
                .sexo("M")
                .build();

        // El paciente que se espera guardar
        Paciente pacienteMock = new Paciente(
                id,
                "Juan Perez",
                "Peruana",
                "12345678",
                "987654321",
                Email.of("juan@test.com"),
                command.getFec_nac(),
                "M");

        when(pacienteRepository.insert(any(Paciente.class))).thenReturn(pacienteMock);

        IDEntidad resultado = handler.handle(command);

        assertEquals("PAC123", resultado.obtenerid());
        verify(pacienteRepository, times(1)).insert(any(Paciente.class));

        System.out.println("✔ Test 'deberiaCrearPacienteCorrectamente' ejecutado con éxito");
    }
}
