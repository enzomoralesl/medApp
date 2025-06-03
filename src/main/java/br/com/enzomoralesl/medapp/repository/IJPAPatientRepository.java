package br.com.enzomoralesl.medapp.repository;

import br.com.enzomoralesl.medapp.repository.entities.JPAPatientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface IJPAPatientRepository extends JpaRepository<JPAPatientEntity, UUID> {

    Optional<JPAPatientEntity> findByEmail(String email);
    void deleteByEmail(String email);
    Boolean existsByEmail(String email);
}
