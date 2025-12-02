package com.Clinica1.myApp.appointments.interfaces.rest.mapper;


import com.Clinica1.myApp.SharedKernel.IDEntidad;
import com.Clinica1.myApp.appointments.application.assembler.CitaAssembler;
import com.Clinica1.myApp.appointments.application.command.CrearCitaCommand;
import com.Clinica1.myApp.appointments.application.dto.CitaDto;
import com.Clinica1.myApp.appointments.application.dto.PacienteInfoDto;
import com.Clinica1.myApp.appointments.domain.model.valueobjects.Doc_info_cita;
import com.Clinica1.myApp.appointments.domain.model.valueobjects.Pac_info_cita;
import com.Clinica1.myApp.appointments.interfaces.rest.dto.request.CrearCitaRequest;

/**
 * Mapper que convierte un request REST de creación de cita
 * a un comando de aplicación (CrearCitaCommand) que el handler puede procesar.
 */

public class CitaRequestMapper {
    /*
    private CitaAssembler cit_asse;
    private Pac_infoRequestMapper pacinfo_reqmap;
    private Doc_infoRequestMapper docingo_reqmap;


    // Constructor con inyección de dependencias
    public CitaRequestMapper(CitaAssembler citaAssembler,
                             Pac_infoRequestMapper pacInfoMapper,
                             Doc_infoRequestMapper docInfoMapper) {
        this.cit_asse = citaAssembler;
        this.pacinfo_reqmap = pacInfoMapper;
        this.docingo_reqmap = docInfoMapper;
    }
*/
    public CrearCitaCommand ToCommand(CrearCitaRequest request){
        /* aydua estonoeraxddd peor se queda porsiacaso
        Pac_info_cita pacinfo_cita= pacinfo_reqmap.toDomain(crear_cita_req.getPac_info_req());
        Doc_info_cita docinfo_cita= docingo_reqmap.toDomain(crear_cita_req.getDoc_info_req());
        CitaDto cita_dto= CitaDto.builder()
                .id(null) //por que se creara luego
                .motivo(crear_cita_req.getMotivo_cita())
                .canal(crear_cita_req.getCanal_cita())
                .inicio(crear_cita_req.getInicio_cita())
                .fin(crear_cita_req.getFin_cita())
                .paciente(cit_asse.toPacienteInfoDto(pacinfo_cita))
                .doctor(cit_asse.toDoctorInfoDto(docinfo_cita))
                .clinica(null)
                .especialidad(crear_cita_req.getEspe_cita())
                .build();*/
        return CrearCitaCommand.builder()
                .motivo(request.getMotivo())
                .canal(request.getCanal())
                .inicio(request.getInicio())
                .fin(request.getFin())
                .pacienteId(IDEntidad.astring(request.getPacienteId()))   // conversion de String a IDEntidad
                .doctorId(IDEntidad.astring(request.getDoctorId()))// clinica aún no usada
                .especialidad(request.getEspecialidad())
                .build();
    }


}
