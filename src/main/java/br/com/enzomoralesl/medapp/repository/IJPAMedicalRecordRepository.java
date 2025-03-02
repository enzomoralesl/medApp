package br.com.enzomoralesl.medapp.repository;

import br.com.enzomoralesl.medapp.repository.entities.JPAMedicalRecordEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface IJPAMedicalRecordRepository extends JpaRepository<JPAMedicalRecordEntity, UUID> {
    Optional<JPAMedicalRecordEntity> findByPatientEmail(String email);
}
