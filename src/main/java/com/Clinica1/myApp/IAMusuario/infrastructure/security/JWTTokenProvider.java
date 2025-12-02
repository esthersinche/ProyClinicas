package com.Clinica1.myApp.IAMusuario.infrastructure.security;


import com.Clinica1.myApp.IAMusuario.application.exception.JWTInvalidException;
import com.Clinica1.myApp.SharedKernel.IDEntidad;
import com.Clinica1.myApp.SharedKernel.UsuarioWeb;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;


import com.Clinica1.myApp.IAMusuario.application.services.TokenProvider;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.time.Instant;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


@Component
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
    public String generartokendeacceso(UsuarioWeb usu_web){
        Instant ahora= Instant.now();
        Date inicio= Date.from(ahora);
        Date expiracion= Date.from(ahora.plusSeconds(accesstokensc));

        //claims adicionales
        Map<String, Object> claimsadds= new HashMap<>();
        if (usu_web.getId_emp() != null){
            claimsadds.put("id_emp", usu_web.getId_emp().obtenerid());
        }

        if(usu_web.getId_cli() != null){
            claimsadds.put("id_cli", usu_web.getId_cli().obtenerid());
        }

        //constructor del jwt
        JwtBuilder blackbullet= Jwts.builder().setId(IDEntidad.generar().obtenerid())
                .setSubject(usu_web.getId_usu().obtenerid())
                .setIssuedAt(inicio)
                .setExpiration(expiracion)
                .addClaims(claimsadds);

        return blackbullet.signWith(sec_key, SignatureAlgorithm.HS256).compact();
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
