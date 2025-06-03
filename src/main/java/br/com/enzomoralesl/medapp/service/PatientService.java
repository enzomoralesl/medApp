package br.com.enzomoralesl.medapp.service;

import br.com.enzomoralesl.medapp.controller.patient.model.PatientRequest;
import br.com.enzomoralesl.medapp.controller.patient.model.PatientResponse;
import br.com.enzomoralesl.medapp.infrastructure.exception.ResourceNotFoundException;
import br.com.enzomoralesl.medapp.repository.IJPAPatientRepository;
import br.com.enzomoralesl.medapp.repository.entities.JPAPatientEntity;
import br.com.enzomoralesl.medapp.utils.mapper.IPatientMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PatientService implements IPatientService {

    private final IJPAPatientRepository jpaPatientRepository;
    private final IPatientMapper mapper;

    public PatientService(IJPAPatientRepository jpaPatientRepository,
                          @Qualifier("IPatientMapperImpl") IPatientMapper mapper) {
        this.jpaPatientRepository = jpaPatientRepository;
        this.mapper = mapper;
    }

    @Override
    public PatientResponse save(PatientRequest request) {
        JPAPatientEntity patientEntity = mapper.toJPAPatientEntity(request);
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
    public PatientResponse fetch(String request) {
        JPAPatientEntity patientEntity = this.jpaPatientRepository.findByEmail(request)
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

    @Override
    public PatientResponse update(String email, PatientRequest request) {
        JPAPatientEntity existingPatient = jpaPatientRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("Paciente não encontrado na base de dados"));

        existingPatient.setName(request.name());
        existingPatient.setCpf(request.cpf());
        existingPatient.setPassword(request.password());
        existingPatient.setPhone(request.phone());
        existingPatient.setBirthDate(request.birthDate());
        existingPatient.setEmail(request.email());

        JPAPatientEntity updatedEntity = jpaPatientRepository.save(existingPatient);

        return new PatientResponse(
                updatedEntity.getId(),
                updatedEntity.getEmail(),
                updatedEntity.getName(),
                updatedEntity.getCpf(),
                updatedEntity.getPassword(),
                updatedEntity.getPhone(),
                updatedEntity.getBirthDate());
    }

    @Override
    @Transactional
    public void delete(String email) {
        if (!jpaPatientRepository.existsByEmail(email)) {
            throw new ResourceNotFoundException("Paciente não encontrado na base de dados");
        }
        jpaPatientRepository.deleteByEmail(email);
    }

    @Override
    public List<PatientResponse> fetchAll() {
        return jpaPatientRepository.findAll().stream()
                .map(entity -> new PatientResponse(
                        entity.getId(),
                        entity.getEmail(),
                        entity.getName(),
                        entity.getCpf(),
                        entity.getPassword(),
                        entity.getPhone(),
                        entity.getBirthDate()))
                .collect(Collectors.toList());
    }
}
