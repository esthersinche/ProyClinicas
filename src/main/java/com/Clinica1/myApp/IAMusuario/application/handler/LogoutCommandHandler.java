package com.Clinica1.myApp.IAMusuario.application.handler;

import com.Clinica1.myApp.IAMusuario.application.command.LogoutCommand;
import com.Clinica1.myApp.IAMusuario.application.exception.InvalidCredentialsException;
import com.Clinica1.myApp.IAMusuario.application.services.LogoutService;
import com.Clinica1.myApp.IAMusuario.application.services.SesionRepositoryService;
import com.Clinica1.myApp.SharedKernel.IDEntidad;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LogoutCommandHandler implements LogoutService {
    private final SesionRepositoryService ses_repo_serv;


    @Override
    @Transactional
    public void logout(LogoutCommand logout_com){
        //ver si el id_ses esta presente para quitarlo
        if (logout_com.getId_ses() != null){
            String id_ses= logout_com.getId_ses().obtenerid();
            boolean eliminarquestionmark= ses_repo_serv.eliminarById(id_ses);
            return;
        }

        throw new InvalidCredentialsException("Id_Ses has to exist in order to logout");

    }
}
