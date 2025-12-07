package com.Clinica1.myApp.appointments.application.assembler;

import com.Clinica1.myApp.appointments.domain.model.aggregates.Doctor;
import com.Clinica1.myApp.appointments.domain.model.valueobjects.Doc_info_cita;
import com.Clinica1.myApp.appointments.domain.model.valueobjects.Especialidad;

public class DoctorInfoAssembler {
    public static Doc_info_cita fromDoctor(Doctor doctor, Especialidad especialidad) {
        return Doc_info_cita.of(
                doctor.getNom_com_doc().completar(),
                especialidad.nom_espe(),
                doctor.getConsultorio_doc(),
                doctor.getCmp_doc()
        );
    }
}
