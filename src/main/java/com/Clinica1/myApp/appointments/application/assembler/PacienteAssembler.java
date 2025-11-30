package com.Clinica1.myApp.appointments.application.assembler;

import com.Clinica1.myApp.SharedKernel.IDEntidad;
import com.Clinica1.myApp.appointments.application.dto.PacienteDto;
import com.Clinica1.myApp.appointments.domain.model.aggregates.Paciente;
import com.Clinica1.myApp.appointments.domain.model.valueobjects.Email;
import org.springframework.stereotype.Component;

@Component
public class PacienteAssembler {

    public PacienteDto toDto(Paciente paciente) {
        return new PacienteDto(
                paciente.getId_pac().obtenerid(),
                paciente.getNombre_com_pac(),
                paciente.getNacionalidad_pac(),
                paciente.getDni_pac(),
                paciente.getTel_pac(),
                paciente.getEmail_pac().email_valor(),
                paciente.getFec_nac_pac(),
                paciente.getSexo_pac()
        );
    }

    public Paciente toEntity(PacienteDto dto) {
        return new Paciente(
                dto.getId() != null
                        ? IDEntidad.astring(dto.getId())
                        : IDEntidad.generar(),
                dto.getNombre(),
                dto.getNacionalidad(),
                dto.getDni(),
                dto.getTel(),
                Email.of(dto.getEmail()),
                dto.getFec_nac(),
                dto.getSexo()
        );
    }
}
