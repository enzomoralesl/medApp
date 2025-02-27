package br.com.enzomoralesl.medapp.repository;

import br.com.enzomoralesl.medapp.repository.entities.JpaDoctorEntity;
import org.hibernate.validator.constraints.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IJPADoctorRepository extends JpaRepository<JpaDoctorEntity, UUID> {

    JpaDoctorEntity findByCrm(String crm);
}
