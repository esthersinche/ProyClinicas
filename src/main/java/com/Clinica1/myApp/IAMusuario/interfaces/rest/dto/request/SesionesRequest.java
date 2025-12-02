package com.Clinica1.myApp.IAMusuario.interfaces.rest.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
//tanto para usuarioweb como para empleado
public class SesionesRequest {
    @NotBlank
    private String id_ses;
}
