package com.Clinica1.myApp.IAMusuario.aggregates;

import com.Clinica1.myApp.SharedKernel.Empleado;
import com.Clinica1.myApp.IAMusuario.domain.model.aggregates.Rol;
import com.Clinica1.myApp.IAMusuario.domain.model.valueobjects.ContraHash;
import com.Clinica1.myApp.SharedKernel.Email;
import com.Clinica1.myApp.SharedKernel.IDEntidad;
import com.Clinica1.myApp.SharedKernel.UsuarioWeb;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UsuarioWebTest {

    @Test
    void crearusuDebeGenerarIdYAsignarDatos() {
        Empleado emp = Empleado.crearemp(
                "Juan",
                "Lopez",
                "987654321",
                Email.of("juan@example.com"),
                Rol.crearrol("Admin", new java.util.HashSet<>()));

        ContraHash hash = ContraHash.deHash("123456");

        UsuarioWeb usuarioWeb = com.Clinica1.myApp.SharedKernel.UsuarioWeb.crearusu("juan123", hash, emp);

        assertNotNull(usuarioWeb.getId_usu(), "El ID debe generarse automáticamente");
        assertEquals("juan123", usuarioWeb.getUsername());
        assertEquals(hash, usuarioWeb.getPasshash());
        assertEquals(emp, usuarioWeb.getEmp());
    }

    @Test
    void equalsDebeSerTrueCuandoLosIdsSonIguales() {
        IDEntidad id = IDEntidad.generar();

        UsuarioWeb u1 = new UsuarioWeb(id, "user1", ContraHash.deHash("abc"), null);
        UsuarioWeb u2 = new UsuarioWeb(id, "user2", ContraHash.deHash("xyz"), null);

        assertEquals(u1, u2, "Usuarios con el mismo ID deben ser iguales");
    }

    @Test
    void equalsDebeSerFalseCuandoLosIdsSonDistintos() {
        UsuarioWeb u1 = com.Clinica1.myApp.SharedKernel.UsuarioWeb.crearusu("userA", ContraHash.deHash("111"), null);
        UsuarioWeb u2 = com.Clinica1.myApp.SharedKernel.UsuarioWeb.crearusu("userA", ContraHash.deHash("111"), null);

        assertNotEquals(u1, u2, "Usuarios con IDs diferentes no deben ser iguales");
    }

    @Test
    void hashCodeDebeSerIgualCuandoIdsSonIguales() {
        IDEntidad id = IDEntidad.generar();

        UsuarioWeb u1 = new UsuarioWeb(id, "x1", ContraHash.deHash("aaa"), null);
        UsuarioWeb u2 = new UsuarioWeb(id, "x2", ContraHash.deHash("bbb"), null);

        assertEquals(u1.hashCode(), u2.hashCode());
    }

    @Test
    void usuarioDebeGuardarEmpleadoCorrectamente() {
        Empleado emp = Empleado.crearemp(
                "Maria",
                "Gomez",
                "999888777",
                Email.of("maria@example.com"),
                Rol.crearrol("Recepcionista", new java.util.HashSet<>()));

        UsuarioWeb usuarioWeb = com.Clinica1.myApp.SharedKernel.UsuarioWeb.crearusu("maria01",
                ContraHash.deHash("pass"), emp);

        assertNotNull(usuarioWeb.getId_emp());
        assertEquals("Maria", usuarioWeb.getEmp().getNombre());
        assertEquals("Gomez", usuarioWeb.getEmp().getApellido());
    }
}
