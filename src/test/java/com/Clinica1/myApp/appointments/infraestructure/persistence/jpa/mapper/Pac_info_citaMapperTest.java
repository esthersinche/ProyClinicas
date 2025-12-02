package com.Clinica1.myApp.appointments.infraestructure.persistence.jpa.mapper;

import com.Clinica1.myApp.appointments.domain.model.valueobjects.Pac_info_cita;
import com.Clinica1.myApp.appointments.infraestructure.persistence.jpa.entity.Pac_info_cita_embeddable;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Pac_info_citaMapperTest {

    private final Pac_info_citaMapper mapper = new Pac_info_citaMapper();

    @Test
    void toDomain_ok() {
        Pac_info_cita_embeddable emb = Pac_info_cita_embeddable.builder()
                .nomb_com_pac("Carlos Peña")
                .dni_pac("77889911")
                .build();

        Pac_info_cita result = mapper.ToDomain(emb);

        assertNotNull(result);
        assertEquals("Carlos Peña", result.nomb_com_pac());
        assertEquals("77889911", result.dni_pac());
    }

    @Test
    void toEntity_ok() {
        Pac_info_cita vo = new Pac_info_cita("Ana Silva", "44556677");

        Pac_info_cita_embeddable emb = mapper.ToEntity(vo);

        assertNotNull(emb);
        assertEquals("Ana Silva", emb.getNomb_com_pac());
        assertEquals("44556677", emb.getDni_pac());
    }
}
