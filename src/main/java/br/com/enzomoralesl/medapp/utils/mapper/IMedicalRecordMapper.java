package br.com.enzomoralesl.medapp.utils.mapper;

import br.com.enzomoralesl.medapp.controller.medicalrecord.model.MedicalRecordRequest;
import br.com.enzomoralesl.medapp.repository.entities.JpaMedicalRecordEntity;
import br.com.enzomoralesl.medapp.repository.entities.JpaPatientEntity;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface IMedicalRecordMapper {

    default JpaMedicalRecordEntity toJpaMedicalRecordEntity(MedicalRecordRequest request, JpaPatientEntity patient) {
        if (request == null) {
            return null;
        }
        JpaMedicalRecordEntity jpaMedicalRecordEntity = new JpaMedicalRecordEntity();
        jpaMedicalRecordEntity.setTeste( request.teste() );
        jpaMedicalRecordEntity.setPatient(patient);
        return jpaMedicalRecordEntity;
    }
}
