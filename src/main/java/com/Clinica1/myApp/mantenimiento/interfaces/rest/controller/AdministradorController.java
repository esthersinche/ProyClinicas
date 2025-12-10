package com.Clinica1.myApp.mantenimiento.interfaces.rest.controller;


import com.Clinica1.myApp.SharedKernel.IDEntidad;
import com.Clinica1.myApp.mantenimiento.application.command.CrearAdministradorCommand;
import com.Clinica1.myApp.mantenimiento.application.command.EliminarAdministradorCommand;
import com.Clinica1.myApp.mantenimiento.application.handler.CrearAdministradorCommandHandler;
import com.Clinica1.myApp.mantenimiento.application.handler.EliminarAdministradorCommandHandler;
import com.Clinica1.myApp.mantenimiento.application.handler.ListarAdministradoresQueryHandler;
import com.Clinica1.myApp.mantenimiento.interfaces.rest.dto.request.CrearAdministradorRequest;
import com.Clinica1.myApp.mantenimiento.interfaces.rest.dto.response.AdministradorResponse;
import com.Clinica1.myApp.mantenimiento.interfaces.rest.mapper.AdministradorRestMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/mantenimiento/administradores")
@RequiredArgsConstructor
public class AdministradorController {

    private final CrearAdministradorCommandHandler crearHandler;
    private final EliminarAdministradorCommandHandler eliminarHandler;
    private final ListarAdministradoresQueryHandler listarHandler;

    @PostMapping
    public ResponseEntity<String> crear(@RequestBody CrearAdministradorRequest request) {

        String id = crearHandler.handle(
                new CrearAdministradorCommand(request.getIdEmpleado())
        );

        return ResponseEntity.status(HttpStatus.CREATED).body(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable String id) {

        eliminarHandler.handle(
                new EliminarAdministradorCommand(id)
        );

        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<AdministradorResponse>> listar() {

        return ResponseEntity.ok(
                listarHandler.handle()
                        .stream()
                        .map(dto -> new AdministradorResponse(
                                dto.getIdAdmin(),
                                dto.getIdEmpleado(),
                                dto.getNombreCompleto()
                        ))
                        .toList()
        );
    }
}