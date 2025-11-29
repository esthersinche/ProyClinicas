package com.IAMusuario.interfaces.mapper;

import com.Clinica1.myApp.IAMusuario.interfaces.rest.dto.request.CrearUsuarioRequest;
import com.Clinica1.myApp.IAMusuario.interfaces.rest.mapper.UsuarioRequestMapper;
import com.Clinica1.myApp.SharedKernel.Empleado;
import com.Clinica1.myApp.IAMusuario.domain.model.aggregates.Rol;
import com.Clinica1.myApp.SharedKernel.Usuario;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

class UsuarioRequestMapperTest {

    @Test
    void testUsuarioRequestMapperCompleto() {

        UsuarioRequestMapper mapper = new UsuarioRequestMapper();

        CrearUsuarioRequest request = new CrearUsuarioRequest();
        request.setUsername("juan123");
        request.setPassword("123456");
        request.setNombres("Juan");
        request.setApellidos("López");
        request.setTelefono("987654321");
        request.setEmail("juan@mail.com");
        request.setRol("Doctor");

        Usuario usuario = mapper.toUsuario(request);

        assertNotNull(usuario);
        assertEquals("juan123", usuario.getUsername());
        assertEquals("123456", usuario.getPasshash().getValor_contra_hash());

        Empleado empleado = usuario.getEmp();
        assertNotNull(empleado);
        assertEquals("Juan", empleado.getNombre());
        assertEquals("López", empleado.getApellido());
        assertEquals("987654321", empleado.getTelefono());

        assertEquals("juan@mail.com", empleado.getEmail().email_valor());
        assertNotNull(empleado.getEmail());

        Rol rol = empleado.getRolemp();
        assertNotNull(rol);

        assertSame(Rol.doctor.getNombrerol(), rol.getNombrerol());

        CrearUsuarioRequest request2 = new CrearUsuarioRequest();
        request2.setUsername("mariaX");
        request2.setPassword("abc123");
        request2.setNombres("María");
        request2.setApellidos("García");
        request2.setTelefono("999888777");
        request2.setEmail("maria@mail.com");
        request2.setRol("Recepcionista");

        Usuario usuario2 = mapper.toUsuario(request2);
        Rol rol2 = usuario2.getEmp().getRolemp();

        assertEquals("Recepcionista", rol2.getNombrerol());
        assertEquals(new HashSet<>(), rol2.getFunciones()); // sin funciones por defecto
    }
}
