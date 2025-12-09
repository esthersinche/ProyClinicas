package com.Clinica1.myApp.mantenimiento.application.command;

public class EliminarEmpleadoCommand {

    private final String id;

    public EliminarEmpleadoCommand(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}