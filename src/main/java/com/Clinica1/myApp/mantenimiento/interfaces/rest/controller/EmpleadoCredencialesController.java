package com.Clinica1.myApp.mantenimiento.interfaces.rest.controller;
import com.Clinica1.myApp.mantenimiento.application.assembler.ActualizarCredencialesEmpleadoAssembler;
import com.Clinica1.myApp.mantenimiento.application.handler.ActualizarCredencialesEmpleadoHandler;
import com.Clinica1.myApp.mantenimiento.domain.model.aggregates.Empleado;
import com.Clinica1.myApp.mantenimiento.interfaces.rest.dto.request.ActualizarCredencialesEmpleadoRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/empleados/credenciales")
@RequiredArgsConstructor
public class EmpleadoCredencialesController {

    private final ActualizarCredencialesEmpleadoHandler handler;
    private final ActualizarCredencialesEmpleadoAssembler assembler;

    @PutMapping("/actupass")
    public ResponseEntity<?> actualizarCredenciales(
            @RequestBody ActualizarCredencialesEmpleadoRequest request) {

        var command = assembler.toCommand(request);

        Empleado actualizado = handler.handle(command);

        return ResponseEntity.ok("Contraseña actualizada para empleado: "
                + actualizado.getId_emp().obtenerid());
    }
}