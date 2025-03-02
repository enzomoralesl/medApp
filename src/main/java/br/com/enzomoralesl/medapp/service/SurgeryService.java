package br.com.enzomoralesl.medapp.service;

import br.com.enzomoralesl.medapp.controller.surgery.model.SurgeryRequest;
import br.com.enzomoralesl.medapp.controller.surgery.model.SurgeryResponse;
import br.com.enzomoralesl.medapp.infrastructure.exception.ResourceNotFoundException;
import br.com.enzomoralesl.medapp.repository.IJPAMedicalRecordRepository;
import br.com.enzomoralesl.medapp.repository.IJPASurgeryRepository;
import br.com.enzomoralesl.medapp.repository.entities.JPAMedicalRecordEntity;
import br.com.enzomoralesl.medapp.repository.entities.JPASurgeryEntity;
import br.com.enzomoralesl.medapp.utils.mapper.ISurgeryMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class SurgeryService implements ISurgeryService {

    private final IJPASurgeryRepository jpaSurgeryRepository;
    private final IJPAMedicalRecordRepository medicalRecordRepository;
    private final ISurgeryMapper mapper;

    public SurgeryService(IJPASurgeryRepository jpaSurgeryRepository,
                          IJPAMedicalRecordRepository medicalRecordRepository,
                          @Qualifier("ISurgeryMapperImpl") ISurgeryMapper mapper) {
        this.jpaSurgeryRepository = jpaSurgeryRepository;
        this.medicalRecordRepository = medicalRecordRepository;
        this.mapper = mapper;
    }

    @Override
    public SurgeryResponse save(SurgeryRequest request) {

        JPAMedicalRecordEntity medicalRecord = medicalRecordRepository.findByPatientEmail(request.patientEmail())
                .orElseThrow(() -> new ResourceNotFoundException("MedicalRecord not found with email " + request.patientEmail()));

        JPASurgeryEntity surgeryEntity = mapper.toJPASurgeryEntity(request, medicalRecord);
        jpaSurgeryRepository.save(surgeryEntity);
        return new SurgeryResponse(
                surgeryEntity.getId(), surgeryEntity.getDate(), surgeryEntity.getDoctorName(),
                surgeryEntity.getDoctorCRM(), surgeryEntity.getDescription(), surgeryEntity.getType());
    }
}
