package com.Clinica1.myApp.appointments.interfaces.rest.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
//dto q llegan en cuerpo de peticiones
public class CrearCitaRequest {

    @NotBlank(message = "Motivo is required")
    private String motivo;

    @NotBlank(message = "Especialidad is required")
    private String especialidad;

    @NotBlank(message = "Canal is required")
    private String canal;

    @NotNull(message = "Fecha y hora de inicio is required")
    private LocalDateTime inicio;

    @NotNull(message = "Fecha y hora de fin is required")
    private LocalDateTime fin;

    @NotBlank(message = "ID paciente is required")
    private String pacienteId;

    @NotBlank(message = "ID doctor is required")
    private String doctorId;

}
