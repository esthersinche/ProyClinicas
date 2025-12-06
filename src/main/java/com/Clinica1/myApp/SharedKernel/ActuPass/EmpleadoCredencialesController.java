package com.Clinica1.myApp.SharedKernel.ActuPass;
import com.Clinica1.myApp.SharedKernel.Empleado;
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