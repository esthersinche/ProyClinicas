package com.Clinica1.myApp.appointments.domain.model.aggregates;

import com.Clinica1.myApp.SharedKernel.IDEntidad;
import com.Clinica1.myApp.appointments.domain.model.valueobjects.Especialidad;
import com.Clinica1.myApp.appointments.domain.model.valueobjects.NombreCompleto;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class DoctorTest {

    @Test
    void testConstructorCompleto() {
        IDEntidad idEmpleado = IDEntidad.generar();
        IDEntidad idDoctor = IDEntidad.generar();
        NombreCompleto nombre = new NombreCompleto("Juan", "Pérez");

        Especialidad esp1 = new Especialidad("Cardiología");
        Especialidad esp2 = new Especialidad("Medicina Interna");

        List<Especialidad> especialidades = List.of(esp1, esp2);

        Doctor doctor = new Doctor(
                idEmpleado,
                idDoctor,
                nombre,
                "CMP12345",
                "Consultorio 5",
                especialidades
        );

        assertEquals(idEmpleado, doctor.getId_empleado_doc());
        assertEquals(idDoctor, doctor.getId_doc());
        assertEquals(nombre, doctor.getNom_com_doc());
        assertEquals("CMP12345", doctor.getCmp_doc());
        assertEquals("Consultorio 5", doctor.getConsultorio_doc());
        assertEquals(especialidades, doctor.getEspecialidades());
    }

    @Test
    void testEqualsDebeCompararSoloPorIdDoctor() {
        IDEntidad idDoctor = IDEntidad.generar();

        Doctor d1 = new Doctor(
                IDEntidad.generar(),
                idDoctor,
                new NombreCompleto("Luis", "Ramos"),
                "CMP111",
                "Consultorio 1",
                List.of(new Especialidad("Pediatría"))
        );

        Doctor d2 = new Doctor(
                IDEntidad.generar(),
                idDoctor,
                new NombreCompleto("Otro", "Nombre"),
                "CMP999",
                "Consultorio 9",
                List.of(new Especialidad("Cirugía"))
        );

        assertEquals(d1, d2);
        assertEquals(d1.hashCode(), d2.hashCode());
    }


    @Test
    void testEqualsDebeSerFalsoSiIdDoctorEsDistinto() {
        Doctor d1 = new Doctor(
                IDEntidad.generar(),
                IDEntidad.generar(),
                new NombreCompleto("Ana", "Torres"),
                "CMP222",
                "Consultorio 2",
                List.of(new Especialidad("Dermatología"))
        );

        Doctor d2 = new Doctor(
                IDEntidad.generar(),
                IDEntidad.generar(),
                new NombreCompleto("Ana", "Torres"),
                "CMP222",
                "Consultorio 2",
                List.of(new Especialidad("Dermatología"))
        );

        assertNotEquals(d1, d2);
    }

    @Test
    void equals_false_si_null_o_de_otra_clase() {
        Doctor doctor = new Doctor(
                IDEntidad.generar(),
                IDEntidad.generar(),
                new NombreCompleto("Mario", "Lopez"),
                "CMP333",
                "Consultorio 3",
                List.of(new Especialidad("Neurología"))
        );

        assertNotEquals(doctor, null);
        assertNotEquals(doctor, "no soy doctor");
    }
}
