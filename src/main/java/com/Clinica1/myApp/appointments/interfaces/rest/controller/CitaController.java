package com.Clinica1.myApp.appointments.interfaces.rest.controller;

import com.Clinica1.myApp.SharedKernel.IDEntidad;
import com.Clinica1.myApp.appointments.application.command.CancelarCitaCommand;
import com.Clinica1.myApp.appointments.application.command.ModificarCitaCommand;
import com.Clinica1.myApp.appointments.application.dto.CitaDto;
import com.Clinica1.myApp.appointments.application.exception.CitaNoEncontradaException;
import com.Clinica1.myApp.appointments.application.handler.*;
import com.Clinica1.myApp.appointments.application.query.ListarCitasPorDoctorQuery;
import com.Clinica1.myApp.appointments.application.query.ObtenerCitaPorIdQuery;
import com.Clinica1.myApp.appointments.interfaces.rest.dto.request.CrearCitaRequest;
import com.Clinica1.myApp.appointments.interfaces.rest.dto.request.ModificarCitaRequest;
import com.Clinica1.myApp.appointments.interfaces.rest.dto.response.CrearCitaResponse;
import com.Clinica1.myApp.appointments.interfaces.rest.mapper.CitaRequestMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/cita")
@RequiredArgsConstructor
@Validated
//controladores q exponen endpoints
public class CitaController {
    private final CrearCitaCommandHandler crearHandler;
    private final ListarCitasPorDoctorQueryHandler listarPorDoctorHandler;
    private final ModificarCitaCommandHandler modificarHandler;
    private final CancelarCitaCommandHandler cancelarHandler;
    private final ObtenerCitaPorIdQueryHandler obtenerCitaHandler;
    private final CitaRequestMapper mapper;

    @PostMapping
    public ResponseEntity<CrearCitaResponse> crearCita(@Valid @RequestBody CrearCitaRequest request) {
        var command = mapper.ToCommand(request);
        var dto = crearHandler.handle(command);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new CrearCitaResponse(
                        dto.getId(),
                        "Cita creada exitosamente"
                ));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CitaDto> obtenerCita(@PathVariable String id) {

        var query = new ObtenerCitaPorIdQuery(
                IDEntidad.astring(id)
        );

        var dto = obtenerCitaHandler.handle(query);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/doctor/{idDoctor}")
    public ResponseEntity<?> listarPorDoctor(@PathVariable String idDoctor) {
        var query = new ListarCitasPorDoctorQuery(idDoctor);
        return ResponseEntity.ok(
                listarPorDoctorHandler.handle(query)
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> modificarCita(@PathVariable String id,
                                           @RequestBody ModificarCitaRequest req) {
        var command = new ModificarCitaCommand(
                IDEntidad.astring(id),
                req.getInicio(),
                req.getFin()
        );

        var dto = modificarHandler.handle(command);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> cancelar(@PathVariable String id) {
        var command = new CancelarCitaCommand(IDEntidad.astring(id));
        try {
            cancelarHandler.handle(command);
            return ResponseEntity.ok("Cita cancelada");
        } catch (CitaNoEncontradaException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
