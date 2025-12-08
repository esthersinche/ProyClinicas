package com.Clinica1.myApp.appointments.infraestructure.persistence.jpa.mapper;

import com.Clinica1.myApp.appointments.domain.model.valueobjects.Doc_info_cita;
import com.Clinica1.myApp.appointments.infraestructure.persistence.jpa.entity.Doc_info_cita_embeddable;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Doc_info_citaMapperTest {

    private final Doc_info_citaMapper mapper = new Doc_info_citaMapper();

    @Test
    void toDomain_ok() {
        Doc_info_cita_embeddable emb = new Doc_info_cita_embeddable(
                "Dr Juan",
                "Cardiología",
                "C21",
                "CMP99999");

        Doc_info_cita vo = mapper.ToDomain(emb);

        assertEquals("Dr Juan", vo.nombreCompleto());
        assertEquals("Cardiología", vo.especialidad());
        assertEquals("C21", vo.consultorio());
        assertEquals("CMP99999", vo.cmp());
    }

    @Test
    void toEntity_ok() {
        Doc_info_cita vo = new Doc_info_cita("Ana", "Dermatología", "B11", "CMP55555");

        Doc_info_cita_embeddable emb = mapper.ToEntity(vo);

        assertEquals("Ana", emb.getNombre_doc());
        assertEquals("Dermatología", emb.getEspe_doc());
        assertEquals("CMP55555", emb.getCmp_doc());
        assertEquals("B11", emb.getConsult_doc());
    }
}
