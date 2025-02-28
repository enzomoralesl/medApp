package br.com.enzomoralesl.medapp.controller.doctor;


import br.com.enzomoralesl.medapp.controller.doctor.model.DoctorRequest;
import br.com.enzomoralesl.medapp.controller.doctor.model.DoctorResponse;
import br.com.enzomoralesl.medapp.service.IDoctorService;
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

    private final IDoctorService doctorService;

    public DoctorController(IDoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @Override
    @PostMapping(value = "/doctor")
    public ResponseEntity<DoctorResponse> createDoctor(@RequestBody DoctorRequest request, UriComponentsBuilder uriBuilder) {

        LOGGER.info("Recebendo operacao para criar Doutor na base de dados...");
        DoctorResponse response = doctorService.save(request);
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

        return ResponseEntity.ok(doctorService.fetch(requestMap));
    }

}
