package com.Clinica1.myApp.mantenimiento.application.command;

public class ActualizarEmpleadoCommand {private final String id;
    private final String nombre;
    private final String apellido;
    private final String telefono;

    public ActualizarEmpleadoCommand(String id, String nombre,
                                     String apellido, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
    }

    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public String getApellido() { return apellido; }
    public String getTelefono() { return telefono; }
}