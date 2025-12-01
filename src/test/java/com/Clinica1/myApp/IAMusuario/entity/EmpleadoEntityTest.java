package com.Clinica1.myApp.IAMusuario.entity;

import com.Clinica1.myApp.IAMusuario.infrastructure.persistence.jpa.entity.EmpleadoEntity;
import com.Clinica1.myApp.IAMusuario.infrastructure.persistence.jpa.entity.RolEntity;
import com.Clinica1.myApp.SharedKernel.IDEntidad;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmpleadoEntityTest {

    @Test
    void testGettersAndSetters() {
        EmpleadoEntity empleado = new EmpleadoEntity();

        IDEntidad id = "123456";
        String nombres = "Juan";
        String apellidos = "Pérez";
        String telefono = "987654321";
        String email = "juan@example.com";

        RolEntity rol = new RolEntity();
        rol.setIdRol("1");
        rol.setNomRol("ADMIN");

        empleado.setIdEmp(id);
        empleado.setNombresEmp(nombres);
        empleado.setApellidosEmp(apellidos);
        empleado.setTelefonoEmp(telefono);
        empleado.setEmailEmp(email);
        empleado.setRol(rol);

        assertEquals(id, empleado.getIdEmp());
        assertEquals(nombres, empleado.getNombresEmp());
        assertEquals(apellidos, empleado.getApellidosEmp());
        assertEquals(telefono, empleado.getTelefonoEmp());
        assertEquals(email, empleado.getEmailEmp());
        assertEquals(rol, empleado.getRol());
    }

    @Test
    void testDefaultConstructor() {
        EmpleadoEntity empleado = new EmpleadoEntity();

        assertNull(empleado.getIdEmp());
        assertNull(empleado.getNombresEmp());
        assertNull(empleado.getApellidosEmp());
        assertNull(empleado.getTelefonoEmp());
        assertNull(empleado.getEmailEmp());
        assertNull(empleado.getRol());
    }

    @Test
    void testSetRol() {
        EmpleadoEntity empleado = new EmpleadoEntity();

        RolEntity rol = new RolEntity();
        rol.setIdRol("2");
        rol.setNomRol("DOCTOR");

        empleado.setRol(rol);

        assertNotNull(empleado.getRol());
        assertEquals("2", empleado.getRol().getIdRol());
        assertEquals("DOCTOR", empleado.getRol().getNomRol());
    }
}
