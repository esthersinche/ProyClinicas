package com.Clinica1.myApp.appointments.interfaces.rest.controller;

import com.Clinica1.myApp.SharedKernel.IDEntidad;
import com.Clinica1.myApp.appointments.application.command.CrearPacienteCommand;
import com.Clinica1.myApp.appointments.application.dto.PacienteDto;
import com.Clinica1.myApp.appointments.application.dto.PacienteInfoDto;
import com.Clinica1.myApp.appointments.application.handler.CrearPacienteCommandHandler;
import com.Clinica1.myApp.appointments.application.handler.ListarPacientesQueryHandler;
import com.Clinica1.myApp.appointments.application.handler.ObtenerPacientePorDniQueryHandler;
import com.Clinica1.myApp.appointments.application.query.ObtenerPacientePorDniQuery;
import com.Clinica1.myApp.appointments.interfaces.rest.dto.request.CrearPacienteRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/pacientes")
@RequiredArgsConstructor
@Validated
public class PacienteController {

    private final CrearPacienteCommandHandler crearHandler;
    private final ListarPacientesQueryHandler listarHandler;
    private final ObtenerPacientePorDniQueryHandler obtenerPorDniHandler;

    // CREAR PACIENTE

    @PostMapping
    public ResponseEntity<?> crear(@RequestBody CrearPacienteRequest req) {

        var command = new CrearPacienteCommand(
                null,                     // ID se genera automáticamente
                req.getNombre(),
                req.getNacionalidad(),
                req.getDni(),
                req.getTel(),
                req.getEmail(),
                req.getFec_nac(),
                req.getSexo()
        );

        IDEntidad idGenerado = crearHandler.handle(command);

        return ResponseEntity.ok(
                "Paciente creado con ID: " + idGenerado.obtenerid()
        );
    }


    // LISTAR PACIENTES

    @GetMapping
    public ResponseEntity<List<PacienteInfoDto>> listar() {
        return ResponseEntity.ok(listarHandler.handle());
    }

    // LISTAR POR DNI
    @GetMapping("/dni/{dni}")
    public ResponseEntity<?> obtenerPorDni(@PathVariable String dni) {

        var query = new ObtenerPacientePorDniQuery(dni);
        var dto = obtenerPorDniHandler.handle(query);

        if (dto == null) {
            return ResponseEntity.status(404).body("Paciente no encontrado");
        }

        return ResponseEntity.ok(dto);
    }



}