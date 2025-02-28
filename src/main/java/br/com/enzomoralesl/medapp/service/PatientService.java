package br.com.enzomoralesl.medapp.service;

import br.com.enzomoralesl.medapp.controller.patient.model.PatientRequest;
import br.com.enzomoralesl.medapp.controller.patient.model.PatientResponse;
import br.com.enzomoralesl.medapp.infrastructure.exception.ResourceNotFoundException;
import br.com.enzomoralesl.medapp.repository.IJPAPatientRepository;
import br.com.enzomoralesl.medapp.repository.entities.JpaPatientEntity;
import br.com.enzomoralesl.medapp.utils.mapper.IPatientMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class PatientService implements IPatientService {

    public IMedicalRecordService medicalRecordService;
    private final IJPAPatientRepository jpaPatientRepository;
    private final IPatientMapper mapper;

    public PatientService(IMedicalRecordService medicalRecordService,
                          IJPAPatientRepository jpaPatientRepository,
                          @Qualifier("IPatientMapperImpl") IPatientMapper mapper) {
        this.medicalRecordService = medicalRecordService;
        this.jpaPatientRepository = jpaPatientRepository;
        this.mapper = mapper;
    }

    @Override
    public PatientResponse save(PatientRequest request) {
        JpaPatientEntity patientEntity = mapper.toJpaPatientEntity(request);
        jpaPatientRepository.save(patientEntity);

        return new PatientResponse(
                patientEntity.getId(),
                patientEntity.getEmail(),
                patientEntity.getName(),
                patientEntity.getCpf(),
                patientEntity.getPassword(),
                patientEntity.getPhone(),
                patientEntity.getBirthDate());
    }

    @Override
    public PatientResponse fetch(Map<String, String> request) {
        JpaPatientEntity patientEntity = this.jpaPatientRepository.findByEmail(request.get("email"))
                .orElseThrow(() -> new ResourceNotFoundException("Paciente não encontrado na base de dados"));

        return new PatientResponse(
                patientEntity.getId(),
                patientEntity.getEmail(),
                patientEntity.getName(),
                patientEntity.getCpf(),
                patientEntity.getPassword(),
                patientEntity.getPhone(),
                patientEntity.getBirthDate());
    }
}
