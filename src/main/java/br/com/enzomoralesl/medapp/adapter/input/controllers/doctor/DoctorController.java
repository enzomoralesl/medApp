package br.com.enzomoralesl.medapp.adapter.input.controllers.doctor;


import br.com.enzomoralesl.medapp.adapter.input.controllers.doctor.model.DoctorRequest;
import br.com.enzomoralesl.medapp.adapter.input.controllers.doctor.model.DoctorResponse;
import br.com.enzomoralesl.medapp.application.usecases.IDoctorUseCases;
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
public class DoctorController implements DoctorSwagger {

    @Value("${urlbase}")
    private String urlBase;
    private static final Logger LOGGER = LoggerFactory.getLogger(DoctorController.class);

    private final IDoctorUseCases doctorUseCase;

    public DoctorController(IDoctorUseCases doctorUseCase) {
        this.doctorUseCase = doctorUseCase;
    }

    @Override
    @PostMapping(value = "/doctor")
    public ResponseEntity<DoctorResponse> createDoctor(@RequestBody DoctorRequest request, UriComponentsBuilder uriBuilder) {

        LOGGER.info("Recebendo operacao para criar Doutor na base de dados...");
        //TODO - Implementar validacao de existencia de request no BDD
        DoctorResponse response = doctorUseCase.save(request);
        LOGGER.info("Doutor criado com sucesso!");

        URI uri = uriBuilder.path(urlBase + "/v1/{id}").buildAndExpand(response.id()).toUri();

        return ResponseEntity.created(uri).body(response);
    }

    @Override
    @GetMapping("/doctor")
    public ResponseEntity<DoctorResponse> fetchDoctor(@RequestHeader String crm) {

        LOGGER.info("Recebendo operacao para buscar Doutor na base de dados...");
        Map<String, String> requestMap = Map.of(
                "crm", crm
        );

        return ResponseEntity.ok(doctorUseCase.fetch(requestMap));
    }

}
