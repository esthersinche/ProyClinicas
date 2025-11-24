package com.Clinica1.myApp.IAMusuario.application;


import com.Clinica1.myApp.IAMusuario.domain.model.aggregates.Usuario;
import com.Clinica1.myApp.IAMusuario.domain.model.valueobjects.ContraHash;
import com.Clinica1.myApp.IAMusuario.domain.model.aggregates.Empleado;
import com.Clinica1.myApp.IAMusuario.domain.repository.UsuarioRepository;
import com.Clinica1.myApp.IAMusuario.domain.repository.EmpleadoRepository;
import com.Clinica1.myApp.IAMusuario.interfaces.rest.dto.request.CrearUsuarioRequest;
import org.springframework.stereotype.Service;


@Service
public class UsuarioService {


    private final UsuarioRepository usuarioRepository;
    private final EmpleadoRepository empleadoRepository;


    public UsuarioService(UsuarioRepository usuarioRepository, EmpleadoRepository empleadoRepository) {
        this.usuarioRepository = usuarioRepository;
        this.empleadoRepository = empleadoRepository;
    }


    public Usuario registrarUsuario(CrearUsuarioRequest command) {
        Empleado empleado = empleadoRepository.FindById(command.idEmpleado())
                .orElseThrow(() -> new RuntimeException("Empleado no encontrado"));


        Usuario usuario = Usuario.crearusu(
                command.username(),
                ContraHash.hasheandocB(command.password()),
                empleado
        );


        return usuarioRepository.guardar(usuario);
    }


}