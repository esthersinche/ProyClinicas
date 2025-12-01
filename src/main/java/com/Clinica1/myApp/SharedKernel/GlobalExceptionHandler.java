package com.Clinica1.myApp.SharedKernel;

import com.Clinica1.myApp.appointments.application.exception.CitaNoEncontradaException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CitaNoEncontradaException.class)
    public ResponseEntity<?> handleCitaNotFound(CitaNoEncontradaException ex) {
        return ResponseEntity.status(404).body(
                Map.of("error", ex.getMessage())
        );
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<?> handleIllegalArgument(IllegalArgumentException ex) {
        return ResponseEntity.badRequest().body(
                Map.of("error", ex.getMessage())
        );
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleGeneral(Exception ex) {
        // Útil durante desarrollo:
        return ResponseEntity.status(500).body(
                Map.of("error", ex.getMessage())
        );
    }
}