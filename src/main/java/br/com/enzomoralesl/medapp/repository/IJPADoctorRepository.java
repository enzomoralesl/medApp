package br.com.enzomoralesl.medapp.repository;

import br.com.enzomoralesl.medapp.repository.entities.JPADoctorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface IJPADoctorRepository extends JpaRepository<JPADoctorEntity, UUID> {

    JPADoctorEntity findByCrm(String crm);
}
