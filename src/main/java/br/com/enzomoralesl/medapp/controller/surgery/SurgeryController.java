package br.com.enzomoralesl.medapp.controller.surgery;

import br.com.enzomoralesl.medapp.controller.surgery.model.SurgeryRequest;
import br.com.enzomoralesl.medapp.controller.surgery.model.SurgeryResponse;
import br.com.enzomoralesl.medapp.service.ISurgeryService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/v1", produces = MediaType.APPLICATION_JSON_VALUE)
public class SurgeryController {

    @Value("${urlbase}")
    private String urlBase;
    private static final Logger LOGGER = LoggerFactory.getLogger(SurgeryController.class);

    private final ISurgeryService surgeryService;

    public SurgeryController(ISurgeryService surgeryService) {
        this.surgeryService = surgeryService;
    }


    @PostMapping(value = "/surgery")
    public ResponseEntity<SurgeryResponse> createSurgery(@RequestBody @Valid SurgeryRequest request, UriComponentsBuilder uriBuilder) {

        LOGGER.info("Recebendo operacao para criar Cirurgia na base de dados...");
        SurgeryResponse response = surgeryService.save(request);
        LOGGER.info("Cirurgia criada com sucesso!");

        URI uri = uriBuilder.path(urlBase + "/v1/{id}").buildAndExpand(response.id()).toUri();

        return ResponseEntity.created(uri).body(response);
    }
}
