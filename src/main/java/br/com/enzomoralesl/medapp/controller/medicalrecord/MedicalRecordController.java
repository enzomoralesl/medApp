package br.com.enzomoralesl.medapp.controller.medicalrecord;


import br.com.enzomoralesl.medapp.controller.medicalrecord.model.MedicalRecordRequest;
import br.com.enzomoralesl.medapp.controller.medicalrecord.model.MedicalRecordResponse;
import br.com.enzomoralesl.medapp.infrastructure.exception.ResourceNotFoundException;
import br.com.enzomoralesl.medapp.service.IMedicalRecordService;
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
public class MedicalRecordController implements MedicalRecordSwagger {

    @Value("${urlbase}")
    private String urlBase;
    private static final Logger LOGGER = LoggerFactory.getLogger(MedicalRecordController.class);

    private final IMedicalRecordService medicalRecordService;

    public MedicalRecordController(IMedicalRecordService medicalRecordService) {
        this.medicalRecordService = medicalRecordService;
    }

    @Override
    @PostMapping(value = "/medical-record", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MedicalRecordResponse> createMedicalRecord(@RequestBody MedicalRecordRequest request, UriComponentsBuilder uriBuilder) {

        LOGGER.info("Recebendo operacao para criar Registro Médico na base de dados...");
        MedicalRecordResponse response = medicalRecordService.save(request);

        URI uri = uriBuilder.path(urlBase + "/v1/{id}").buildAndExpand(response.id()).toUri();
        LOGGER.info("Registro Médico criado com sucesso!");
        return ResponseEntity.created(uri).body(response);
    }

    @Override
    @GetMapping("/medical-record")
    public ResponseEntity<MedicalRecordResponse> fetchMedicalRecord(@RequestHeader String email) throws ResourceNotFoundException {

        LOGGER.info("Recebendo operacao para buscar Registro Médico na base de dados...");
        Map<String, String> requestMap = Map.of(
                "email", email
        );

        return ResponseEntity.ok(medicalRecordService.fetch(requestMap));
    }

}
