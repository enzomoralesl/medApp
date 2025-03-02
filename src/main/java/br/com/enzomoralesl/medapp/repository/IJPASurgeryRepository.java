package br.com.enzomoralesl.medapp.repository;

import br.com.enzomoralesl.medapp.repository.entities.JPASurgeryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IJPASurgeryRepository extends JpaRepository<JPASurgeryEntity, UUID> {

    Optional<List<JPASurgeryEntity>> findByMedicalRecordId(UUID medicalRecordId);
}
