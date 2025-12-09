package com.Clinica1.myApp.mantenimiento.interfaces.rest.controller;

import com.Clinica1.myApp.mantenimiento.application.command.ActualizarEmpleadoCommand;
import com.Clinica1.myApp.mantenimiento.application.command.CrearEmpleadoCommand;
import com.Clinica1.myApp.mantenimiento.application.command.EliminarEmpleadoCommand;
import com.Clinica1.myApp.mantenimiento.application.handler.ActualizarEmpleadoCommandHandler;
import com.Clinica1.myApp.mantenimiento.application.handler.CrearEmpleadoCommandHandler;
import com.Clinica1.myApp.mantenimiento.application.handler.EliminarEmpleadoCommandHandler;
import com.Clinica1.myApp.mantenimiento.application.handler.ListarEmpleadosQueryHandler;
import com.Clinica1.myApp.mantenimiento.interfaces.rest.dto.request.ActualizarEmpleadoRequest;
import com.Clinica1.myApp.mantenimiento.interfaces.rest.dto.request.CrearEmpleadoRequest;
import com.Clinica1.myApp.mantenimiento.interfaces.rest.dto.response.EmpleadoResponse;
import com.Clinica1.myApp.mantenimiento.interfaces.rest.mapper.EmpleadoRestMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/mantenimiento/empleados")
@RequiredArgsConstructor
public class EmpleadoController {

    private final CrearEmpleadoCommandHandler crearHandler;
    private final ActualizarEmpleadoCommandHandler actualizarHandler;
    private final EliminarEmpleadoCommandHandler eliminarHandler;
    private final ListarEmpleadosQueryHandler listarHandler;
    private final EmpleadoRestMapper mapper;

    @PostMapping
    public ResponseEntity<String> crear(@RequestBody CrearEmpleadoRequest request) {

        String id = crearHandler.handle(
                CrearEmpleadoCommand.builder()
                        .nombre(request.getNombre())
                        .apellido(request.getApellido())
                        .telefono(request.getTelefono())
                        .email(request.getEmail())
                        .password(request.getPassword())
                        .rol(request.getRol())
                        .build()
        );

        return ResponseEntity.status(HttpStatus.CREATED).body(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> actualizar(
            @PathVariable String id,
            @RequestBody ActualizarEmpleadoRequest request
    ) {

        actualizarHandler.handle(
                ActualizarEmpleadoCommand.builder()
                        .id(id)
                        .nombre(request.getNombre())
                        .apellido(request.getApellido())
                        .telefono(request.getTelefono())
                        .build()
        );

        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable String id) {
        eliminarHandler.handle(new EliminarEmpleadoCommand(id));
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<EmpleadoResponse>> listar() {
        return ResponseEntity.ok(
                listarHandler.handle()
                        .stream()
                        .map(mapper::toResponse)
                        .toList()
        );
    }
}