package br.com.enzomoralesl.medapp.utils.mapper;

import br.com.enzomoralesl.medapp.DTOs.MedicalRecordDTO;
import br.com.enzomoralesl.medapp.controller.patient.model.PatientRequest;
import br.com.enzomoralesl.medapp.repository.entities.JpaMedicalRecordEntity;
import br.com.enzomoralesl.medapp.repository.entities.JpaPatientEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface IPatientMapper {

    @Mapping(source = "medicalRecord", target = "medicalRecord")
    JpaPatientEntity toJpaPatientEntity(PatientRequest patientRequest);

    @Mapping(source = "teste", target = "teste")
    JpaMedicalRecordEntity medicalRecordDTOToJpaMedicalRecordEntity(MedicalRecordDTO medicalRecordDTO);

    MedicalRecordDTO toMedicalRecordDTO(JpaMedicalRecordEntity jpaPatientEntity);
}
