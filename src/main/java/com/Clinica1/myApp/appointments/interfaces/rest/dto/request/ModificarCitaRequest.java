package com.Clinica1.myApp.appointments.interfaces.rest.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ModificarCitaRequest {
        @NotBlank(message = "El motivo no puede estar vacío")
        private String motivo;

        @NotNull(message = "La nueva fecha y hora de inicio es requerida")
        private LocalDateTime inicio;

        @NotNull(message = "La nueva fecha y hora de fin es requerida")
        private LocalDateTime fin;

        // Opcional: si se quiere reasignar doctor
        private String doctorId;
}
