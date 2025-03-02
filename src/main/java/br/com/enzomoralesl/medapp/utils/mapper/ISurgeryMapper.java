package br.com.enzomoralesl.medapp.utils.mapper;

import br.com.enzomoralesl.medapp.controller.surgery.model.SurgeryRequest;
import br.com.enzomoralesl.medapp.repository.entities.JPAMedicalRecordEntity;
import br.com.enzomoralesl.medapp.repository.entities.JPASurgeryEntity;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface ISurgeryMapper {

    default JPASurgeryEntity toJPASurgeryEntity(SurgeryRequest request, JPAMedicalRecordEntity medicalRecord) {
        if (request == null) {
            return null;
        }
        JPASurgeryEntity jpaSurgeryEntity = new JPASurgeryEntity();
        jpaSurgeryEntity.setMedicalRecord(medicalRecord);
        jpaSurgeryEntity.setDate(request.date());
        jpaSurgeryEntity.setDoctorCRM(request.doctorCRM());
        jpaSurgeryEntity.setDoctorName(request.doctorName());
        jpaSurgeryEntity.setDescription(request.description());
        jpaSurgeryEntity.setType(request.type());
        return jpaSurgeryEntity;
    }
}
