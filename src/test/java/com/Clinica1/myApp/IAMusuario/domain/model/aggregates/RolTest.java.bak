package com.Clinica1.myApp.IAMusuario.domain.model.aggregates;

import com.Clinica1.myApp.IAMusuario.domain.model.valueobjects.Funcion;
import com.Clinica1.myApp.SharedKernel.IDEntidad;
import com.Clinica1.myApp.SharedKernel.Roles;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

class RolTest {

    @Test
    void crearRol_ok() {
        HashSet<Funcion> funcs = new HashSet<>();
        funcs.add(Funcion.of("crear_usuario"));
        funcs.add(Funcion.of("editar_usuario"));

        Rol rol = Rol.crearrol(Roles.Rol_Admin, funcs);

        assertNotNull(rol.getId_rol());
        assertEquals(Roles.Rol_Admin, rol.getNombrerol());
        assertEquals(2, rol.getFunciones().size());
        assertTrue(rol.getFunciones().contains(Funcion.of("crear_usuario")));
    }

    @Test
    void estapermitido_true() {
        HashSet<Funcion> funcs = new HashSet<>();
        funcs.add(Funcion.of("ver_historial"));

        Rol rol = new Rol(IDEntidad.generar(), Roles.Rol_Admin, funcs);

        assertTrue(rol.estapermitido(Funcion.of("ver_historial")));
    }

    @Test
    void estapermitido_false() {
        HashSet<Funcion> funcs = new HashSet<>();
        funcs.add(Funcion.of("ver_historial"));

        Rol rol = new Rol(IDEntidad.generar(), Roles.Rol_Admin, funcs);

        assertFalse(rol.estapermitido(Funcion.of("eliminar_paciente")));
    }

    @Test
    void estapermitidoNombre_true() {
        HashSet<Funcion> funcs = new HashSet<>();
        funcs.add(Funcion.of("buscar_paciente"));

        Rol rol = new Rol(IDEntidad.generar(), Roles.Rol_Doctor, funcs);

        assertTrue(rol.estapermitidonombre("buscar_paciente"));
    }

    @Test
    void estapermitidoNombre_false() {
        HashSet<Funcion> funcs = new HashSet<>();
        funcs.add(Funcion.of("buscar_paciente"));

        Rol rol = new Rol(IDEntidad.generar(), Roles.Rol_Doctor, funcs);

        assertFalse(rol.estapermitidonombre("no_existe"));
    }

    @Test
    void igualdad_roles_mismoId() {
        IDEntidad id = IDEntidad.generar();

        Rol r1 = new Rol(id, Roles.Rol_Admin, new HashSet<>());
        Rol r2 = new Rol(id, Roles.Rol_Admin, new HashSet<>());

        assertEquals(r1, r2);
    }

    @Test
    void desigualdad_roles_distintoId() {
        Rol r1 = new Rol(IDEntidad.generar(), Roles.Rol_Admin, new HashSet<>());
        Rol r2 = new Rol(IDEntidad.generar(), Roles.Rol_Admin, new HashSet<>());

        assertNotEquals(r1, r2);
    }
}
