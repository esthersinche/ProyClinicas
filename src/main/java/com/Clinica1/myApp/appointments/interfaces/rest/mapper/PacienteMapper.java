package com.Clinica1.myApp.appointments.interfaces.rest.mapper;

import com.Clinica1.myApp.appointments.application.command.CrearPacienteCommand;
import com.Clinica1.myApp.appointments.application.dto.PacienteDto;
import org.springframework.stereotype.Component;

@Component
public class PacienteMapper {
    // DTO → Command
    public CrearPacienteCommand toCommand(PacienteDto dto) {
        return CrearPacienteCommand.builder()
                .id(dto.getId()) // puede ser null, el handler generará IDEntidad
                .nombre(dto.getNombre())
                .nacionalidad(dto.getNacionalidad())
                .dni(dto.getDni())
                .tel(dto.getTel())
                .email(dto.getEmail())  // ahora es String, correcto
                .fec_nac(dto.getFec_nac())
                .sexo(dto.getSexo())
                .build();
    }

    // Command → DTO (opcional)
    public PacienteDto toDto(CrearPacienteCommand command) {
        PacienteDto dto = new PacienteDto();
        dto.setId(command.getId());
        dto.setNombre(command.getNombre());
        dto.setNacionalidad(command.getNacionalidad());
        dto.setDni(command.getDni());
        dto.setTel(command.getTel());
        dto.setEmail(command.getEmail());
        dto.setFec_nac(command.getFec_nac());
        dto.setSexo(command.getSexo());
        return dto;
    }
}
