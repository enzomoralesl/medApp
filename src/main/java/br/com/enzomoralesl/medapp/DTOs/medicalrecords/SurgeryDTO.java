package br.com.enzomoralesl.medapp.DTOs.medicalrecords;

import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class SurgeryDTO extends MedicalAppointmentDTO{
    private SurgeryType type;

    public SurgeryDTO(String date, String doctorName, String doctorCRM, String description, SurgeryType type) {
        super(date, doctorName, doctorCRM, description);
        this.type = type;
    }
}
