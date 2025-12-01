package com.Clinica1.myApp.SharedKernel;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmpleadoTest {

    @Test
    void deberiaCrearEmpleadoConConstructor() {
        IDEntidad id = IDEntidad.generar();
        Email email = Email.of("test@mail.com");

        Empleado emp = new Empleado(id, "Juan", "Lopez", "999123456", email, Roles.Rol_Admin);

        assertEquals(id, emp.getId_emp());
        assertEquals("Juan", emp.getNombre());
        assertEquals("Lopez", emp.getApellido());
        assertEquals("999123456", emp.getTelefono());
        assertEquals(email, emp.getEmail());
        assertEquals(Roles.Rol_Admin, emp.getRolemp());
    }

    @Test
    void deberiaCrearEmpleadoConFactory() {
        Email email = Email.of("emp@empresa.com");

        Empleado emp = Empleado.crearemp("Maria", "Perez", "987654321", email, Roles.Rol_Recepcionista);

        assertNotNull(emp.getId_emp());
        assertEquals("Maria", emp.getNombre());
        assertEquals("Perez", emp.getApellido());
        assertEquals("987654321", emp.getTelefono());
        assertEquals(email, emp.getEmail());
        assertEquals(Roles.Rol_Recepcionista, emp.getRolemp());
    }

    @Test
    void deberiaAplicarEqualsYHashCodePorId() {
        IDEntidad id = IDEntidad.generar();
        Email email1 = Email.of("d1@mail.com");
        Email email2 = Email.of("d2@mail.com");

        Empleado emp1 = new Empleado(id, "Doc", "Uno", "111", email1, Roles.Rol_Doctor);
        Empleado emp2 = new Empleado(id, "Doc", "Dos", "222", email2, Roles.Rol_Admin);

        assertEquals(emp1, emp2);
        assertEquals(emp1.hashCode(), emp2.hashCode());
    }

    @Test
    void empleadosConIdsDiferentesNoSonIguales() {
        Empleado emp1 = Empleado.crearemp("A", "B", "111", Email.of("a@mail.com"), Roles.Rol_Admin);
        Empleado emp2 = Empleado.crearemp("C", "D", "222", Email.of("b@mail.com"), Roles.Rol_Doctor);

        assertNotEquals(emp1, emp2);
    }
}
