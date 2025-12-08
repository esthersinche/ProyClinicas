package com.Clinica1.myApp.IAMusuario.infrastructure.persistence.jpa.entity;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class RolEntityTest {

    @Test
    void constructorYGetters_funcionanCorrectamente() {
        Set<FuncionEmbeddable> funciones = new HashSet<>();
        funciones.add(new FuncionEmbeddable("Atender"));
        funciones.add(new FuncionEmbeddable("Buscar"));

        RolEntity rol = new RolEntity(
                "ROL001",
                "Doctor",
                funciones);

        assertEquals("ROL001", rol.getId());
        assertEquals("Doctor", rol.getNombreRol());
        assertEquals(2, rol.getFunciones().size());
    }

    @Test
    void builder_creaInstanciaCorrecta() {
        Set<FuncionEmbeddable> funciones = new HashSet<>();
        funciones.add(new FuncionEmbeddable("Registrar"));

        RolEntity rol = RolEntity.builder()
                .id("ROL999")
                .nombreRol("Admin")
                .funciones(funciones)
                .build();

        assertEquals("ROL999", rol.getId());
        assertEquals("Admin", rol.getNombreRol());

        assertTrue(
                rol.getFunciones().stream()
                        .anyMatch(f -> f.getNombre_fun().equalsIgnoreCase("Registrar")));
    }

    @Test
    void funciones_esSetMutableInternamente() {
        RolEntity rol = new RolEntity();
        assertNotNull(rol.getFunciones());
        rol.getFunciones().add(new FuncionEmbeddable("Editar"));
        assertEquals(1, rol.getFunciones().size());
    }
}
