package br.com.enzomoralesl.medapp.controller.patient;


import br.com.enzomoralesl.medapp.controller.patient.model.PatientRequest;
import br.com.enzomoralesl.medapp.controller.patient.model.PatientResponse;
import br.com.enzomoralesl.medapp.service.IPatientService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/v1/patient", produces = MediaType.APPLICATION_JSON_VALUE)
public class PatientController implements PatientSwagger {

    @Value("${urlbase}")
    private String urlBase;
    private static final Logger LOGGER = LoggerFactory.getLogger(PatientController.class);

    private final IPatientService patientService;

    public PatientController(IPatientService patientService) {
        this.patientService = patientService;
    }

    @Override
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PatientResponse> createPatient(@RequestBody @Valid PatientRequest request, UriComponentsBuilder uriBuilder) {

        LOGGER.info("Recebendo operacao para criar Paciente na base de dados...");
        PatientResponse response = patientService.save(request);


        URI uri = uriBuilder.path(urlBase + "/v1/{email}").buildAndExpand(response.email()).toUri();
        LOGGER.info("Paciente criado com sucesso!");
        return ResponseEntity.created(uri).body(response);
    }

    @Override
    @GetMapping("/{email}")
    public ResponseEntity<PatientResponse> fetchPatient(@PathVariable String email) {

        LOGGER.info("Recebendo operacao para buscar Patient na base de dados...");

        return ResponseEntity.ok(patientService.fetch(email));
    }

    @Override
    @GetMapping
    public ResponseEntity<List<PatientResponse>> getAllPatients() {
        return ResponseEntity.ok(patientService.fetchAll());
    }

    @Override
    @PutMapping("/{email}")
    public ResponseEntity<PatientResponse> updatePatient(@PathVariable String email, @RequestBody PatientRequest request) {
        return ResponseEntity.ok(patientService.update(email, request));
    }

    @Override
    @DeleteMapping("/{email}")
    public ResponseEntity<Void> deletePatient(@PathVariable String email) {
        patientService.delete(email);
        return ResponseEntity.noContent().build();
    }

}
