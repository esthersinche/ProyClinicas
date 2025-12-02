package com.Clinica1.myApp.IAMusuario.application.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SesionDto {
    private String token_id;
    private String emp_id;
    private Instant comienzo_dto;
    private Instant expiracion_dto;
}
