package com.Clinica1.myApp.IAMusuario.interfaces.rest.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ValidarRequest {
    private String email_empiam;
    private String passhash_empiam;

}
