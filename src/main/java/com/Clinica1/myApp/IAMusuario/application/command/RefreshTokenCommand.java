package com.Clinica1.myApp.IAMusuario.application.command;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
@Builder
public class RefreshTokenCommand {
    private String refreshtoken;
}
