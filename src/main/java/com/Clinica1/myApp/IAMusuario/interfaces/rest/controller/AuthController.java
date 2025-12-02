package com.Clinica1.myApp.IAMusuario.interfaces.rest.controller;

import com.Clinica1.myApp.IAMusuario.domain.exception.CredencialesInvalidasException;
import com.Clinica1.myApp.IAMusuario.interfaces.rest.dto.request.CrearUsuarioRequest;
import com.Clinica1.myApp.IAMusuario.interfaces.rest.dto.request.LoginRequest;
import com.Clinica1.myApp.IAMusuario.interfaces.rest.dto.response.TokenResponse;
import com.Clinica1.myApp.IAMusuario.interfaces.rest.mapper.UsuarioRequestMapper;
import com.Clinica1.myApp.IAMusuario.domain.repository.UsuarioRepository;
import com.Clinica1.myApp.SharedKernel.UsuarioWeb;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/auth")
@Validated
public class AuthController {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioRequestMapper usuarioRequestMapper;

    public AuthController(UsuarioRepository usuarioRepository,
            UsuarioRequestMapper usuarioRequestMapper) {
        this.usuarioRepository = usuarioRepository;
        this.usuarioRequestMapper = usuarioRequestMapper;
    }

    @PostMapping("/register")
    public ResponseEntity<TokenResponse> register(@Valid @RequestBody CrearUsuarioRequest request) {
        // mapear request -> aggregate
        UsuarioWeb usuarioWebNuevo = usuarioRequestMapper.toUsuario(request);

        // guardar usando el repositorio de dominio (que internamente usa JPA)
        UsuarioWeb guardado = usuarioRepository.insert(usuarioWebNuevo);

        String rolNombre = guardado.getEmp().getRolemp().getNombrerol();
        String token = "REGISTERED_" + guardado.getId_usu().obtenerid(); // reemplazar dsp por JWT real

        TokenResponse response = new TokenResponse(
                token,
                guardado.getUsername(),
                rolNombre);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PostMapping("/login")
    public ResponseEntity<TokenResponse> login(@Valid @RequestBody LoginRequest request) {
        UsuarioWeb usuarioWeb = usuarioRepository.findbyUsername(request.getUsername());

        if (usuarioWeb == null) {
            throw new CredencialesInvalidasException("UsuarioWeb o contraseña incorrectos");
        }

        String hashGuardado = usuarioWeb.getPasshash().getValor_contra_hash();
        if (!hashGuardado.equals(request.getPassword())) {
            throw new CredencialesInvalidasException("UsuarioWeb o contraseña incorrectos");
        }

        String rolNombre = usuarioWeb.getEmp().getRolemp().getNombrerol();
        String token = "LOGIN_OK_" + usuarioWeb.getId_usu().obtenerid(); // reemplazar dsp por JWT real

        TokenResponse response = new TokenResponse(
                token,
                usuarioWeb.getUsername(),
                rolNombre);

        return ResponseEntity.ok(response);
    }
}
