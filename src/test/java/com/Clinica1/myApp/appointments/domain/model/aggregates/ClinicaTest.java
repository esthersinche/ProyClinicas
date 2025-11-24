package com.Clinica1.myApp.appointments.domain.model.aggregates;

import com.Clinica1.myApp.SharedKernel.IDEntidad;
import com.Clinica1.myApp.appointments.domain.model.valueobjects.Direccion;
import com.Clinica1.myApp.appointments.domain.model.valueobjects.Especialidad;
import com.Clinica1.myApp.appointments.domain.model.valueobjects.NombreCompleto;
import com.Clinica1.myApp.appointments.domain.model.valueobjects.Email;

import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ClinicaTest {

    @Test
    void testConstructor_AsignaValoresCorrectamente() {
        IDEntidad id = IDEntidad.generar();
        String nombre = "Clínica San José";
        Direccion direccion = new Direccion("Av. Lima", "Calle 1", "Miraflores", "Perú");

        Doctor d1 = new Doctor(
                IDEntidad.generar(),
                IDEntidad.generar(),
                new NombreCompleto("Luis", "Ramos"),
                "CMP1",
                "C-01",
                List.of(new Especialidad("Cardiología"))
        );

        Doctor d2 = new Doctor(
                IDEntidad.generar(),
                IDEntidad.generar(),
                new NombreCompleto("Ana", "Salazar"),
                "CMP2",
                "C-02",
                List.of(new Especialidad("Neurología"))
        );

        Paciente p1 = new Paciente(
                IDEntidad.generar(),
                "Juan Perez",
                "Peruana",
                "12345678",
                "987654321",
                new Email("juan@mail.com"),
                new Date(),
                "M"
        );

        Paciente p2 = new Paciente(
                IDEntidad.generar(),
                "Maria Torres",
                "Peruana",
                "87654321",
                "912345678",
                new Email("maria@mail.com"),
                new Date(),
                "F"
        );

        Clinica clinica = new Clinica(id, nombre, direccion, List.of(d1, d2), List.of(p1, p2));

        assertEquals(id, clinica.getId_cli());
        assertEquals(nombre, clinica.getNom_clin());
        assertEquals(direccion, clinica.getDir_clin());
        assertEquals(List.of(d1, d2), clinica.getDoctorescli());
        assertEquals(List.of(p1, p2), clinica.getPacientescli());
    }

    @Test
    void testEquals_MismoID_True() {
        IDEntidad id = IDEntidad.generar();

        Clinica c1 = new Clinica(id, "Clinica A", null, null, null);
        Clinica c2 = new Clinica(id, "Otra Clínica", null, null, null);

        assertEquals(c1, c2);
        assertEquals(c1.hashCode(), c2.hashCode());
    }

    @Test
    void testEquals_DistintoID_False() {
        Clinica c1 = new Clinica(IDEntidad.generar(), "Clínica A", null, null, null);
        Clinica c2 = new Clinica(IDEntidad.generar(), "Clínica B", null, null, null);

        assertNotEquals(c1, c2);
        assertNotEquals(c1.hashCode(), c2.hashCode());
    }

    @Test
    void testGetters_ListasNoNulas() {
        Doctor d1 = new Doctor(
                IDEntidad.generar(),
                IDEntidad.generar(),
                new NombreCompleto("Luis", "Ramos"),
                "CMP1",
                "C-01",
                List.of(new Especialidad("Dermatología"))
        );

        Paciente p1 = new Paciente(
                IDEntidad.generar(),
                "Juan Perez",
                "Peruana",
                "12345678",
                "987654321",
                new Email("juan@mail.com"),
                new Date(),
                "M"
        );

        Clinica clinica = new Clinica(
                IDEntidad.generar(),
                "Clinica X",
                new Direccion("Av", "Calle", "Distrito", "Perú"),
                List.of(d1),
                List.of(p1)
        );

        assertEquals(1, clinica.getDoctorescli().size());
        assertEquals(1, clinica.getPacientescli().size());
        assertEquals(d1, clinica.getDoctorescli().get(0));
        assertEquals(p1, clinica.getPacientescli().get(0));
    }
}

