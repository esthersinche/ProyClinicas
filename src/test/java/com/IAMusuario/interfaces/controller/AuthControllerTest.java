package com.IAMusuario.interfaces.controller;

import com.Clinica1.myApp.IAMusuario.interfaces.rest.controller.AuthController;
import com.Clinica1.myApp.IAMusuario.interfaces.rest.dto.request.CrearUsuarioRequest;
import com.Clinica1.myApp.IAMusuario.interfaces.rest.mapper.UsuarioRequestMapper;
import com.Clinica1.myApp.SharedKernel.Empleado;
import com.Clinica1.myApp.IAMusuario.domain.model.aggregates.Rol;
import com.Clinica1.myApp.SharedKernel.Usuario;
import com.Clinica1.myApp.IAMusuario.domain.model.valueobjects.ContraHash;
import com.Clinica1.myApp.IAMusuario.domain.model.valueobjects.Email;
import com.Clinica1.myApp.IAMusuario.domain.model.valueobjects.Funcion;
import com.Clinica1.myApp.IAMusuario.domain.repository.UsuarioRepository;
import com.Clinica1.myApp.SharedKernel.IDEntidad;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest(AuthController.class)
class AuthControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UsuarioRepository usuarioRepository;

    @MockBean
    private UsuarioRequestMapper usuarioRequestMapper;

    private Usuario crearUsuarioPrueba() {
        HashSet<Funcion> funciones = new HashSet<>();
        funciones.add(Funcion.of("GESTIONAR"));

        Rol rol = new Rol(
                IDEntidad.astring("ROL001"),
                "ADMIN",
                funciones
        );

        Empleado empleado = new Empleado(
                IDEntidad.astring("EMP001"),
                "Luis",
                "Ramos",
                "999000111",
                Email.of("luis@test.com"),
                rol
        );

        return new Usuario(
                IDEntidad.astring("USR123"),
                "usuarioTest",
                ContraHash.hasheandocB("pass123"),
                empleado
        );
    }

    @Test
    void testRegister() throws Exception {
        CrearUsuarioRequest request = new CrearUsuarioRequest();
        request.setUsername("nuevoUser");
        request.setPassword("123");
        request.setNombre("Juan");
        request.setApellido("Lopez");
        request.setEmail("juan@mail.com");
        request.setTelefono("111222333");
        request.setRol("ADMIN");

        Usuario mockUsuario = crearUsuarioPrueba();

        when(usuarioRequestMapper.toUsuario(any())).thenReturn(mockUsuario);
        when(usuarioRepository.insert(any())).thenReturn(mockUsuario);

        mockMvc.perform(post("/api/auth/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                        {
                          "username": "nuevoUser",
                          "password": "123",
                          "nombre": "Juan",
                          "apellido": "Lopez",
                          "email": "juan@mail.com",
                          "telefono": "111222333",
                          "rol": "ADMIN"
                        }
                        """))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.token").value("REGISTERED_USR123"))
                .andExpect(jsonPath("$.username").value("usuarioTest"))
                .andExpect(jsonPath("$.rol").value("ADMIN"));
    }

    @Test
    void testLoginExitoso() throws Exception {
        Usuario usuario = crearUsuarioPrueba();

        when(usuarioRepository.findbyUsername("usuarioTest")).thenReturn(usuario);

        mockMvc.perform(post("/api/auth/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                        {
                          "username": "usuarioTest",
                          "password": "pass123"
                        }
                        """))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.token").value("LOGIN_OK_USR123"))
                .andExpect(jsonPath("$.username").value("usuarioTest"))
                .andExpect(jsonPath("$.rol").value("ADMIN"));
    }

    @Test
    void testLoginUsuarioNoExiste() throws Exception {

        when(usuarioRepository.findbyUsername("desconocido")).thenReturn(null);

        mockMvc.perform(post("/api/auth/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                        {
                          "username": "desconocido",
                          "password": "123"
                        }
                        """))
                .andExpect(status().isUnauthorized());
    }

    @Test
    void testLoginPasswordIncorrecta() throws Exception {
        Usuario usuario = crearUsuarioPrueba();

        when(usuarioRepository.findbyUsername("usuarioTest")).thenReturn(usuario);

        mockMvc.perform(post("/api/auth/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                        {
                          "username": "usuarioTest",
                          "password": "otraPass"
                        }
                        """))
                .andExpect(status().isUnauthorized());
    }

}
