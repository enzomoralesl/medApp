package br.com.enzomoralesl.medapp.service;


import br.com.enzomoralesl.medapp.DTOs.medicalrecords.SurgeryDTO;
import br.com.enzomoralesl.medapp.controller.medicalrecord.model.MedicalRecordRequest;
import br.com.enzomoralesl.medapp.controller.medicalrecord.model.MedicalRecordResponse;
import br.com.enzomoralesl.medapp.infrastructure.exception.ResourceNotFoundException;
import br.com.enzomoralesl.medapp.repository.IJPAMedicalRecordRepository;
import br.com.enzomoralesl.medapp.repository.IJPAPatientRepository;
import br.com.enzomoralesl.medapp.repository.IJPASurgeryRepository;
import br.com.enzomoralesl.medapp.repository.entities.JPAMedicalRecordEntity;
import br.com.enzomoralesl.medapp.repository.entities.JPAPatientEntity;
import br.com.enzomoralesl.medapp.repository.entities.JPASurgeryEntity;
import br.com.enzomoralesl.medapp.utils.mapper.IMedicalRecordMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Service
public class MedicalRecordService implements IMedicalRecordService {

    private final IJPAMedicalRecordRepository medicalRecordRepository;
    private final IJPASurgeryRepository surgeryRepository;
    private final IJPAPatientRepository patientRepository;
    private final IMedicalRecordMapper mapper;

    public MedicalRecordService(IJPAMedicalRecordRepository medicalRecordRepository,
                                IJPASurgeryRepository surgeryRepository, IJPAPatientRepository patientRepository,
                                @Qualifier("IMedicalRecordMapperImpl") IMedicalRecordMapper mapper) {
        this.medicalRecordRepository = medicalRecordRepository;
        this.surgeryRepository = surgeryRepository;
        this.patientRepository = patientRepository;
        this.mapper = mapper;
    }

    @Override
    @Transactional
    public MedicalRecordResponse save(MedicalRecordRequest request) {
        JPAPatientEntity patient = patientRepository.findByEmail(request.emailPatient())
                .orElseThrow(() -> new ResourceNotFoundException("Patient not found with email " + request.emailPatient()));
        JPAMedicalRecordEntity medicalRecordEntity = mapper.toJPAMedicalRecordEntity(request, patient);
        medicalRecordRepository.save(medicalRecordEntity);
        List<SurgeryDTO> surgeries = new ArrayList<>();

        return new MedicalRecordResponse(medicalRecordEntity.getId(), surgeries, medicalRecordEntity.getPatient().getId());
    }

    @Override
    public MedicalRecordResponse fetch(Map<String, String> requestMap) {
        JPAMedicalRecordEntity medicalRecordEntity = medicalRecordRepository.findByPatientEmail(requestMap.get("email"))
                .orElseThrow(() -> new ResourceNotFoundException("Medical Record not found with email " + requestMap.get("email")));

        List<SurgeryDTO> surgeries;
        List<JPASurgeryEntity> surgeryEntityList = surgeryRepository.findByMedicalRecordId(medicalRecordEntity.getId()).orElse(null);
        surgeries = mapper.toSurgeryDTO(surgeryEntityList);
        return new MedicalRecordResponse(medicalRecordEntity.getId(), surgeries, medicalRecordEntity.getPatient().getId());
    }
}
