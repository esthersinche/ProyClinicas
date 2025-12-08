package com.Clinica1.myApp.SharedKernel;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

class RolesTest {

    @Test
    void deberiaContenerTresRoles() {
        Roles[] roles = Roles.values();

        assertEquals(3, roles.length);
        assertTrue(List.of(roles).contains(Roles.Rol_Admin));
        assertTrue(List.of(roles).contains(Roles.Rol_Doctor));
        assertTrue(List.of(roles).contains(Roles.Rol_Recepcionista));
    }

    @Test
    void deberiaConvertirseDesdeStringCorrectamente() {
        assertEquals(Roles.Rol_Admin, Roles.valueOf("Rol_Admin"));
        assertEquals(Roles.Rol_Doctor, Roles.valueOf("Rol_Doctor"));
        assertEquals(Roles.Rol_Recepcionista, Roles.valueOf("Rol_Recepcionista"));
    }

    @Test
    void deberiaLanzarErrorSiElValorEsInvalido() {
        assertThrows(IllegalArgumentException.class, () -> Roles.valueOf("ADMIN"));
        assertThrows(IllegalArgumentException.class, () -> Roles.valueOf("Doctor"));
        assertThrows(IllegalArgumentException.class, () -> Roles.valueOf("Recep"));
    }
}
