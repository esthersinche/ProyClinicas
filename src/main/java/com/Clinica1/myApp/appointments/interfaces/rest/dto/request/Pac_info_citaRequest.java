package com.Clinica1.myApp.appointments.interfaces.rest.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pac_info_citaRequest {
    @NotBlank()
    private String nom_com_pac;
    @NotBlank(message = "DNI is required")
    private String dni_pac;
}
