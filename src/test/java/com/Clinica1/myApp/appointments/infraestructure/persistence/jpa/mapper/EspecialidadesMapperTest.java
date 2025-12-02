package com.Clinica1.myApp.appointments.infraestructure.persistence.jpa.mapper;

import com.Clinica1.myApp.appointments.domain.model.valueobjects.Especialidad;
import com.Clinica1.myApp.appointments.infraestructure.persistence.jpa.entity.EspecialidadEmbeddable;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EspecialidadesMapperTest {

    private final EspecialidadesMapper mapper = new EspecialidadesMapper();

    @Test
    void toDomain_ok() {
        EspecialidadEmbeddable emb = EspecialidadEmbeddable.builder()
                .nom_espe("Cardiología")
                .build();

        Especialidad result = mapper.ToDomain(emb);

        assertNotNull(result);
        assertEquals("Cardiología", result.nom_espe());
    }

    @Test
    void toEntity_ok() {
        Especialidad espe = new Especialidad("Neurología");

        EspecialidadEmbeddable emb = mapper.ToEntity(espe);

        assertNotNull(emb);
        assertEquals("Neurología", emb.getNom_espe());
    }
}
