package br.com.enzomoralesl.medapp.repository.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;


@Table(name = "tb_doctor", uniqueConstraints = @UniqueConstraint(columnNames = "crm"))
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JPADoctorEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	private String crm;
	private String name;
	private String specialty;
}
