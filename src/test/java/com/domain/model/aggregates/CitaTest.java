package com.domain.model.aggregates;

import com.Clinica1.myApp.SharedKernel.IDEntidad;
import com.Clinica1.myApp.appointments.domain.model.aggregates.Cita;
import com.Clinica1.myApp.appointments.domain.model.aggregates.Clinica;
import com.Clinica1.myApp.appointments.domain.model.aggregates.Doctor;
import com.Clinica1.myApp.appointments.domain.model.aggregates.Paciente;
import com.Clinica1.myApp.appointments.domain.model.valueobjects.Canal;
import com.Clinica1.myApp.appointments.domain.model.valueobjects.Direccion;
import com.Clinica1.myApp.appointments.domain.model.valueobjects.Especialidad;
import com.Clinica1.myApp.appointments.domain.model.valueobjects.Estado;

import com.Clinica1.myApp.IAMusuario.domain.model.valueobjects.Email;
import com.Clinica1.myApp.IAMusuario.domain.model.aggregates.Rol;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CitaTest {

    private Paciente crearPacienteDummy() {
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

    private Doctor crearDoctorDummy() {
        return new Doctor(
                IDEntidad.generar(),
                "Luis",
                "Ramos",
                "999999999",
                new Email("doctor@mail.com"),
                Rol.doctor,
                "CMP123",
                "C101",
                List.of(Especialidad.of("Cardiología"))
        );
    }

    private Clinica crearClinicaDummy() {
        return new Clinica(
                IDEntidad.generar(),
                "Clinica Luz Vida",
                new Direccion("Av. Siempre Viva", "Calle Falsa", "Lima", "Perú"),
                List.of(),
                List.of()
        );
    }

    @Test
    void testConstructorCompleto() {
        IDEntidad id = IDEntidad.generar();
        LocalDateTime inicio = LocalDateTime.now();
        LocalDateTime fin = inicio.plusHours(1);

        Paciente pac = crearPacienteDummy();
        Doctor doc = crearDoctorDummy();
        Clinica cli = crearClinicaDummy();
        Direccion dir = new Direccion("Av A", "Calle B", "Distrito C", "Perú");
        Especialidad espe = Especialidad.of("Dermatología");

        Cita cita = new Cita(
                id,
                "Dolor de cabeza",
                Estado.Asistio,
                Canal.Virtual,
                inicio,
                fin,
                pac,
                doc,
                espe,
                cli,
                dir
        );

        assertEquals(id, cita.getId_cita());
        assertEquals("Dolor de cabeza", cita.getMotivo_cita());
        assertEquals(Estado.Asistio, cita.getEstado_cita());
        assertEquals(Canal.Virtual, cita.getCanal_cita());
        assertEquals(inicio, cita.getInicio_cita());
        assertEquals(fin, cita.getFin_cita());
        assertEquals(pac, cita.getInst_pac());
        assertEquals(doc, cita.getInst_doctor());
        assertEquals(espe, cita.getEspe_cita());
        assertEquals(cli, cita.getInst_clin());
        assertEquals(dir, cita.getDir_clin_cita());
    }

    @Test
    void testFactoryMethod() {
        LocalDateTime inicio = LocalDateTime.now();
        LocalDateTime fin = inicio.plusHours(1);

        Paciente pac = crearPacienteDummy();
        Doctor doc = crearDoctorDummy();
        Clinica cli = crearClinicaDummy();
        Direccion dir = new Direccion("Av X", "Calle Y", "Miraflores", "Perú");
        Especialidad espe = Especialidad.of("Neurología");

        Cita cita = Cita.crearcita(
                "Migraña",
                Canal.Presencial,
                inicio,
                fin,
                pac,
                doc,
                espe,
                cli,
                dir
        );

        assertNotNull(cita.getId_cita());
        assertEquals("Migraña", cita.getMotivo_cita());
        assertEquals(Estado.Pendiente, cita.getEstado_cita());
        assertEquals(Canal.Presencial, cita.getCanal_cita());
        assertEquals(pac, cita.getInst_pac());
        assertEquals(doc, cita.getInst_doctor());
        assertEquals(espe, cita.getEspe_cita());
        assertEquals(cli, cita.getInst_clin());
        assertEquals(dir, cita.getDir_clin_cita());
    }

    @Test
    void testEqualsMismoIdDebeSerIgual() {
        IDEntidad id = IDEntidad.generar();
        LocalDateTime inicio = LocalDateTime.now();
        LocalDateTime fin = inicio.plusHours(1);

        Cita c1 = new Cita(id, "A", Estado.Pendiente, Canal.Virtual, inicio, fin,
                crearPacienteDummy(), crearDoctorDummy(), Especialidad.of("Oftalmología"),
                crearClinicaDummy(), new Direccion("A", "B", "C", "Perú"));

        Cita c2 = new Cita(id, "B", Estado.Asistio, Canal.Presencial, inicio, fin,
                crearPacienteDummy(), crearDoctorDummy(), Especialidad.of("Gastroenterología"),
                crearClinicaDummy(), new Direccion("X", "Y", "Z", "Perú"));

        assertEquals(c1, c2);
        assertEquals(c1.hashCode(), c2.hashCode());
    }

    @Test
    void testEqualsIdsDiferentesDebeSerDistinto() {
        LocalDateTime inicio = LocalDateTime.now();

        Cita c1 = new Cita(
                IDEntidad.generar(), "A", Estado.Pendiente, Canal.Virtual, inicio, inicio.plusHours(1),
                crearPacienteDummy(), crearDoctorDummy(), Especialidad.of("Psiquiatría"),
                crearClinicaDummy(), new Direccion("A", "B", "C", "Perú")
        );

        Cita c2 = new Cita(
                IDEntidad.generar(), "A", Estado.Pendiente, Canal.Virtual, inicio, inicio.plusHours(1),
                crearPacienteDummy(), crearDoctorDummy(), Especialidad.of("Psiquiatría"),
                crearClinicaDummy(), new Direccion("A", "B", "C", "Perú")
        );

        assertNotEquals(c1, c2);
    }
}
