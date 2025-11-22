package com.Clinica1.myApp.appointments.application.assembler;

import com.Clinica1.myApp.IAMusuario.domain.model.aggregates.Rol;
import com.Clinica1.myApp.IAMusuario.domain.model.valueobjects.Email;
import com.Clinica1.myApp.SharedKernel.IDEntidad;
import com.Clinica1.myApp.appointments.application.dto.CitaDto;
import com.Clinica1.myApp.appointments.application.dto.DoctorDto;
import com.Clinica1.myApp.appointments.application.dto.PacienteDto;
import com.Clinica1.myApp.appointments.domain.model.aggregates.Cita;
import com.Clinica1.myApp.appointments.domain.model.aggregates.Clinica;
import com.Clinica1.myApp.appointments.domain.model.aggregates.Doctor;
import com.Clinica1.myApp.appointments.domain.model.aggregates.Paciente;
import com.Clinica1.myApp.appointments.domain.model.valueobjects.*;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CitaAssemblerTest {

    private final CitaAssembler assembler = new CitaAssembler();

    private Paciente crearPaciente() {
        return new Paciente(
                IDEntidad.generar(),
                "Juan Pérez",
                "Peruana",
                "12345678",
                "987654321",
                new Email("paciente@mail.com"),
                new Date(),
                "Masculino"
        );
    }

    private Doctor crearDoctor() {
        return new Doctor(
                IDEntidad.generar(),
                "Luis",
                "Ramos",
                "987654321",
                new Email("doctor@mail.com"),
                Rol.doctor,
                "CMP001",
                "C101",
                List.of(Especialidad.of("Cardiología"), Especialidad.of("Cirugía"))
        );
    }

    private Clinica crearClinica() {
        return new Clinica(
                IDEntidad.generar(),
                "Clínica Vida",
                new Direccion("Av Siempre Viva", "Calle Falsa", "Lima", "Perú"),
                List.of(),
                List.of()
        );
    }

    @Test
    void testToPacienteDto() {
        Paciente paciente = crearPaciente();

        PacienteDto dto = assembler.toPacienteDto(paciente);

        assertNotNull(dto);
        assertEquals(paciente.getNombre_com_pac(), dto.nombre());
        assertEquals(paciente.getNacionalidad_pac(), dto.nacionalidad());
        assertEquals(paciente.getDni_pac(), dto.dni());
        assertEquals(paciente.getTel_pac(), dto.telefono());
        assertEquals(paciente.getEmail_pac().email_valor(), dto.email());
    }

    @Test
    void testToPacienteDtoNull() {
        assertNull(assembler.toPacienteDto(null));
    }

    @Test
    void testToDoctorDto() {
        Doctor doctor = crearDoctor();

        DoctorDto dto = assembler.toDoctorDto(doctor);

        assertNotNull(dto);
        assertEquals("Luis Ramos", dto.nombreCompleto());
        assertEquals("CMP001", dto.cmp());
        assertEquals("C101", dto.consultorio());
        assertEquals(2, dto.especialidades().size());
        assertTrue(dto.especialidades().contains("Cardiología"));
        assertTrue(dto.especialidades().contains("Cirugía"));
    }

    @Test
    void testToDoctorDtoNull() {
        assertNull(assembler.toDoctorDto(null));
    }

    @Test
    void testToCitaDto() {
        Paciente paciente = crearPaciente();
        Doctor doctor = crearDoctor();
        Clinica clinica = crearClinica();
        Direccion dir = new Direccion("Av A", "Calle B", "Lima", "Perú");
        Especialidad esp = Especialidad.of("Neurología");

        LocalDateTime inicio = LocalDateTime.now();
        LocalDateTime fin = inicio.plusHours(1);

        Cita cita = new Cita(
                IDEntidad.generar(),
                "Dolor de cabeza",
                Estado.Asistio,
                Canal.Virtual,
                inicio,
                fin,
                paciente,
                doctor,
                esp,
                clinica,
                dir
        );

        CitaDto dto = assembler.toDto(cita);

        assertNotNull(dto);
        assertEquals("Dolor de cabeza", dto.motivo());
        assertEquals("Asistio", dto.estado());
        assertEquals("Virtual", dto.canal());
        assertEquals(inicio, dto.inicio());
        assertEquals(fin, dto.fin());
        assertEquals("Clínica Vida", dto.nombreClinica());
        assertEquals("Neurología", dto.especialidad());

        assertNotNull(dto.paciente());
        assertNotNull(dto.doctor());

        assertEquals("Juan Pérez", dto.paciente().nombre());
        assertEquals("Luis Ramos", dto.doctor().nombreCompleto());
    }

    @Test
    void testToCitaDtoNull() {
        assertNull(assembler.toDto(null));
    }
}

