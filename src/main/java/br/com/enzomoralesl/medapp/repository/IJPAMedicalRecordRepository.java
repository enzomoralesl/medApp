package br.com.enzomoralesl.medapp.repository;

import br.com.enzomoralesl.medapp.repository.entities.JpaMedicalRecordEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface IJPAMedicalRecordRepository extends JpaRepository<JpaMedicalRecordEntity, UUID> {
    Optional<JpaMedicalRecordEntity> findByPatientEmail(String email);
}
