package com.Clinica1.myApp.mantenimiento.application.command;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CrearEmpleadoCommand {
    private final String nombre;
    private final String apellido;
    private final String telefono;
    private final String email;
    private final String password;
    private final String rol;

    public CrearEmpleadoCommand(String nombre, String apellido,
                                String telefono, String email,
                                String password, String rol) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.email = email;
        this.password = password;
        this.rol = rol;
    }

    public String getNombre() { return nombre; }
    public String getApellido() { return apellido; }
    public String getTelefono() { return telefono; }
    public String getEmail() { return email; }
    public String getPassword() { return password; }
    public String getRol() { return rol; }
}