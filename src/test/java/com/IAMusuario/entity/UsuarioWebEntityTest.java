package com.IAMusuario.entity;

import com.Clinica1.myApp.IAMusuario.infrastructure.persistence.jpa.entity.EmpleadoEntity;
import com.Clinica1.myApp.IAMusuario.infrastructure.persistence.jpa.entity.UsuarioEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UsuarioWebEntityTest {

    private UsuarioEntity usuario;
    private EmpleadoEntity empleado;

    @BeforeEach
    void setUp() {
        usuario = new UsuarioEntity();
        empleado = new EmpleadoEntity();
        empleado.setIdEmp("123-EMP");
        empleado.setNombre("Luis");
        empleado.setApellido("Ramos");
    }

    @Test
    void testSetAndGetIdEmp() {
        usuario.setIdEmp("ID-001");
        assertEquals("ID-001", usuario.getIdEmp());
    }

    @Test
    void testSetAndGetEmpleado() {
        usuario.setEmpleado(empleado);
        assertEquals(empleado, usuario.getEmpleado());
        assertEquals("123-EMP", usuario.getEmpleado().getIdEmp());
    }

    @Test
    void testSetAndGetUsername() {
        usuario.setUsername("usuario123");
        assertEquals("usuario123", usuario.getUsername());
    }

    @Test
    void testSetAndGetPass() {
        usuario.setPass("passwordSeguro");
        assertEquals("passwordSeguro", usuario.getPass());
    }

    @Test
    void testSetAndGetRolEmp() {
        usuario.setRolEmp("Administrador");
        assertEquals("Administrador", usuario.getRolEmp());
    }

    @Test
    void testSetAndGetIdCli() {
        usuario.setIdCli(10);
        assertEquals(10, usuario.getIdCli());
    }

    @Test
    void testSetAndGetIdEsp() {
        usuario.setIdEsp(5);
        assertEquals(5, usuario.getIdEsp());
    }

    @Test
    void testFullEntityInitialization() {
        usuario.setIdEmp("EMP999");
        usuario.setEmpleado(empleado);
        usuario.setUsername("testUser");
        usuario.setPass("abc123");
        usuario.setRolEmp("Doctor");
        usuario.setIdCli(100);
        usuario.setIdEsp(20);

        assertAll(
                () -> assertEquals("EMP999", usuario.getIdEmp()),
                () -> assertEquals(empleado, usuario.getEmpleado()),
                () -> assertEquals("testUser", usuario.getUsername()),
                () -> assertEquals("abc123", usuario.getPass()),
                () -> assertEquals("Doctor", usuario.getRolEmp()),
                () -> assertEquals(100, usuario.getIdCli()),
                () -> assertEquals(20, usuario.getIdEsp())
        );
    }
}
