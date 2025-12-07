package com.Clinica1.myApp.IAMusuario.application.handler;

import com.Clinica1.myApp.IAMusuario.application.command.LogoutCommand;
import com.Clinica1.myApp.IAMusuario.application.exception.InvalidCredentialsException;
import com.Clinica1.myApp.IAMusuario.domain.repository.SesionRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LogoutCommandHandler {
    private final SesionRepository ses_repo;


    @Transactional
    public void handle(LogoutCommand logout_com){
        //ver si el id_ses esta presente para quitarlo
        if (logout_com == null || logout_com.getId_ses() == null || logout_com.getId_ses().obtenerid().isBlank()){
            throw new InvalidCredentialsException("Id_Ses has to exist in order to logout");
        }


        ses_repo.delete(logout_com.getId_ses());

    }
}
