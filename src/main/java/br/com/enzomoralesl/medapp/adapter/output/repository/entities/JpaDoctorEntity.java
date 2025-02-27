package br.com.enzomoralesl.medapp.adapter.output.repository.entities;

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
public class JpaDoctorEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	private String name;
	private String specialty;
	private String crm;

}
