package com.Clinica1.myApp.IAMusuario.interfaces.rest.controller;

import com.Clinica1.myApp.IAMusuario.application.command.LoginCommand;
import com.Clinica1.myApp.IAMusuario.application.command.LogoutCommand;
import com.Clinica1.myApp.IAMusuario.application.command.PermisosEmpleadosCommand;
import com.Clinica1.myApp.IAMusuario.application.command.ValidarTokenCommand;
import com.Clinica1.myApp.IAMusuario.application.dto.TokenDto;
import com.Clinica1.myApp.IAMusuario.application.handler.LoginCommandHandler;
import com.Clinica1.myApp.IAMusuario.application.handler.LogoutCommandHandler;
import com.Clinica1.myApp.IAMusuario.application.handler.PermisosEmpleadosCommandHandler;
import com.Clinica1.myApp.IAMusuario.application.handler.ValidarTokenCommandHandler;
import com.Clinica1.myApp.IAMusuario.interfaces.rest.dto.request.LoginRequest;
import com.Clinica1.myApp.IAMusuario.interfaces.rest.dto.request.LogoutRequest;
import com.Clinica1.myApp.IAMusuario.interfaces.rest.dto.request.PermisosEmpleadosRequest;
import com.Clinica1.myApp.IAMusuario.interfaces.rest.dto.request.ValidarTokenRequest;
import com.Clinica1.myApp.IAMusuario.interfaces.rest.dto.response.Funcionesresponse;
import com.Clinica1.myApp.IAMusuario.interfaces.rest.dto.response.TokenResponse;
import com.Clinica1.myApp.IAMusuario.interfaces.rest.mapper.LoginMapper;
import com.Clinica1.myApp.IAMusuario.interfaces.rest.mapper.LogoutMapper;
import com.Clinica1.myApp.IAMusuario.interfaces.rest.mapper.PermisosEmpleadoMapper;
import com.Clinica1.myApp.IAMusuario.interfaces.rest.mapper.ValidarTokenMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/api/IAM")
@Validated
public class IAMController {
    private final LoginCommandHandler login_com_hand;
    private final LoginMapper login_map;

    private final LogoutCommandHandler logout_com_hand;
    private final LogoutMapper logout_map;

    private final ValidarTokenCommandHandler valtok_com_hand;
    private final ValidarTokenMapper valtok_map;

    private final PermisosEmpleadosCommandHandler peremp_com_hand;
    private final PermisosEmpleadoMapper peremp_map;

    public IAMController(LoginCommandHandler login_com_hand, LoginMapper login_map, LogoutCommandHandler logout_com_hand, LogoutMapper logout_map, ValidarTokenCommandHandler valtok_com_hand, ValidarTokenMapper valtok_map, PermisosEmpleadosCommandHandler peremp_com_hand, PermisosEmpleadoMapper peremp_map) {
        this.login_com_hand = login_com_hand;
        this.login_map = login_map;
        this.logout_com_hand = logout_com_hand;
        this.logout_map = logout_map;
        this.valtok_com_hand = valtok_com_hand;
        this.valtok_map = valtok_map;
        this.peremp_com_hand = peremp_com_hand;
        this.peremp_map = peremp_map;
    }

    @PostMapping("/login")
    public ResponseEntity<TokenResponse> login(@Valid @RequestBody LoginRequest login_req) {

        LoginCommand login_com= login_map.ToCommand(login_req);
        TokenDto logintok_dto= login_com_hand.handle(login_com);

        TokenResponse asterisk= TokenResponse.builder()
                .tokenacceso(logintok_dto.getAccesstoken())
                .emp_id(logintok_dto.getId_emp())
                .sgparaexpiracion(logintok_dto.getExpiracion())
                .funciones(logintok_dto.getFunciones())
                .build();

        return ResponseEntity.ok(asterisk);

    }

    @PostMapping("/logout")
    public ResponseEntity<?> logout(@Valid @RequestBody LogoutRequest logout_req){
        LogoutCommand logout_com= logout_map.ToCommand(logout_req);
        logout_com_hand.handle(logout_com);

        return ResponseEntity.ok().build();

    }

    @PostMapping("/validartoken")
    public ResponseEntity<TokenResponse> validartoken(@Valid @RequestBody ValidarTokenRequest valtok_req){
        ValidarTokenCommand valtok_com= valtok_map.ToCommand(valtok_req);
        TokenDto valtok_dto= valtok_com_hand.handle(valtok_com);

        TokenResponse asterisk2= TokenResponse.builder()
                .tokenacceso(valtok_dto.getAccesstoken())
                .emp_id(valtok_dto.getId_emp())
                .sgparaexpiracion(valtok_dto.getExpiracion())
                .funciones(valtok_dto.getFunciones())
                .build();

        return ResponseEntity.ok(asterisk2);
    }

    @GetMapping("/funciones/{id_emp}")
    public ResponseEntity<Funcionesresponse> permisosempleado(@PathVariable("id_emp") String id_emp){
        //request
        PermisosEmpleadosRequest peremp_req= new PermisosEmpleadosRequest(id_emp);
        PermisosEmpleadosCommand peremp_com= peremp_map.ToCommand(peremp_req);

        List<String> funciones= peremp_com_hand.obtenerFunciones(peremp_com);
        Funcionesresponse hotd= Funcionesresponse.builder()
                .funciones(funciones)
                .build();
        return ResponseEntity.ok(hotd);

    }
/*@PostMapping("/register")
    public ResponseEntity<TokenResponse> register(@Valid @RequestBody CrearUsuarioRequest request) {
        // mapear request -> aggregate
        UsuarioWeb usuarioWebNuevo = LoginMapper.toUsuario(request);

        // guardar usando el repositorio de dominio (que internamente usa JPA)
        UsuarioWeb guardado = usuarioRepository.insert(usuarioWebNuevo);

        String rolNombre = guardado.getEmp().getRolemp().getNombrerol();
        String token = "REGISTERED_" + guardado.getId_usu().obtenerid(); // reemplazar dsp por JWT real

        TokenResponse response = new TokenResponse(
                token,
                guardado.getUsername(),
                rolNombre);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }*/
}


