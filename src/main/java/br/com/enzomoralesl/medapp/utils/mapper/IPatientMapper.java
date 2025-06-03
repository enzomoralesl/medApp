package br.com.enzomoralesl.medapp.utils.mapper;

import br.com.enzomoralesl.medapp.controller.patient.model.PatientRequest;
import br.com.enzomoralesl.medapp.repository.entities.JPAPatientEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IPatientMapper {

//    @Mapping(source = "medicalRecord", target = "medicalRecord")
    JPAPatientEntity toJPAPatientEntity(PatientRequest patientRequest);

//    JPAMedicalRecordEntity medicalRecordDTOToJPAMedicalRecordEntity(MedicalRecordDTO medicalRecordDTO);

//    MedicalRecordDTO toMedicalRecordDTO(JPAMedicalRecordEntity jpaPatientEntity);
}
