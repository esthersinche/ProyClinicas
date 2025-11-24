package com.Clinica1.myApp.appointments.domain.model.aggregates;

import com.Clinica1.myApp.SharedKernel.IDEntidad;
import com.Clinica1.myApp.appointments.domain.model.aggregates.Clinica;
import com.Clinica1.myApp.appointments.domain.model.aggregates.Doctor;
import com.Clinica1.myApp.appointments.domain.model.aggregates.Paciente;
import com.Clinica1.myApp.appointments.domain.model.valueobjects.Direccion;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ClinicaTest {

    @Test
    void testConstructor_AsignaValoresCorrectamente() {
        IDEntidad id = IDEntidad.generar();
        String nombre = "Clínica San José";
        Direccion direccion = new Direccion("Av. Lima", "Calle 1", "Miraflores", "Perú");

        Doctor d1 = new Doctor("Luis", "Ramos", null);
        Doctor d2 = new Doctor("Ana", "Salazar", null);

        Paciente p1 = new Paciente("Juan", "Perez", "12345678");
        Paciente p2 = new Paciente("Maria", "Torres", "87654321");

        List<Doctor> doctores = List.of(d1, d2);
        List<Paciente> pacientes = List.of(p1, p2);

        Clinica clinica = new Clinica(id, nombre, direccion, doctores, pacientes);

        assertEquals(id, clinica.getId_cli());
        assertEquals(nombre, clinica.getNom_clin());
        assertEquals(direccion, clinica.getDir_clin());
        assertEquals(doctores, clinica.getDoctorescli());
        assertEquals(pacientes, clinica.getPacientescli());
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
    void testGetters_ListasInmutablesReferencia() {
        Doctor d1 = new Doctor("Luis", "Ramos", null);
        Paciente p1 = new Paciente("Juan", "Perez", "12345678");

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

