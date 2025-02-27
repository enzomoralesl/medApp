package br.com.enzomoralesl.medapp.repository;

import br.com.enzomoralesl.medapp.repository.entities.JpaDoctorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface IJPADoctorRepository extends JpaRepository<JpaDoctorEntity, UUID> {

    JpaDoctorEntity findByCrm(String crm);
}
