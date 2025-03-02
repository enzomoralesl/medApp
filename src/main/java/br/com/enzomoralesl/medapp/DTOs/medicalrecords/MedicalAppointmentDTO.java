package br.com.enzomoralesl.medapp.DTOs.medicalrecords;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MedicalAppointmentDTO {
    private String date;
    private String doctorName;
    private String doctorCRM;
    private String description;

}
