package com.Clinica1.myApp.IAMusuario.infrastructure.persistence.jpa.entity;

import com.Clinica1.myApp.SharedKernel.Roles;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmpleadoEntityTest {

    @Test
    void builder_creaEntidadCorrectamente() {
        EmailEmbeddable email = new EmailEmbeddable("empleado@correo.com");

        EmpleadoEntity emp = EmpleadoEntity.builder()
                .id_Emp("123")
                .nombresEmp("Juan")
                .apellidosEmp("Pérez")
                .telefonoEmp("987654321")
                .email_emp(email)
                .rol(Roles.Rol_Doctor)
                .build();

        assertEquals("123", emp.getId_Emp());
        assertEquals("Juan", emp.getNombresEmp());
        assertEquals("Pérez", emp.getApellidosEmp());
        assertEquals("987654321", emp.getTelefonoEmp());
        assertEquals(email, emp.getEmail_emp());
        assertEquals(Roles.Rol_Doctor, emp.getRol());
    }

    @Test
    void getters_retornaValoresCorrectos() {
        EmailEmbeddable email = new EmailEmbeddable("test@correo.com");

        EmpleadoEntity emp = new EmpleadoEntity(
                "999",
                "Luis",
                "Ramos",
                "111222333",
                email,
                Roles.Rol_Admin);

        assertEquals("999", emp.getId_Emp());
        assertEquals("Luis", emp.getNombresEmp());
        assertEquals("Ramos", emp.getApellidosEmp());
        assertEquals("111222333", emp.getTelefonoEmp());
        assertEquals(email, emp.getEmail_emp());
        assertEquals(Roles.Rol_Admin, emp.getRol());
    }

    @Test
    void toString_noEsNulo() {
        EmpleadoEntity emp = EmpleadoEntity.builder()
                .id_Emp("T1")
                .nombresEmp("Ana")
                .apellidosEmp("Mendoza")
                .telefonoEmp("123")
                .email_emp(new EmailEmbeddable("a@a.com"))
                .rol(Roles.Rol_Recepcionista)
                .build();

        assertNotNull(emp.toString());
    }
}
