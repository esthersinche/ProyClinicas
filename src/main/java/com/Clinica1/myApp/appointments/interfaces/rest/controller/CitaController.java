package com.Clinica1.myApp.appointments.interfaces.rest.controller;

import com.Clinica1.myApp.appointments.application.handler.CrearCitaCommandHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/Cita")
@RequiredArgsConstructor
@Validated
//controladores q exponen endpoints
public class CitaController {
    private final CrearCitaCommandHandler crear_cita_handler;

}
