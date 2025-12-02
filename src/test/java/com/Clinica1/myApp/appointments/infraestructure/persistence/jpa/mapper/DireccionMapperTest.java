package com.Clinica1.myApp.appointments.infraestructure.persistence.jpa.mapper;

import com.Clinica1.myApp.appointments.domain.model.valueobjects.Direccion;
import com.Clinica1.myApp.appointments.infraestructure.persistence.jpa.entity.DireccionEmbeddable;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DireccionMapperTest {

    @Test
    void toEmbeddable_ok() {
        Direccion direccion = Direccion.of(
                "Av. Lima",
                "Chorrillos",
                "Lima",
                "Lima");

        DireccionEmbeddable emb = DireccionMapper.toEmbeddable(direccion);

        assertEquals("Av. Lima", emb.getAvenida());
        assertEquals("Chorrillos", emb.getDistrito());
        assertEquals("Lima", emb.getDepartamento());
        assertEquals("Lima", emb.getProvincia());
    }

    @Test
    void toEmbeddable_null_ok() {
        assertNull(DireccionMapper.toEmbeddable(null));
    }

    @Test
    void toDomain_ok() {
        DireccionEmbeddable emb = DireccionEmbeddable.builder()
                .avenida("Av. Arequipa")
                .distrito("Miraflores")
                .departamento("Lima")
                .provincia("Lima")
                .build();

        Direccion dir = DireccionMapper.toDomain(emb);

        assertEquals("Av. Arequipa", dir.avenida());
        assertEquals("Miraflores", dir.distrito());
        assertEquals("Lima", dir.departamento());
        assertEquals("Lima", dir.provincia());
    }

    @Test
    void toDomain_null_ok() {
        assertNull(DireccionMapper.toDomain(null));
    }
}
