package com.IAMusuario.aggregates;

import com.Clinica1.myApp.IAMusuario.domain.model.aggregates.Empleado;
import com.Clinica1.myApp.IAMusuario.domain.model.aggregates.Rol;
import com.Clinica1.myApp.IAMusuario.domain.model.aggregates.Usuario;
import com.Clinica1.myApp.IAMusuario.domain.model.valueobjects.ContraHash;
import com.Clinica1.myApp.IAMusuario.domain.model.valueobjects.Email;
import com.Clinica1.myApp.SharedKernel.IDEntidad;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UsuarioTest {

    @Test
    void crearusuDebeGenerarIdYAsignarDatos() {
        Empleado emp = Empleado.crearemp(
                "Juan",
                "Lopez",
                "987654321",
                Email.of("juan@example.com"),
                Rol.crearrol("Admin", new java.util.HashSet<>())
        );

        ContraHash hash = ContraHash.hasheandocB("123456");

        Usuario usuario = Usuario.crearusu("juan123", hash, emp);

        assertNotNull(usuario.getId_usu(), "El ID debe generarse automáticamente");
        assertEquals("juan123", usuario.getUsername());
        assertEquals(hash, usuario.getPasshash());
        assertEquals(emp, usuario.getEmp());
    }

    @Test
    void equalsDebeSerTrueCuandoLosIdsSonIguales() {
        IDEntidad id = IDEntidad.generar();

        Usuario u1 = new Usuario(id, "user1", ContraHash.hasheandocB("abc"), null);
        Usuario u2 = new Usuario(id, "user2", ContraHash.hasheandocB("xyz"), null);

        assertEquals(u1, u2, "Usuarios con el mismo ID deben ser iguales");
    }

    @Test
    void equalsDebeSerFalseCuandoLosIdsSonDistintos() {
        Usuario u1 = Usuario.crearusu("userA", ContraHash.hasheandocB("111"), null);
        Usuario u2 = Usuario.crearusu("userA", ContraHash.hasheandocB("111"), null);

        assertNotEquals(u1, u2, "Usuarios con IDs diferentes no deben ser iguales");
    }

    @Test
    void hashCodeDebeSerIgualCuandoIdsSonIguales() {
        IDEntidad id = IDEntidad.generar();

        Usuario u1 = new Usuario(id, "x1", ContraHash.hasheandocB("aaa"), null);
        Usuario u2 = new Usuario(id, "x2", ContraHash.hasheandocB("bbb"), null);

        assertEquals(u1.hashCode(), u2.hashCode());
    }

    @Test
    void usuarioDebeGuardarEmpleadoCorrectamente() {
        Empleado emp = Empleado.crearemp(
                "Maria",
                "Gomez",
                "999888777",
                Email.of("maria@example.com"),
                Rol.crearrol("Recepcionista", new java.util.HashSet<>())
        );

        Usuario usuario = Usuario.crearusu("maria01", ContraHash.hasheandocB("pass"), emp);

        assertNotNull(usuario.getEmp());
        assertEquals("Maria", usuario.getEmp().getNombre());
        assertEquals("Gomez", usuario.getEmp().getApellido());
    }
}

