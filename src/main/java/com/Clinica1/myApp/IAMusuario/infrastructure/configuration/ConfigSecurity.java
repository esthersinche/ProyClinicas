package com.Clinica1.myApp.IAMusuario.infrastructure.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class ConfigSecurity {
    @Bean
    public PasswordEncoder contraEncoder(){
        int trabajo= 12;//no se si ponerlo mas alto seria maslento pero mas seguro yknow
        return new BCryptPasswordEncoder(trabajo);
    }
}
