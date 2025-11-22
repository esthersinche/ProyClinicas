package com.domain.model.aggregates;

import com.Clinica1.myApp.IAMusuario.domain.model.aggregates.Rol;
import com.Clinica1.myApp.IAMusuario.domain.model.valueobjects.Email;
import com.Clinica1.myApp.SharedKernel.IDEntidad;
import com.Clinica1.myApp.appointments.domain.model.aggregates.Doctor;
import com.Clinica1.myApp.appointments.domain.model.valueobjects.Especialidad;

import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DoctorTest {

    @Test
    void testConstructorCompleto() {
        IDEntidad id = IDEntidad.generar();
        Email email = new Email("doctor@mail.com");
        List<Especialidad> especialidades = List.of(new Especialidad("Cardiología"));

        Doctor doctor = new Doctor(
                id,
                "Luis",
                "Ramos",
                "999888777",
                email,
                Rol.doctor,
                "CMP123",
                "Consultorio A",
                especialidades
        );

        assertEquals(id, doctor.getId_emp());
        assertEquals("Luis", doctor.getNombre());
        assertEquals("Ramos", doctor.getApellido());
        assertEquals("999888777", doctor.getTelefono());
        assertEquals(email, doctor.getEmail());
        assertEquals("CMP123", doctor.getCmp_doc());
        assertEquals("Consultorio A", doctor.getConsultorio_doc());
        assertEquals(1, doctor.getEspecialidades().size());
    }

    @Test
    void testFactoryMethod() {
        Email email = new Email("doc@mail.com");
        List<Especialidad> especialidades = List.of(new Especialidad("Pediatría"));

        Doctor doctor = Doctor.creardoc(
                "Ana",
                "Medina",
                "999123456",
                email,
                Rol.doctor,
                "CMP999",
                "Consul B",
                especialidades
        );

        assertNotNull(doctor.getId_emp());
        assertEquals("Ana", doctor.getNombre());
        assertEquals("Medina", doctor.getApellido());
        assertEquals("CMP999", doctor.getCmp_doc());
        assertEquals("Consul B", doctor.getConsultorio_doc());
        assertEquals(1, doctor.getEspecialidades().size());
    }

    @Test
    void testEqualsEnEmpleadoFunciona() {
        IDEntidad id = IDEntidad.generar();

        Doctor d1 = new Doctor(id, "Juan", "Perez", "900111222",
                new Email("jp@mail.com"), Rol.doctor,
                "CMP1", "C1", List.of());

        Doctor d2 = new Doctor(id, "Juan", "Perez", "900111222",
                new Email("jp@mail.com"), Rol.doctor,
                "CMP1", "C1", List.of());

        assertEquals(d1, d2);
    }
}
