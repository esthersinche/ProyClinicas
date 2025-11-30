package com.Clinica1.myApp.IAMusuario.application;


import com.Clinica1.myApp.IAMusuario.domain.model.valueobjects.ContraHash;
import com.Clinica1.myApp.SharedKernel.Empleado;
import com.Clinica1.myApp.IAMusuario.domain.repository.UsuarioRepository;
import com.Clinica1.myApp.IAMusuario.domain.repository.EmpleadoRepository;
import com.Clinica1.myApp.IAMusuario.interfaces.rest.dto.request.CrearUsuarioRequest;
import com.Clinica1.myApp.SharedKernel.UsuarioWeb;
import org.springframework.stereotype.Service;


@Service
public class UsuarioService {


    private final UsuarioRepository usuarioRepository;
    private final EmpleadoRepository empleadoRepository;


    public UsuarioService(UsuarioRepository usuarioRepository, EmpleadoRepository empleadoRepository) {
        this.usuarioRepository = usuarioRepository;
        this.empleadoRepository = empleadoRepository;
    }


    public UsuarioWeb registrarUsuario(CrearUsuarioRequest command) {
        Empleado empleado = empleadoRepository.FindById(command.idEmpleado())
                .orElseThrow(() -> new RuntimeException("Empleado no encontrado"));


        UsuarioWeb usuarioWeb = com.Clinica1.myApp.SharedKernel.UsuarioWeb.crearusu(
                command.username(),
                ContraHash.deHash(command.password()),
                empleado
        );


        return usuarioRepository.guardar(usuarioWeb);
    }


}