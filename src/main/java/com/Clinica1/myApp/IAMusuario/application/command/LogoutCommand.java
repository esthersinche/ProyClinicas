package com.Clinica1.myApp.IAMusuario.application.command;

import com.Clinica1.myApp.SharedKernel.IDEntidad;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LogoutCommand {
    private IDEntidad id_ses;
}
