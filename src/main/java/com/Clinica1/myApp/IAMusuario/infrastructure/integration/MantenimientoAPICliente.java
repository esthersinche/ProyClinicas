package com.Clinica1.myApp.IAMusuario.infrastructure.integration;

import com.Clinica1.myApp.IAMusuario.domain.exception.ExternalServiceException;
import com.Clinica1.myApp.IAMusuario.interfaces.rest.dto.request.ValidarRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Component
public class MantenimientoAPICliente {
    private final RestTemplate rest_temp;
    private final String base_url;
    private final long time_out_sc;

    public MantenimientoAPICliente(RestTemplate rest_temp,
                                   @Value("${mantenimiento.base-url}") String base_url,
                                   @Value("${mantenimiento.timeout-seconds:5}") long time_out_sc){
        this.rest_temp= rest_temp;
        this.base_url= base_url;
        this.time_out_sc= time_out_sc;
    }

    public EmpleadoMinDto validar(String email_empiam, String passhash_empiam){

        String url= base_url + "/api/v1/auth/validate"; //cambiar si difiere
        ValidarRequest val_req= new ValidarRequest(email_empiam, passhash_empiam);

        HttpHeaders header= new HttpHeaders();
        header.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<ValidarRequest> starless_night= new HttpEntity<>(val_req, header);

        try{
            ResponseEntity<EmpleadoMinDto> nana_resp= rest_temp.exchange(url, HttpMethod.POST, starless_night,
                    EmpleadoMinDto.class);
            return nana_resp.getBody();
        } catch(HttpClientErrorException httpcli_e){
            if (httpcli_e.getStatusCode() == HttpStatus.UNAUTHORIZED){
                return null;//credencias invalidas
            }
            throw new ExternalServiceException("Error al comunicarse con mantenimiento (4xx)" + httpcli_e.getStatusCode(), httpcli_e);
        } catch(Exception nnnk){
            throw new ExternalServiceException("Error al comunicarse con mantenimiento" + nnnk.getMessage(), nnnk);

        }
    }

    public EmpleadoMinDto findEmpById(String id_empiam){
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

    }

}
