package br.com.enzomoralesl.medapp.repository.entities;

import br.com.enzomoralesl.medapp.DTOs.medicalrecords.SurgeryType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Table(name = "tb_surgery")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JPASurgeryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String date;
    private String doctorName;
    private String doctorCRM;
    private String description;
    @Enumerated(EnumType.STRING)
    private SurgeryType type;

    @ManyToOne
    @JoinColumn(name = "medical_record_id", nullable = false)
    private JPAMedicalRecordEntity medicalRecord;
}
