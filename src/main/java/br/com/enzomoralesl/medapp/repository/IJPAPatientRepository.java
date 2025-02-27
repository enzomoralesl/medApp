package br.com.enzomoralesl.medapp.repository;

import br.com.enzomoralesl.medapp.repository.entities.JpaPatientEntity;
import org.hibernate.validator.constraints.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IJPAPatientRepository extends JpaRepository<JpaPatientEntity, UUID> {

    JpaPatientEntity findByEmail(String email);
}
