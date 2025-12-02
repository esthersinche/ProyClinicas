package com.Clinica1.myApp.appointments.interfaces.rest.mapper;

import com.Clinica1.myApp.appointments.application.command.CrearPacienteCommand;
import com.Clinica1.myApp.appointments.domain.model.aggregates.Paciente;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

class PacienteCommandMapperTest {

    @Test
    void interface_hasRequiredMethod() throws Exception {
        Method m = PacienteCommandMapper.class
                .getDeclaredMethod("toDomain", CrearPacienteCommand.class);

        assertNotNull(m);
        assertEquals(Paciente.class, m.getReturnType());
    }
}
