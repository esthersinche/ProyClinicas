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

    @NotBlank(message = "DNI is required")
    private String dni_pac;

    @NotBlank(message = "Motivo is required")
    private String motivo_cita;

    @NotBlank(message = "Especialidad is required")
    private String espe_cita;

    @NotBlank(message = "Estado is required")
    private String estado_cita;

    @NotBlank(message = "Canal is required")
    private String canal_cita;

    @NotNull(message = "Fecha y hora de inicio is required")
    private LocalDateTime inicio_cita;

    @NotNull(message = "Fecha y hora de fin is required")
    private LocalDateTime fin_cita;

    //id de pac y doc
    @NotBlank(message = "ID paciente is required")
    private String id_pac;
    @NotBlank(message = "ID doctor is required")
    private String id_doc;

    //porsiacaso yknow
    @Valid
    @NotNull(message = "Info de paciente is required")
    private Pac_info_citaRequest pac_info_req;
    @Valid
    @NotNull(message = "Info de doctor is required")
    private Doc_info_citaRequest doc_info_req;

}
