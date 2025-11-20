package com.Clinica1.myApp.appointments.application.assembler;

import com.Clinica1.myApp.appointments.application.dto.CitaDto;
import com.Clinica1.myApp.appointments.application.dto.PacienteDto;
import com.Clinica1.myApp.appointments.application.dto.DoctorDto;
import com.Clinica1.myApp.appointments.domain.model.aggregates.Cita;
import com.Clinica1.myApp.appointments.domain.model.aggregates.Doctor;
import com.Clinica1.myApp.appointments.domain.model.aggregates.Paciente;
import com.Clinica1.myApp.appointments.domain.model.valueobjects.Especialidad;

import java.util.stream.Collectors;

public class CitaAssembler {

    public CitaDto toDto(Cita cita) {
        if (cita == null) {
            return null;
        }
        
        return new CitaDto(
            null,
            cita.getMotivo_cita(),
            cita.getEstado_cita() != null ? cita.getEstado_cita().name() : null,
            cita.getCanal_cita() != null ? cita.getCanal_cita().name() : null,
            cita.getInicio_cita(),
            cita.getFin_cita(),
            toPacienteDto(cita.getInst_pac()),
            toDoctorDto(cita.getInst_doctor()),
            cita.getInst_clin() != null ? cita.getInst_clin().getNom_clin() : null,
            cita.getEspe_cita() != null ? cita.getEspe_cita().nom_espe() : null
        );
    }

    public PacienteDto toPacienteDto(Paciente paciente) {
        if (paciente == null) {
            return null;
        }
        
        return new PacienteDto(
            null,
            paciente.getNombre_com_pac(),
            paciente.getNacionalidad_pac(),
            paciente.getDni_pac(),
            paciente.getTel_pac(),
            paciente.getEmail_pac() != null ? paciente.getEmail_pac().email_valor() : null
        );
    }

    public DoctorDto toDoctorDto(Doctor doctor) {
        if (doctor == null) {
            return null;
        }
        
        return new DoctorDto(
            null,
            doctor.getNombre() + " " + doctor.getApellido(),
            doctor.getCmp_doc(),
            doctor.getConsultorio_doc(),
            doctor.getEspecialidades() != null 
                ? doctor.getEspecialidades().stream()
                    .map(Especialidad::nom_espe)
                    .collect(Collectors.toList())
                : null
        );
    }
}
