package com.Clinica1.myApp.SharedKernel.ActuPass;
import com.Clinica1.myApp.SharedKernel.IDEntidad;
import lombok.Getter;

@Getter
public class ActualizarCredencialesEmpleadoCommand {
    private IDEntidad idEmpleado;
    private String nuevaPassword;

    public ActualizarCredencialesEmpleadoCommand(IDEntidad idEmpleado, String nuevaPassword) {
        this.idEmpleado = idEmpleado;
        this.nuevaPassword = nuevaPassword;
    }
}