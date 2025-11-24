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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/Cita")
@RequiredArgsConstructor
@Validated
//controladores q exponen endpoints
public class CitaController {
    private final CrearCitaCommandHandler crearCitaHandler;
    private final CitaRequestMapper citaReqMapper;

    @PostMapping
    public ResponseEntity<CrearCitaResponse> crearCita(@Valid @RequestBody CrearCitaRequest request) {
        try {
            // Mapear request a command
            CrearCitaCommand command = citaReqMapper.toCommand(request);

            // Llamar al handler
            CitaDto citaDto = crearCitaHandler.handle(command);

            // Mapear CitaDto a response
            CrearCitaResponse response = new CrearCitaResponse(
                    citaDto.getId(),
                    citaDto.getMotivo(),
                    citaDto.getEstado(),
                    citaDto.getCanal(),
                    citaDto.getInicio(),
                    citaDto.getFin(),
                    citaDto.getPaciente(),
                    citaDto.getDoctor(),
                    citaDto.getEspecialidad()
            );

            return ResponseEntity.ok(response);

        } catch (Exception e) {
            //manejo d errores generico
            return ResponseEntity.badRequest().body(
                    new CrearCitaResponse("Error: " + e.getMessage())
            );
        }
    }
}
