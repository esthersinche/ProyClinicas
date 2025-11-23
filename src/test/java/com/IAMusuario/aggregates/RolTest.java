package com.IAMusuario.aggregates;

import com.Clinica1.myApp.IAMusuario.domain.model.aggregates.Rol;
import com.Clinica1.myApp.IAMusuario.domain.model.valueobjects.Funcion;
import com.Clinica1.myApp.SharedKernel.IDEntidad;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

class RolTest {

    @Test
    void crearrolDebeGenerarIdYAsignarNombreYFunciones() {
        HashSet<Funcion> funciones = new HashSet<>();
        funciones.add(Funcion.of("crear_usuario"));
        funciones.add(Funcion.of("eliminar_usuario"));

        Rol rol = Rol.crearrol("Admin", funciones);

        assertNotNull(rol.getId_rol());
        assertEquals("Admin", rol.getNombrerol());
        assertEquals(2, rol.getFunciones().size());
        assertTrue(rol.getFunciones().contains(Funcion.of("crear_usuario")));
        assertTrue(rol.getFunciones().contains(Funcion.of("eliminar_usuario")));
    }

    @Test
    void rolDoctorDebeTenerFuncionesEsperadas() {
        Rol doctor = Rol.doctor;

        assertEquals("Doctor", doctor.getNombrerol());
        assertTrue(doctor.estapermitidonombre("Atender_paciente"));
        assertTrue(doctor.estapermitidonombre("buscar_paciente"));
        assertEquals(2, doctor.getFunciones().size());
    }

    @Test
    void estapermitidoDebeRetornarTrueSiLaFuncionExiste() {
        HashSet<Funcion> funciones = new HashSet<>();
        funciones.add(Funcion.of("modificar_historial"));

        Rol rol = Rol.crearrol("Enfermero", funciones);

        assertTrue(rol.estapermitido(Funcion.of("modificar_historial")));
    }

    @Test
    void estapermitidoDebeRetornarFalseSiLaFuncionNoExiste() {
        HashSet<Funcion> funciones = new HashSet<>();
        funciones.add(Funcion.of("registrar_cita"));

        Rol rol = Rol.crearrol("Recepcionista", funciones);

        assertFalse(rol.estapermitido(Funcion.of("borrar_cita")));
    }

    @Test
    void estapermitidonombreDebeRetornarTrueSiExiste() {
        HashSet<Funcion> funciones = new HashSet<>();
        funciones.add(Funcion.of("aprobar_pago"));

        Rol rol = Rol.crearrol("Cajero", funciones);

        assertTrue(rol.estapermitidonombre("aprobar_pago"));
    }

    @Test
    void estapermitidonombreDebeRetornarFalseSiNoExiste() {
        HashSet<Funcion> funciones = new HashSet<>();
        funciones.add(Funcion.of("emitir_boleta"));

        Rol rol = Rol.crearrol("Cajero", funciones);

        assertFalse(rol.estapermitidonombre("anular_boleta"));
    }

    @Test
    void equalsDebeSerTrueCuandoIdsSonIguales() {
        IDEntidad id = IDEntidad.generar();

        Rol rol1 = new Rol(id, "Admin", new HashSet<>());
        Rol rol2 = new Rol(id, "Doctor", new HashSet<>());

        assertEquals(rol1, rol2, "Roles con el mismo ID deben ser iguales");
    }

    @Test
    void equalsDebeSerFalseCuandoIdsSonDistintos() {
        Rol rol1 = Rol.crearrol("Admin", new HashSet<>());
        Rol rol2 = Rol.crearrol("Admin", new HashSet<>());

        assertNotEquals(rol1, rol2, "Roles distintos no deben ser iguales");
    }

    @Test
    void hashCodeDebeSerIgualCuandoIdsSonIguales() {
        IDEntidad id = IDEntidad.generar();

        Rol rol1 = new Rol(id, "Admin", new HashSet<>());
        Rol rol2 = new Rol(id, "Admin", new HashSet<>());

        assertEquals(rol1.hashCode(), rol2.hashCode());
    }
}
