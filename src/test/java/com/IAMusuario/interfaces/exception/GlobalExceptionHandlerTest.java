package com.IAMusuario.interfaces.exception;

import com.Clinica1.myApp.IAMusuario.domain.exception.CredencialesInvalidasException;
import com.Clinica1.myApp.IAMusuario.domain.interfaces.rest.exception.GlobalExceptionHandler;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.lang.reflect.Method;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class GlobalExceptionHandlerTest {

    @Test
    void testGlobalExceptionHandlerCompleto() throws Exception {

        GlobalExceptionHandler handler = new GlobalExceptionHandler();

        BindingResult bindingResult = mock(BindingResult.class);
        Method method = String.class.getMethod("toString");
        MethodArgumentNotValidException manve =
                new MethodArgumentNotValidException(null, bindingResult);

        when(bindingResult.getFieldErrors()).thenReturn(
                java.util.List.of(
                        new FieldError("obj", "username", "El username es obligatorio"),
                        new FieldError("obj", "password", "La contraseña es obligatoria")
                )
        );

        ResponseEntity<Map<String, Object>> response1 =
                handler.handleValidationErrors(manve);

        assertEquals(HttpStatus.BAD_REQUEST, response1.getStatusCode());
        Map<String, Object> body1 = response1.getBody();

        assertNotNull(body1);
        assertEquals(400, body1.get("status"));
        Map<String, String> errors = (Map<String, String>) body1.get("errors");
        assertEquals("El username es obligatorio", errors.get("username"));
        assertEquals("La contraseña es obligatoria", errors.get("password"));

        CredencialesInvalidasException credEx =
                new CredencialesInvalidasException("Usuario o contraseña incorrectos");

        ResponseEntity<Map<String, Object>> response2 =
                handler.handleCredencialesInvalidas(credEx);

        assertEquals(HttpStatus.UNAUTHORIZED, response2.getStatusCode());
        Map<String, Object> body2 = response2.getBody();

        assertNotNull(body2);
        assertEquals(401, body2.get("status"));
        assertEquals("Usuario o contraseña incorrectos", body2.get("message"));

        Exception genericEx = new Exception("Error X");

        ResponseEntity<Map<String, Object>> response3 =
                handler.handleGeneric(genericEx);

        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response3.getStatusCode());
        Map<String, Object> body3 = response3.getBody();

        assertNotNull(body3);
        assertEquals(500, body3.get("status"));
        assertEquals("Ha ocurrido un error inesperado", body3.get("message"));
    }
}
