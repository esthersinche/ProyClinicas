package com.Clinica1.myApp.mantenimiento.interfaces.rest.controller;

import com.Clinica1.myApp.mantenimiento.application.command.CrearRecepcionistaCommand;
import com.Clinica1.myApp.mantenimiento.application.command.EliminarRecepcionistaCommand;
import com.Clinica1.myApp.mantenimiento.application.handler.CrearRecepcionistaCommandHandler;
import com.Clinica1.myApp.mantenimiento.application.handler.EliminarRecepcionistaCommandHandler;
import com.Clinica1.myApp.mantenimiento.application.handler.ListarRecepcionistasQueryHandler;
import com.Clinica1.myApp.mantenimiento.interfaces.rest.dto.request.CrearRecepcionistaRequest;
import com.Clinica1.myApp.mantenimiento.interfaces.rest.dto.response.RecepcionistaResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/mantenimiento/recepcionistas")
@RequiredArgsConstructor
public class RecepcionistaController {

    private final CrearRecepcionistaCommandHandler crearHandler;
    private final EliminarRecepcionistaCommandHandler eliminarHandler;
    private final ListarRecepcionistasQueryHandler listarHandler;

    @PostMapping
    public ResponseEntity<String> crear(@RequestBody CrearRecepcionistaRequest request) {

        String id = crearHandler.handle(
                new CrearRecepcionistaCommand(request.getIdEmpleado())
        );

        return ResponseEntity.status(HttpStatus.CREATED).body(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable String id) {

        eliminarHandler.handle(
                new EliminarRecepcionistaCommand(id)
        );

        return ResponseEntity.noContent().build();
    }

    // ✅ Listar
    @GetMapping
    public ResponseEntity<List<RecepcionistaResponse>> listar() {

        return ResponseEntity.ok(
                listarHandler.handle()
                        .stream()
                        .map(dto -> new RecepcionistaResponse(
                                dto.getIdRecepcionista(),
                                dto.getIdEmpleado(),
                                dto.getNombreCompleto()
                        ))
                        .toList()
        );
    }
}