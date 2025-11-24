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
        NombreCompleto nombre = new NombreCompleto("Luis", "Ramos");
        List<Especialidad> especialidades = List.of(new Especialidad("Cardiología"));

        Doctor doctor = new Doctor(
                idEmpleado,
                idDoctor,
                nombre,
                "CMP123",
                "Consultorio A",
                especialidades
        );

        assertEquals(idEmpleado, doctor.getId_empleado_doc());
        assertEquals(idDoctor, doctor.getId_doc());
        assertEquals("Luis", doctor.getNom_com_doc().nombre());
        assertEquals("Ramos", doctor.getNom_com_doc().apellido());
        assertEquals("CMP123", doctor.getCmp_doc());
        assertEquals("Consultorio A", doctor.getConsultorio_doc());
        assertEquals(1, doctor.getEspecialidades().size());
    }

    @Test
    void testFactoryMethod() {
        IDEntidad idEmpleado = IDEntidad.generar();
        NombreCompleto nombre = new NombreCompleto("Ana", "Medina");
        List<Especialidad> especialidades = List.of(new Especialidad("Pediatría"));

        Doctor doctor = Doctor.creardoc(
                idEmpleado,
                nombre,
                "CMP999",
                "Consultorio B",
                especialidades
        );

        assertNotNull(doctor.getId_doc()); // generado por la factory
        assertEquals(idEmpleado, doctor.getId_empleado_doc());
        assertEquals("Ana", doctor.getNom_com_doc().nombre());
        assertEquals("Medina", doctor.getNom_com_doc().apellido());
        assertEquals("CMP999", doctor.getCmp_doc());
        assertEquals("Consultorio B", doctor.getConsultorio_doc());
        assertEquals(1, doctor.getEspecialidades().size());
    }


    @Test
    void testEqualsUsaSoloIdDoc() {
        IDEntidad idEmpleado = IDEntidad.generar();
        IDEntidad idDoctor = IDEntidad.generar();

        NombreCompleto nombre = new NombreCompleto("Juan", "Perez");

        Doctor d1 = new Doctor(idEmpleado, idDoctor, nombre, "CMP1", "C1", List.of());
        Doctor d2 = new Doctor(idEmpleado, idDoctor, nombre, "CMP1", "C1", List.of());

        assertEquals(d1, d2);
    }
}
