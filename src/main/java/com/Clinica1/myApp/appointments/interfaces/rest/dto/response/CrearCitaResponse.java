package com.Clinica1.myApp.appointments.interfaces.rest.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//dto q se devuelve al cliente
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CrearCitaResponse {

    private String cita_id;
    private String message_cita;//mensaje q enviara si es exitoso
}
