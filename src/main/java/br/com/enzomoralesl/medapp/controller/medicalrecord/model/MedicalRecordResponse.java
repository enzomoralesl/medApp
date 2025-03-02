package br.com.enzomoralesl.medapp.controller.medicalrecord.model;

import br.com.enzomoralesl.medapp.DTOs.medicalrecords.SurgeryDTO;

import java.util.List;
import java.util.UUID;

public record MedicalRecordResponse(
        UUID id,
        List<SurgeryDTO> surgeries,
        UUID id_patient
) {
}