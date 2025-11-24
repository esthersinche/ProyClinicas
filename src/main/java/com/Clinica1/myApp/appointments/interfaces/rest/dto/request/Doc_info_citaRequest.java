package com.Clinica1.myApp.appointments.interfaces.rest.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Doc_info_citaRequest {
    @NotBlank(message = "Full name of the doctor is required")
    private String nom_com_doc;
    @NotBlank
    private String espe_doc;
    @NotBlank
    private String consult_doc;
}
