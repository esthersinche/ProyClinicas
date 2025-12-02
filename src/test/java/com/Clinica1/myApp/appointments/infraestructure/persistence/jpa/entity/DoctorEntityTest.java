package com.Clinica1.myApp.appointments.infraestructure.persistence.jpa.entity;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DoctorEntityTest {

    @Test
    void builder_ok() {
        NombreCompletoEmbeddable nombre = NombreCompletoEmbeddable.builder()
                .nombre("Juan")
                .apellido("Pérez")
                .build();

        EspecialidadEmbeddable esp = new EspecialidadEmbeddable("Cardiología");

        DoctorEntity doc = DoctorEntity.builder()
                .id_doc("DOC1")
                .id_empleado_doc("EMP100")
                .nom_com_doc(nombre)
                .cmp_doc("CMP123")
                .consultorio_doc("C201")
                .especialidades(List.of(esp))
                .build();

        assertEquals("DOC1", doc.getId_doc());
        assertEquals("EMP100", doc.getId_empleado_doc());
        assertEquals("CMP123", doc.getCmp_doc());
        assertEquals("C201", doc.getConsultorio_doc());
        assertEquals("Juan", doc.getNom_com_doc().getNombre());
        assertEquals(1, doc.getEspecialidades().size());
    }

    @Test
    void noArgs_ok() {
        DoctorEntity doc = new DoctorEntity();
        assertNotNull(doc);
    }

    @Test
    void allArgs_ok() {
        NombreCompletoEmbeddable nombre = new NombreCompletoEmbeddable("Ana", "Lopez");
        EspecialidadEmbeddable esp = new EspecialidadEmbeddable("Neurología");

        DoctorEntity doc = new DoctorEntity(
                "DOC2",
                "EMP200",
                nombre,
                "CMP456",
                "B115",
                List.of(esp));

        assertEquals("DOC2", doc.getId_doc());
        assertEquals("CMP456", doc.getCmp_doc());
        assertEquals("B115", doc.getConsultorio_doc());
        assertEquals("Ana", doc.getNom_com_doc().getNombre());
    }
}
