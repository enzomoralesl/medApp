package br.com.enzomoralesl.medapp.DTOs;

import br.com.enzomoralesl.medapp.DTOs.medicalrecords.SurgeryDTO;
import br.com.enzomoralesl.medapp.DTOs.medicalrecords.ConsultationDTO;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class MedicalRecordDTO {

    //general medical appointments
    private List<SurgeryDTO> surgeries;
    private List<ConsultationDTO> consultations;

    /*
    //tests
    List<Exam> exams;
    List<MedicalTest> medicalTests;
    List<Allergy> allergies;

    //patient data
    List<FamilyHistory> familyHistories;
    List<PersonalHistory> personalHistories;
    List<Comorbidity> comorbidities;
    List<Vaccination> vaccinations;
    List<Immunization> immunizations;

    //after medical consultation
    List<Medication> medications;
    List<MedicalReport> medicalUrgentReports;
    List<MedicalRequest> medicalRequests;
    List<MedicalResult> medicalResults;
    List<MedicalPrescription> medicalPrescriptions;
*/
}