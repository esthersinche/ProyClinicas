package com.Clinica1.myApp.appointments.infraestructure.persistence.jpa.mapper;

import com.Clinica1.myApp.appointments.domain.model.valueobjects.NombreCompleto;
import com.Clinica1.myApp.appointments.infraestructure.persistence.jpa.entity.NombreCompletoEmbeddable;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NombreCompletoMapperTest {

    private final NombreCompletoMapper mapper = new NombreCompletoMapper();

    @Test
    void toDomain_ok() {
        NombreCompletoEmbeddable emb = NombreCompletoEmbeddable.builder()
                .nombre("Luis")
                .apellido("Torres")
                .build();

        NombreCompleto result = mapper.ToDomain(emb);

        assertNotNull(result);
        assertEquals("Luis", result.nombre());
        assertEquals("Torres", result.apellido());
    }

    @Test
    void toEntity_ok() {
        NombreCompleto vo = new NombreCompleto("Ana", "Ramos");

        NombreCompletoEmbeddable emb = mapper.ToEmbeddable(vo);

        assertNotNull(emb);
        assertEquals("Ana", emb.getNombre());
        assertEquals("Ramos", emb.getApellido());
    }
}
