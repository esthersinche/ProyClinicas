package com.Clinica1.myApp.appointments.interfaces.rest.controller;

import com.Clinica1.myApp.SharedKernel.IDEntidad;
import com.Clinica1.myApp.appointments.application.command.CrearCitaCommand;
import com.Clinica1.myApp.appointments.application.handler.CrearCitaCommandHandler;
import com.Clinica1.myApp.appointments.interfaces.rest.dto.request.CrearCitaRequest;
import com.Clinica1.myApp.appointments.interfaces.rest.dto.response.CrearCitaResponse;
import com.Clinica1.myApp.appointments.interfaces.rest.mapper.CitaRequestMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/Cita")
@RequiredArgsConstructor
@Validated
//controladores q exponen endpoints
public class CitaController {
    private final CrearCitaCommandHandler crear_cita_handler;
    private final CitaRequestMapper citareq_map;

    public ResponseEntity<CrearCitaResponse> CrearCita(@Valid @RequestBody CrearCitaRequest cre_cit_req){
        CrearCitaCommand crearcit_com= citareq_map.ToCommand(cre_cit_req);

        IDEntidad cita_id= crear_cita_handler.handle(crearcit_com);

    }

}
