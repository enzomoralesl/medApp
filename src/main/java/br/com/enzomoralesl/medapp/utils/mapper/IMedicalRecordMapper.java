package br.com.enzomoralesl.medapp.utils.mapper;

import br.com.enzomoralesl.medapp.DTOs.medicalrecords.SurgeryDTO;
import br.com.enzomoralesl.medapp.controller.medicalrecord.model.MedicalRecordRequest;
import br.com.enzomoralesl.medapp.repository.entities.JPAMedicalRecordEntity;
import br.com.enzomoralesl.medapp.repository.entities.JPAPatientEntity;
import br.com.enzomoralesl.medapp.repository.entities.JPASurgeryEntity;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.stream.Collectors;


@Mapper(componentModel = "spring")
public interface IMedicalRecordMapper {

    default JPAMedicalRecordEntity toJPAMedicalRecordEntity(MedicalRecordRequest request, JPAPatientEntity patient) {
        if (request == null) {
            return null;
        }
        JPAMedicalRecordEntity jpaMedicalRecordEntity = new JPAMedicalRecordEntity();
        jpaMedicalRecordEntity.setPatient(patient);
        return jpaMedicalRecordEntity;
    }

    default List<SurgeryDTO> toSurgeryDTO(List<JPASurgeryEntity> surgeries) {
        if (surgeries == null) {
            return null;
        }
        return surgeries.stream().map(surgery -> {
            SurgeryDTO surgeryDTO = new SurgeryDTO();
            surgeryDTO.setDate(surgery.getDate());
            surgeryDTO.setDoctorCRM(surgery.getDoctorCRM());
            surgeryDTO.setDoctorName(surgery.getDoctorName());
            surgeryDTO.setDescription(surgery.getDescription());
            surgeryDTO.setType(surgery.getType());
            return surgeryDTO;
        }).collect(Collectors.toList());
    }
}
