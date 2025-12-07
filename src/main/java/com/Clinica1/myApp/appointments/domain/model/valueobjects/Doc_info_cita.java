package com.Clinica1.myApp.appointments.domain.model.valueobjects;

public record Doc_info_cita(
        String nombreCompleto,
        String especialidad,
        String consultorio,
        String cmp
) {

    public Doc_info_cita {
        if (nombreCompleto == null || nombreCompleto.isBlank()) {
            throw new IllegalArgumentException("El nombre del doctor no puede estar vacío");
        }

        if (especialidad == null || especialidad.isBlank()) {
            throw new IllegalArgumentException("La especialidad no puede estar vacía");
        }

        if (consultorio == null || consultorio.isBlank()) {
            throw new IllegalArgumentException("El consultorio no puede estar vacío");
        }

        if (cmp == null || cmp.isBlank()) {
            throw new IllegalArgumentException("El CMP no puede estar vacío");
        }
    }

    public static Doc_info_cita of(
            String nombreCompleto,
            String especialidad,
            String consultorio,
            String cmp
    ) {
        return new Doc_info_cita(nombreCompleto, especialidad, consultorio, cmp);
    }
}