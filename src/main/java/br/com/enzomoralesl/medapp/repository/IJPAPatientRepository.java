package br.com.enzomoralesl.medapp.repository;

import br.com.enzomoralesl.medapp.repository.entities.JpaPatientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface IJPAPatientRepository extends JpaRepository<JpaPatientEntity, UUID> {

    Optional<JpaPatientEntity> findByEmail(String email);}
