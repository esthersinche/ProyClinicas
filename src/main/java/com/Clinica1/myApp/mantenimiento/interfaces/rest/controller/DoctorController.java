package com.Clinica1.myApp.mantenimiento.interfaces.rest.controller;

import com.Clinica1.myApp.SharedKernel.IDEntidad;
import com.Clinica1.myApp.mantenimiento.application.command.ActualizarDoctorCommand;
import com.Clinica1.myApp.mantenimiento.application.command.CrearDoctorCommand;
import com.Clinica1.myApp.mantenimiento.application.command.EliminarDoctorCommand;
import com.Clinica1.myApp.mantenimiento.application.dto.DoctorDto;
import com.Clinica1.myApp.mantenimiento.application.dto.DoctorListadoDto;
import com.Clinica1.myApp.mantenimiento.application.handler.*;
import com.Clinica1.myApp.mantenimiento.application.query.BuscarDoctorPorCMPQuery;
import com.Clinica1.myApp.mantenimiento.application.query.BuscarDoctorPorNombreQuery;
import com.Clinica1.myApp.mantenimiento.application.query.ListarDoctoresQuery;
import com.Clinica1.myApp.mantenimiento.interfaces.rest.dto.request.ActualizarDoctorRequest;
import com.Clinica1.myApp.mantenimiento.interfaces.rest.dto.request.CrearDoctorRequest;
import com.Clinica1.myApp.mantenimiento.interfaces.rest.mapper.DoctorRequestMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/mantenimiento/doctores")
@RequiredArgsConstructor
public class DoctorController {

    private final DoctorRequestMapper requestMapper;
    private final CrearDoctorCommandHandler crearHandler;
    private final ActualizarDoctorCommandHandler actualizarHandler;
    private final EliminarDoctorCommandHandler eliminarHandler;
    private final ListarDoctoresQueryHandler listarHandler;
    private final BuscarDoctorPorNombreHandler buscarNombreHandler;

    @PostMapping
    public ResponseEntity<Void> crear(@RequestBody CrearDoctorRequest request) {
        crearHandler.handle(requestMapper.toCommand(request));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> actualizar(
            @PathVariable String id,
            @RequestBody ActualizarDoctorRequest request
    ) {
        actualizarHandler.handle(
                requestMapper.toCommand(id, request)
        );
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable String id) {
        eliminarHandler.handle(new EliminarDoctorCommand(id));
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<DoctorDto>> listar() {
        return ResponseEntity.ok(listarHandler.handle(new ListarDoctoresQuery()));
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<DoctorListadoDto>> buscarPorNombre(
            @RequestParam String nombre
    ) {
        return ResponseEntity.ok(
                buscarNombreHandler.handle(new BuscarDoctorPorNombreQuery(nombre))
        );
    }
}
