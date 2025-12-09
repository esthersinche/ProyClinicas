package com.Clinica1.myApp.mantenimiento.interfaces.rest.controller;

import com.Clinica1.myApp.mantenimiento.application.command.AuthValidateCommand;
import com.Clinica1.myApp.mantenimiento.interfaces.rest.dto.request.AuthValidateRequest;
import com.Clinica1.myApp.mantenimiento.application.dto.EmpleadoMinimalDto;
import com.Clinica1.myApp.mantenimiento.application.handler.AuthValidateCommandHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthValidateCommandHandler handler;

    @PostMapping("/validate")
    public ResponseEntity<EmpleadoMinimalDto> validate(
            @RequestBody AuthValidateRequest request) {

        EmpleadoMinimalDto dto =
                handler.handle(
                        new AuthValidateCommand(
                                request.getEmail(),
                                request.getPassword()
                        )
                );

        if (dto == null)
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();

        return ResponseEntity.ok(dto);
    }

    //lau: hara un controller para empleado? pq necesito el findbyid, es un @get
    /* public EmpleadoMinDto findEmpById(String id_empiam){
        String url= base_url + "/api/v1/empleados/{" + id_empiam + "}";

        HttpHeaders header2= new HttpHeaders();
        header2.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Void> tommyheavenly6= new HttpEntity<>(header2);

        try{
            ResponseEntity<EmpleadoMinDto> soul_eater_resp= rest_temp.exchange(url, HttpMethod.GET, tommyheavenly6,
                    EmpleadoMinDto.class);
            return soul_eater_resp.getBody();
        }catch (HttpClientErrorException.NotFound given){
            //empleado no encontrado en manteniminedo pipipi
            return null;
        } catch (HttpClientErrorException yoru_no_akeru){
            //error 4xx
            throw new ExternalServiceException("Error 4xx al intentar obtener empleado por ID" + yoru_no_akeru.getStatusCode(),
                    yoru_no_akeru);

        } catch (Exception tricker){
            throw new ExternalServiceException("Error al comunicarse con mantenimiento", tricker);

        }

    }*/
}