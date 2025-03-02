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
public class JPAMedicalRecordEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    //@OneToMany(mappedBy = "medical_record", cascade = CascadeType.ALL)
    //private List<JPASurgeryEntity> surgeries;

    @OneToOne
    @JoinColumn(name = "patient_id", nullable = false)
    private JPAPatientEntity patient;
}
