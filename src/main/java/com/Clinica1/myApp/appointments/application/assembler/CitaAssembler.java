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
        if (cita == null)
            return null;

        return new CitaDto(
                cita.getId_cita(),
                cita.getMotivo_cita(),
                cita.getEstado_cita() != null ? cita.getEstado_cita().name() : null,
                cita.getCanal_cita() != null ? cita.getCanal_cita().name() : null,
                cita.getInicio_cita(),
                cita.getFin_cita(),
                toPacienteInfoDto(cita.getInst_pac()),
                toDoctorInfoDto(cita.getInst_doctor()),
                null, // clinica aun no existe
                cita.getEspe_cita() != null ? cita.getEspe_cita().nom_espe() : null);
    }

    // ------- SOLO LA INFO RESUMIDA DEL PACIENTE -------
    public PacienteInfoDto toPacienteInfoDto(Pac_info_cita pac) {
        if (pac == null)
            return null;
        return new PacienteInfoDto(
                pac.nomb_com_pac(),
                pac.dni_pac());
    }

    // ------- SOLO LA INFO RESUMIDA DEL DOCTOR -------
    public DoctorInfoDto toDoctorInfoDto(Doc_info_cita doc) {
        if (doc == null)
            return null;

        return new DoctorInfoDto(
                doc.nombre_doc(),
                doc.espe_doc(),
                doc.consult_doc());
    }

    public Pac_info_cita toPacInfoCita(PacienteInfoDto dto) {
        if (dto == null)
            return null;
        return new Pac_info_cita(dto.getNombre(), dto.getDni());
    }

    public Doc_info_cita toDocInfoCita(DoctorInfoDto dto) {
        if (dto == null)
            return null;
        return Doc_info_cita.of(dto.getNombre(), dto.getEspecialidad(), dto.getConsultorio());
    }

    public Especialidad toEspecialidad(String nombreEspe) {
        if (nombreEspe == null || nombreEspe.isBlank())
            return null;
        return Especialidad.of(nombreEspe);
    }

    public Cita toCita(String motivo, String canal, LocalDateTime inicio, LocalDateTime fin,
            Paciente paciente, Doctor doctor, String nombreEspecialidad) {
        return Cita.crearcita(
                motivo,
                Canal.valueOf(canal),
                inicio,
                fin,
                paciente,
                doctor,
                toEspecialidad(nombreEspecialidad));
    }
}
