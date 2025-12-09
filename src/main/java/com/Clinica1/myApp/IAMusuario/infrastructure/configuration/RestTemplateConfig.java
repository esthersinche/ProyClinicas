package com.Clinica1.myApp.IAMusuario.infrastructure.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;


@Configuration
public class RestTemplateConfig {
    @Bean
    public RestTemplate rest_temp(
            @Value("${mantenimiendo.http.connect-timeout-ms:2000}") int con_timeout_out,
            @Value("${mantenimiento.http.read-timeout-ms:5000}") int read_timeout
    ){
        SimpleClientHttpRequestFactory req_fact= new SimpleClientHttpRequestFactory();
        req_fact.setConnectTimeout(con_timeout_out);
        req_fact.setReadTimeout(read_timeout);
        return new RestTemplate();
    }
}
