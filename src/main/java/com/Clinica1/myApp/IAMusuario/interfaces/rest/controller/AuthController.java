package com.Clinica1.myApp.IAMusuario.interfaces.rest.controller;

import com.Clinica1.myApp.IAMusuario.domain.exception.CredencialesInvalidasException;
import com.Clinica1.myApp.IAMusuario.interfaces.rest.dto.request.CrearUsuarioRequest;
import com.Clinica1.myApp.IAMusuario.interfaces.rest.dto.request.LoginRequest;
import com.Clinica1.myApp.IAMusuario.interfaces.rest.dto.response.TokenResponse;
import com.Clinica1.myApp.IAMusuario.interfaces.rest.mapper.UsuarioRequestMapper;
import com.Clinica1.myApp.IAMusuario.domain.model.aggregates.Usuario;
import com.Clinica1.myApp.IAMusuario.domain.repository.UsuarioRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/auth")
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
        Usuario usuarioNuevo = usuarioRequestMapper.toUsuario(request);

        // guardar usando el repositorio de dominio (que internamente usa JPA)
        Usuario guardado = usuarioRepository.insert(usuarioNuevo);

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
        Usuario usuario = usuarioRepository.findbyUsername(request.getUsername());

        if (usuario == null) {
            throw new CredencialesInvalidasException("Usuario o contraseña incorrectos");
        }

        String hashGuardado = usuario.getPasshash().getValor_contra_hash();
        if (!hashGuardado.equals(request.getPassword())) {
            throw new CredencialesInvalidasException("Usuario o contraseña incorrectos");
        }

        String rolNombre = usuario.getEmp().getRolemp().getNombrerol();
        String token = "LOGIN_OK_" + usuario.getId_usu().obtenerid(); // reemplazar dsp por JWT real

        TokenResponse response = new TokenResponse(
                token,
                usuario.getUsername(),
                rolNombre);

        return ResponseEntity.ok(response);
    }
}
