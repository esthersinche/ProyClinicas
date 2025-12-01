package com.Clinica1.myApp.IAMusuario.aggregates;

import com.Clinica1.myApp.SharedKernel.Empleado;
import com.Clinica1.myApp.IAMusuario.domain.model.aggregates.Rol;
import com.Clinica1.myApp.SharedKernel.Email;
import com.Clinica1.myApp.SharedKernel.IDEntidad;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmpleadoTest {

    @Test
    void factoryDeberiaCrearEmpleadoConIdNoNulo() {
        Email email = Email.of("empleado@correo.com");
        Rol rol = Rol.crearrol("Admin", null);

        Empleado empleado = Empleado.crearemp(
                "Juan",
                "Perez",
                "999111222",
                email,
                rol);

        assertNotNull(empleado.getId_emp(), "El ID no debe ser nulo");
        assertEquals("Juan", empleado.getNombre());
        assertEquals("Perez", empleado.getApellido());
        assertEquals("999111222", empleado.getTelefono());
        assertEquals(email, empleado.getEmail());
        assertEquals(rol, empleado.getRolemp());
    }

    @Test
    void empleadoConstructorDebeAsignarBienLosValores() {
        IDEntidad id = IDEntidad.generar();
        Email email = Email.of("doctor@correo.com");
        Rol rol = Rol.crearrol("Doctor", null);

        Empleado empleado = new Empleado(
                id,
                "Mario",
                "Gomez",
                "123456789",
                email,
                rol);

        assertEquals(id, empleado.getId_emp());
        assertEquals("Mario", empleado.getNombre());
        assertEquals("Gomez", empleado.getApellido());
        assertEquals("123456789", empleado.getTelefono());
        assertEquals(email, empleado.getEmail());
        assertEquals(rol, empleado.getRolemp());
    }

    @Test
    void equalsDebeSerTrueCuandoIdsSonIguales() {
        IDEntidad id = IDEntidad.generar();

        Empleado emp1 = new Empleado(id, "Juan", "Lopez", "111", Email.of("a@a.com"), Rol.crearrol("Admin", null));
        Empleado emp2 = new Empleado(id, "Carlos", "Diaz", "222", Email.of("b@b.com"), Rol.crearrol("Doctor", null));

        assertEquals(emp1, emp2, "Dos empleados con el mismo ID deben ser iguales");
    }

    @Test
    void equalsDebeSerFalseCuandoIdsSonDistintos() {
        Empleado emp1 = Empleado.crearemp("Ana", "Vega", "111", Email.of("a@a.com"), Rol.crearrol("Admin", null));
        Empleado emp2 = Empleado.crearemp("Ana", "Vega", "111", Email.of("a@a.com"), Rol.crearrol("Admin", null));

        assertNotEquals(emp1, emp2, "Dos empleados diferentes no deben ser iguales");
    }

    @Test
    void hashCodeDebeDependerSoloDelId() {
        IDEntidad id = IDEntidad.generar();
        Empleado emp1 = new Empleado(id, "X", "Y", "111", Email.of("a@a.com"), Rol.crearrol("Admin", null));
        Empleado emp2 = new Empleado(id, "A", "B", "222", Email.of("b@b.com"), Rol.crearrol("Doctor", null));

        assertEquals(emp1.hashCode(), emp2.hashCode(), "hashCode debe ser igual si los IDs son iguales");
    }
}
