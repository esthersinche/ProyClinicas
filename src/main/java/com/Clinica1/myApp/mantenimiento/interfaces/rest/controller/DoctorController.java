package com.Clinica1.myApp.mantenimiento.interfaces.rest.controller;

import com.Clinica1.myApp.SharedKernel.IDEntidad;
import com.Clinica1.myApp.mantenimiento.application.command.ActualizarDoctorCommand;
import com.Clinica1.myApp.mantenimiento.application.command.CrearDoctorCommand;
import com.Clinica1.myApp.mantenimiento.application.command.EliminarDoctorCommand;
import com.Clinica1.myApp.mantenimiento.application.dto.DoctorDto;
import com.Clinica1.myApp.mantenimiento.application.handler.ActualizarDoctorCommandHandler;
import com.Clinica1.myApp.mantenimiento.application.handler.CrearDoctorCommandHandler;
import com.Clinica1.myApp.mantenimiento.application.handler.EliminarDoctorCommandHandler;
import com.Clinica1.myApp.mantenimiento.application.handler.ListarDoctoresQueryHandler;
import com.Clinica1.myApp.mantenimiento.application.query.ListarDoctoresQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/mantenimiento/doctores")
@RequiredArgsConstructor
public class DoctorController {
    private final CrearDoctorCommandHandler crearDoctorCommandHandler;
    private final ActualizarDoctorCommandHandler actualizarDoctorCommandHandler;
    private final EliminarDoctorCommandHandler eliminarDoctorCommandHandler;
    private final ListarDoctoresQueryHandler listarDoctoresQueryHandler;

    @PostMapping
    public ResponseEntity<String> crear(@RequestBody CrearDoctorCommand command) {
        return ResponseEntity.ok(crearDoctorCommandHandler.handle(command));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar(
            @PathVariable String id,
            @RequestBody ActualizarDoctorCommand command
    ) {
        command.setIdDoctor(IDEntidad.astring(id));
        actualizarDoctorCommandHandler.handle(command);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable String id) {
        var command = new EliminarDoctorCommand(IDEntidad.astring(id));
        eliminarDoctorCommandHandler.handle(command);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<DoctorDto>> listar() {
        return ResponseEntity.ok(
                listarDoctoresQueryHandler.handle(new ListarDoctoresQuery())
        );
    }
}
