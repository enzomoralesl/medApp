package br.com.enzomoralesl.medapp.repository.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;


@Table(
	name = "tb_patient",
	uniqueConstraints = {
		@UniqueConstraint(name = "tb_patient_email_key", columnNames = {"email"}),
		@UniqueConstraint(name = "tb_patient_cpf_key", columnNames = {"cpf"})
	}
)
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JPAPatientEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	private String email;
	private String name;
	private String cpf;
	private String password;
	private String phone;
	private String birthDate;

//	@OneToOne(mappedBy = "patient", cascade = CascadeType.ALL, orphanRemoval = true)
//	private JPAMedicalRecordEntity medicalRecord;
}
