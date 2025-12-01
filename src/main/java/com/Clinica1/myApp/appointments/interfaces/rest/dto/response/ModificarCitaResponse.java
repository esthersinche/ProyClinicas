package com.Clinica1.myApp.appointments.interfaces.rest.dto.response;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ModificarCitaResponse {

    private String cita_id;
    private String message;
}