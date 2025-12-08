package com.Clinica1.myApp.IAMusuario.infrastructure.persistence.jpa.mapper;

import com.Clinica1.myApp.IAMusuario.domain.model.aggregates.Rol;
import com.Clinica1.myApp.IAMusuario.domain.model.valueobjects.Funcion;
import com.Clinica1.myApp.IAMusuario.infrastructure.persistence.jpa.entity.FuncionEmbeddable;
import com.Clinica1.myApp.IAMusuario.infrastructure.persistence.jpa.entity.RolEntity;
import com.Clinica1.myApp.SharedKernel.IDEntidad;
import com.Clinica1.myApp.SharedKernel.Roles;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

class RolMapperTest {

    private final RolMapper mapper = new RolMapper();

    @Test
    void ToEntity_convierteCorrectamente() {

        HashSet<Funcion> funciones = new HashSet<>();
        funciones.add(Funcion.of("Buscar"));
        funciones.add(Funcion.of("Atender"));

        Rol rol = new Rol(IDEntidad.generar(), Roles.Rol_Doctor, funciones);

        RolEntity entity = mapper.ToEntity(rol);

        assertNotNull(entity);
        assertEquals(rol.getId_rol().obtenerid(), entity.getId());
        assertEquals("Rol_Doctor", entity.getNombreRol());

        // 🔥 NO USAMOS contains() → usamos anyMatch comparando el nombre
        assertTrue(
                entity.getFunciones().stream()
                        .anyMatch(f -> f.getNombre_fun().equals("Buscar")));

        assertTrue(
                entity.getFunciones().stream()
                        .anyMatch(f -> f.getNombre_fun().equals("Atender")));
    }

    @Test
    void ToDomain_convierteCorrectamente() {

        HashSet<FuncionEmbeddable> funcs = new HashSet<>();
        funcs.add(new FuncionEmbeddable("Buscar"));
        funcs.add(new FuncionEmbeddable("Atender"));

        RolEntity entity = RolEntity.builder()
                .id(IDEntidad.generar().obtenerid())
                .nombreRol("Rol_Doctor")
                .funciones(funcs)
                .build();

        Rol rol = mapper.ToDomain(entity);

        assertNotNull(rol);
        assertEquals("Rol_Doctor", rol.getNombrerol().toString());

        assertTrue(
                rol.getFunciones().stream()
                        .anyMatch(f -> f.getNombre_fun().equals("Buscar")));

        assertTrue(
                rol.getFunciones().stream()
                        .anyMatch(f -> f.getNombre_fun().equals("Atender")));
    }

    @Test
    void conversionBidireccional_mantieneInformacion() {

        HashSet<Funcion> funciones = new HashSet<>();
        funciones.add(Funcion.of("Buscar"));
        funciones.add(Funcion.of("Atender"));

        Rol original = new Rol(IDEntidad.generar(), Roles.Rol_Doctor, funciones);

        RolEntity entity = mapper.ToEntity(original);
        Rol convertido = mapper.ToDomain(entity);

        assertEquals(original.getNombrerol(), convertido.getNombrerol());

        // Validación por nombre
        assertTrue(
                convertido.getFunciones().stream()
                        .anyMatch(f -> f.getNombre_fun().equals("Buscar")));

        assertTrue(
                convertido.getFunciones().stream()
                        .anyMatch(f -> f.getNombre_fun().equals("Atender")));
    }
}
