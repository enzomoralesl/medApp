package br.com.enzomoralesl.medapp.adapter.input.controllers.doctor;


import br.com.enzomoralesl.medapp.adapter.input.controllers.doctor.model.DoctorRequest;
import br.com.enzomoralesl.medapp.adapter.input.controllers.doctor.model.DoctorResponse;
import br.com.enzomoralesl.medapp.application.usecases.ICreateDoctorUseCases;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class DoctorController implements DoctorSwagger {

    @Value("${urlbase}")
   private String urlBase;
    private static final Logger LOGGER = LoggerFactory.getLogger(DoctorController.class);

    private final ICreateDoctorUseCases createDoctorUseCase;

    public DoctorController(ICreateDoctorUseCases createDoctorUseCase) {
        this.createDoctorUseCase = createDoctorUseCase;
    }

    @Override
    @PostMapping(value = "/v1/doctor")
    public ResponseEntity<DoctorResponse> createDoctor(@RequestBody DoctorRequest request, UriComponentsBuilder uriBuilder) {

        LOGGER.info("Recebendo operacao para criar Doutor na base de dados...");
        DoctorResponse response = createDoctorUseCase.save(request);
        LOGGER.info("Doutor criado com sucesso!");

        URI uri = uriBuilder.path(urlBase + "/v1/{id}").buildAndExpand(response.id()).toUri();

        return ResponseEntity.created(uri).body(response);
    }

    @GetMapping("/test")
    public String test() {
        return "Application is running";
    }

}
