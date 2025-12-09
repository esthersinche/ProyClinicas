package com.Clinica1.myApp.IAMusuario.infrastructure.security;


import com.Clinica1.myApp.IAMusuario.application.dto.TokenDto;
import com.Clinica1.myApp.IAMusuario.application.exception.JWTInvalidException;
import com.Clinica1.myApp.IAMusuario.domain.model.aggregates.EmpleadoIAM;
import com.Clinica1.myApp.SharedKernel.IDEntidad;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;

import com.Clinica1.myApp.IAMusuario.application.services.TokenProvider;

import javax.crypto.SecretKey;
import java.time.Instant;
import java.util.*;

public class JWTTokenProvider implements TokenProvider {
    //genera tokens desde usuarioweb sin consultar empleado
    private final SecretKey sec_key;//clave para firmar el token
    private final long accesstokensc;//tiempo de vida del token en sg

    //inyecta
    public JWTTokenProvider(String sec_string, long accesstokensc) {
        //el metodo del keys crea una secret key valida desde los bytes del secret
        this.sec_key = Keys.hmacShaKeyFor(sec_string.getBytes());
        this.accesstokensc = accesstokensc;
    }

    @Override
    public TokenDto generartokendeacceso(EmpleadoIAM emp){
        Instant ahora= Instant.now();
        Date inicio= Date.from(ahora);
        Date expiracion= Date.from(ahora.plusSeconds(accesstokensc));

        //claims adicionales
        List<String> roles= new ArrayList<>();
        if (emp.getRol_empiam() != null){
            roles.add(emp.getRol_empiam().name());
        }
        Map<String, Object> claimsadds= new HashMap<>();
        claimsadds.put("roles", roles);

        //para email
        try{
            if (emp.getEmail_empiam() != null){
                claimsadds.put("email", emp.getEmail_empiam().email_valor());
            }
        } catch (Exception ignore){

        }

        //constructor del jwt
        JwtBuilder blackbullet= Jwts.builder().setId(IDEntidad.generar().obtenerid())
                .setSubject(emp.getId_empiam().obtenerid())
                .setIssuedAt(inicio)
                .setExpiration(expiracion)
                .addClaims(claimsadds);

        String kishi= blackbullet.signWith(sec_key, SignatureAlgorithm.HS256).compact();
        //funciones empty pq aqui no se asignan cosos
        return new TokenDto(kishi, emp.getId_empiam().obtenerid(), this.accesstokensc, Collections.emptyList());

        //construccion del tokendto, quiero dormir

    }

    @Override
    public void validartokendeacceso(String token){
        //parseclaimsjws valida la firma y lanza excepciones
        try{
            Jwts.parser().setSigningKey(sec_key).build().parseClaimsJws(token);
        } catch (JwtException ex){
            throw new JWTInvalidException("Invalid Token - "+ex.getMessage(), ex);
        }
    }

    @Override
    public String generarIdtoken(){
        return IDEntidad.generar().obtenerid();
    }

    @Override
    public Map<String, Object> parsear(String token2){
        Claims help= Jwts.parser().setSigningKey(sec_key).build().parseClaimsJws(token2).getBody();
        return new HashMap<>(help);
    }


}
