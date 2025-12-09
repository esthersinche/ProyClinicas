package com.Clinica1.myApp.mantenimiento.interfaces.rest.controller;

import com.Clinica1.myApp.mantenimiento.application.command.AuthValidateCommand;
import com.Clinica1.myApp.mantenimiento.application.dto.AuthValidateRequest;
import com.Clinica1.myApp.mantenimiento.application.dto.EmpleadoMinimalDto;
import com.Clinica1.myApp.mantenimiento.application.handler.AuthValidateCommandHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthValidateCommandHandler handler;

    @PostMapping("/validate")
    public ResponseEntity<EmpleadoMinimalDto> validate(
            @RequestBody AuthValidateRequest request) {

        EmpleadoMinimalDto dto =
                handler.handle(
                        new AuthValidateCommand(
                                request.getEmail(),
                                request.getPassword()
                        )
                );

        if (dto == null)
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();

        return ResponseEntity.ok(dto);
    }
}