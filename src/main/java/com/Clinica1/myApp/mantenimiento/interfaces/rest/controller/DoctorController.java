package com.Clinica1.myApp.mantenimiento.interfaces.rest.controller;

import com.Clinica1.myApp.mantenimiento.application.command.CrearDoctorCommand;
import com.Clinica1.myApp.mantenimiento.application.dto.DoctorDto;
import com.Clinica1.myApp.mantenimiento.application.handler.CrearDoctorCommandHandler;
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
    private final CrearDoctorCommandHandler crearHandler;
    private final ListarDoctoresQueryHandler listarHandler;

    @PostMapping
    public ResponseEntity<String> crear(@RequestBody CrearDoctorCommand command) {
        var id = crearHandler.handle(command);
        return ResponseEntity.status(HttpStatus.CREATED).body(id);
    }

    @GetMapping
    public ResponseEntity<List<DoctorDto>> listar() {
        var lista = listarHandler.handle(new ListarDoctoresQuery());
        return ResponseEntity.ok(lista);
    }
}
