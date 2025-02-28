package br.com.enzomoralesl.medapp.service;


import br.com.enzomoralesl.medapp.controller.medicalrecord.model.MedicalRecordRequest;
import br.com.enzomoralesl.medapp.controller.medicalrecord.model.MedicalRecordResponse;
import br.com.enzomoralesl.medapp.infrastructure.exception.ResourceNotFoundException;
import br.com.enzomoralesl.medapp.repository.IJPAMedicalRecordRepository;
import br.com.enzomoralesl.medapp.repository.IJPAPatientRepository;
import br.com.enzomoralesl.medapp.repository.entities.JpaMedicalRecordEntity;
import br.com.enzomoralesl.medapp.repository.entities.JpaPatientEntity;
import br.com.enzomoralesl.medapp.utils.mapper.IMedicalRecordMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;


@Service
public class MedicalRecordService implements IMedicalRecordService {

    private final IJPAMedicalRecordRepository medicalRecordRepository;
    private final IJPAPatientRepository patientRepository;
    private final IMedicalRecordMapper mapper;

    public MedicalRecordService(IJPAMedicalRecordRepository medicalRecordRepository, IJPAPatientRepository patientRepository, @Qualifier("IMedicalRecordMapperImpl") IMedicalRecordMapper mapper) {
        this.medicalRecordRepository = medicalRecordRepository;
        this.patientRepository = patientRepository;
        this.mapper = mapper;
    }

    @Override
    @Transactional
    public MedicalRecordResponse save(MedicalRecordRequest request) {
        JpaPatientEntity patient = patientRepository.findByEmail(request.emailPatient())
                .orElseThrow(() -> new ResourceNotFoundException("Patient not found with email " + request.emailPatient()));

        JpaMedicalRecordEntity medicalRecordEntity = mapper.toJpaMedicalRecordEntity(request, patient);
        medicalRecordRepository.save(medicalRecordEntity);


        return new MedicalRecordResponse(medicalRecordEntity.getId(), medicalRecordEntity.getTeste(), medicalRecordEntity.getPatient().getId());
    }

    @Override
    public MedicalRecordResponse fetch(Map<String, String> requestMap) {
        JpaMedicalRecordEntity medicalRecordEntity = medicalRecordRepository.findByPatientEmail(requestMap.get("email"))
                .orElseThrow(() -> new ResourceNotFoundException("Medical Record not found with email " + requestMap.get("email")));

        return new MedicalRecordResponse(medicalRecordEntity.getId(), medicalRecordEntity.getTeste(), medicalRecordEntity.getPatient().getId());
    }
}
