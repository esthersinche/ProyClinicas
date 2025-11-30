package com.IAMusuario.entity;

import com.Clinica1.myApp.IAMusuario.infrastructure.persistence.jpa.entity.RolEntity;
import com.Clinica1.myApp.SharedKernel.IDEntidad;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class RolEntityTest {

    @Test
    void testGettersAndSetters() {
        RolEntity rol = new RolEntity();

        IDEntidad id = "12345";
        String nombre = "ADMIN";
        Set<String> funciones = new HashSet<>();
        funciones.add("CREAR_USUARIO");
        funciones.add("EDITAR_USUARIO");

        rol.setId(id);
        rol.setNombreRol(nombre);
        rol.setFunciones(funciones);

        assertEquals(id, rol.getId());
        assertEquals(nombre, rol.getNombreRol());
        assertEquals(funciones, rol.getFunciones());
        assertTrue(rol.getFunciones().contains("CREAR_USUARIO"));
        assertTrue(rol.getFunciones().contains("EDITAR_USUARIO"));
    }

    @Test
    void testDefaultConstructor() {
        RolEntity rol = new RolEntity();

        assertNull(rol.getId());
        assertNull(rol.getNombreRol());
        assertNotNull(rol.getFunciones());
        assertTrue(rol.getFunciones().isEmpty());
    }

    @Test
    void testSetFuncionesReplacesContent() {
        RolEntity rol = new RolEntity();

        Set<String> funciones = new HashSet<>();
        funciones.add("GESTION_CITA");

        rol.setFunciones(funciones);

        assertEquals(1, rol.getFunciones().size());
        assertTrue(rol.getFunciones().contains("GESTION_CITA"));
    }

    @Test
    void testSetIdRolDoesNothing() {
        RolEntity rol = new RolEntity();

        rol.setId("ABC123");
        rol.setIdRol("99999");

        assertEquals("ABC123", rol.getId());
    }

    @Test
    void testSetNomRolDoesNothing() {
        RolEntity rol = new RolEntity();

        rol.setNombreRol("USER");
        rol.setNomRol("ADMIN");

        assertEquals("USER", rol.getNombreRol());
    }

    @Test
    void testGetIdRolAndGetNomRolReturnEmptyString() {
        RolEntity rol = new RolEntity();

        assertEquals("", rol.getIdRol());
        assertEquals("", rol.getNomRol());
    }
}

