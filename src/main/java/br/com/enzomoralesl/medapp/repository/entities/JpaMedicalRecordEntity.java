package br.com.enzomoralesl.medapp.repository.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "tb_medical_record")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JpaMedicalRecordEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String teste;

    @OneToOne
    @JoinColumn(name = "id", nullable = false)
    private JpaPatientEntity patient;
}
