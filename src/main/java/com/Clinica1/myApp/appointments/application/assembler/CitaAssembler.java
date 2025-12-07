package com.Clinica1.myApp.appointments.application.assembler;

import com.Clinica1.myApp.appointments.application.dto.*;
import com.Clinica1.myApp.appointments.domain.model.aggregates.Cita;
import com.Clinica1.myApp.appointments.domain.model.aggregates.Doctor;
import com.Clinica1.myApp.appointments.domain.model.aggregates.Paciente;
import com.Clinica1.myApp.appointments.domain.model.valueobjects.Canal;
import com.Clinica1.myApp.appointments.domain.model.valueobjects.Doc_info_cita;
import com.Clinica1.myApp.appointments.domain.model.valueobjects.Especialidad;
import com.Clinica1.myApp.appointments.domain.model.valueobjects.Pac_info_cita;

import java.time.LocalDateTime;

public class CitaAssembler {

    public CitaDto toDto(Cita cita) {
        if (cita == null) return null;

        return new CitaDto(
                cita.getId_cita().obtenerid(),
                cita.getMotivo_cita(),
                cita.getEstado_cita().name(),
                cita.getCanal_cita().name(),
                cita.getInicio_cita(),
                cita.getFin_cita(),
                toPacienteInfoDto(cita.getInst_pac()),
                toDoctorInfoDto(cita.getInst_doctor()),
                cita.getEspe_cita() != null ? cita.getEspe_cita().nom_espe() : null
        );
    }

    // ------- SOLO LA INFO RESUMIDA DEL PACIENTE -------
    public PacienteInfoDto toPacienteInfoDto(Pac_info_cita pac) {
        return new PacienteInfoDto(
                pac.nomb_com_pac(),
                pac.dni_pac()
        );
    }

    // ------- SOLO LA INFO RESUMIDA DEL DOCTOR -------
    public DoctorInfoDto toDoctorInfoDto(Doc_info_cita doc) {
        return new DoctorInfoDto(
                doc.nombreCompleto(),
                doc.especialidad(),
                doc.consultorio(),
                doc.cmp()
        );
    }

}
