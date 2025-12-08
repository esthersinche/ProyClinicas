package com.Clinica1.myApp.appointments.domain.model.aggregates;

import com.Clinica1.myApp.SharedKernel.IDEntidad;
import com.Clinica1.myApp.appointments.domain.model.valueobjects.*;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CitaTest {

    private Pac_info_cita crearPacInfoDummy() {
        return new Pac_info_cita("Juan Pérez", "12345678");
    }

    private Doc_info_cita crearDocInfoDummy() {
        return new Doc_info_cita("Luis Ramos", "Cardiología", "C101", "12345678");
    }

    private Especialidad crearEspecialidadDummy() {
        return Especialidad.of("Dermatología");
    }


    @Test
    void testConstructorCompleto() {
        IDEntidad id = IDEntidad.generar();
        LocalDateTime inicio = LocalDateTime.now();
        LocalDateTime fin = inicio.plusHours(1);

        Pac_info_cita pac = crearPacInfoDummy();
        Doc_info_cita doc = crearDocInfoDummy();
        Especialidad espe = crearEspecialidadDummy();

        Cita cita = new Cita(
                id,
                "Dolor de cabeza",
                Estado.Asistio,
                Canal.Virtual,
                inicio,
                fin,
                IDEntidad.generar(),  // pac_id
                IDEntidad.generar(),  // doc_id
                pac,
                doc,
                espe
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
    }

    @Test
    void testFactoryMethod() {
        LocalDateTime inicio = LocalDateTime.now();
        LocalDateTime fin = inicio.plusHours(1);

        // dummies mínimos compatibles
        Paciente pac = new Paciente(
                IDEntidad.generar(),
                "Juan Pérez",
                "Peruana",
                "12345678",
                "987654321",
                new Email("correo@test.com"),
                new java.util.Date(),
                "M"
        );

        Doctor doc = new Doctor(
                IDEntidad.generar(),
                IDEntidad.generar(),
                new NombreCompleto("Luis", "Ramos"),
                "CMP123",
                "C101",
                java.util.List.of(crearEspecialidadDummy())
        );

        Especialidad espe = Especialidad.of("Neurología");

        Cita cita = Cita.crearcita(
                "Migraña",
                Canal.Presencial,
                inicio,
                fin,
                pac,
                doc,
                espe
        );

        assertNotNull(cita.getId_cita());
        assertEquals("Migraña", cita.getMotivo_cita());
        assertEquals(Estado.Pendiente, cita.getEstado_cita());
        assertEquals(Canal.Presencial, cita.getCanal_cita());
        assertEquals(espe, cita.getEspe_cita());

        // Info embebida generada por el factory
        assertEquals(pac.getNombre_com_pac(), cita.getInst_pac().nomb_com_pac());
        assertEquals(pac.getDni_pac(), cita.getInst_pac().dni_pac());

        assertEquals(doc.getNom_com_doc().completar(), cita.getInst_doctor().nombreCompleto());
        assertEquals(doc.getEspecialidades().get(0).nom_espe(), cita.getInst_doctor());
        assertEquals(doc.getConsultorio_doc(), cita.getInst_doctor().consultorio());
        assertEquals(doc.getCmp_doc(), cita.getInst_doctor().cmp());
    }

    @Test
    void testEqualsMismoIdDebeSerIgual() {
        IDEntidad id = IDEntidad.generar();
        LocalDateTime inicio = LocalDateTime.now();
        LocalDateTime fin = inicio.plusHours(1);

        Cita c1 = new Cita(
                id, "A", Estado.Pendiente, Canal.Virtual, inicio, fin,
                IDEntidad.generar(), IDEntidad.generar(),
                crearPacInfoDummy(), crearDocInfoDummy(),
                Especialidad.of("Oftalmología")
        );

        Cita c2 = new Cita(
                id, "B", Estado.Asistio, Canal.Presencial, inicio, fin,
                IDEntidad.generar(), IDEntidad.generar(),
                crearPacInfoDummy(), crearDocInfoDummy(),
                Especialidad.of("Gastroenterología")
        );

        assertEquals(c1, c2);
        assertEquals(c1.hashCode(), c2.hashCode());
    }

    @Test
    void testEqualsIdsDiferentesDebeSerDistinto() {
        LocalDateTime inicio = LocalDateTime.now();

        Cita c1 = new Cita(
                IDEntidad.generar(), "A", Estado.Pendiente, Canal.Virtual, inicio, inicio.plusHours(1),
                IDEntidad.generar(), IDEntidad.generar(),
                crearPacInfoDummy(), crearDocInfoDummy(),
                Especialidad.of("Psiquiatría")
        );

        Cita c2 = new Cita(
                IDEntidad.generar(), "A", Estado.Pendiente, Canal.Virtual, inicio, inicio.plusHours(1),
                IDEntidad.generar(), IDEntidad.generar(),
                crearPacInfoDummy(), crearDocInfoDummy(),
                Especialidad.of("Psiquiatría")
        );

        assertNotEquals(c1, c2);
    }
}
