package com.Clinica1.myApp.mantenimiento.application.dto;

import java.util.List;

public record DoctorDto(
        String id,
        String nombre,
        String apellido,
        String telefono,
        String email,
        String cmp,
        String consultorio,
        List<String> especialidades
) {}