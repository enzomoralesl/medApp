package br.com.enzomoralesl.medapp.adapter.output.repository;

import br.com.enzomoralesl.medapp.adapter.output.repository.entities.JpaDoctorEntity;
import org.hibernate.validator.constraints.UUID;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IJPADoctorRepository extends JpaRepository<JpaDoctorEntity, UUID> {

}
