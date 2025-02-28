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
import java.util.Map;

@RestController
@RequestMapping(value = "/v1", produces = MediaType.APPLICATION_JSON_VALUE)
public class PatientController implements PatientSwagger {

    @Value("${urlbase}")
    private String urlBase;
    private static final Logger LOGGER = LoggerFactory.getLogger(PatientController.class);

    private final IPatientService patientService;

    public PatientController(IPatientService patientService) {
        this.patientService = patientService;
    }

    @Override
    @PostMapping(value = "/patient", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PatientResponse> createPatient(@RequestBody @Valid PatientRequest request, UriComponentsBuilder uriBuilder) {

        LOGGER.info("Recebendo operacao para criar Paciente na base de dados...");
        PatientResponse response = patientService.save(request);


        URI uri = uriBuilder.path(urlBase + "/v1/{id}").buildAndExpand(response.id()).toUri();
        LOGGER.info("Paciente criado com sucesso!");
        return ResponseEntity.created(uri).body(response);
    }

    @Override
    @GetMapping("/patient")
    public ResponseEntity<PatientResponse> fetchPatient(@RequestHeader String email) {

        LOGGER.info("Recebendo operacao para buscar Patient na base de dados...");
        Map<String, String> requestMap = Map.of(
                "email", email
        );

        return ResponseEntity.ok(patientService.fetch(requestMap));
    }

}
