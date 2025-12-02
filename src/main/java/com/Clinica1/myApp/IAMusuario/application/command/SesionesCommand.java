package com.Clinica1.myApp.IAMusuario.application.command;

import com.Clinica1.myApp.SharedKernel.IDEntidad;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
@Builder
public class SesionesCommand {
    private IDEntidad id_ses;
}
