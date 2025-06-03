package br.com.enzomoralesl.medapp.controller.patient;


import br.com.enzomoralesl.medapp.controller.patient.model.PatientRequest;
import br.com.enzomoralesl.medapp.controller.patient.model.PatientResponse;
import br.com.enzomoralesl.medapp.infrastructure.exception.APIErrorResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Tag(name = "Patient Endpoint", description = "Operation to create a new Patient")
@ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Criação realizada com sucesso", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = PatientResponse.class))
        }),
        @ApiResponse(responseCode = "400", description = "O codigo de retorno HTTP 400 ocorre quando um ou mais campos obrigatórios não foram informados", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = APIErrorResponse.class))
        }),
        @ApiResponse(responseCode = "401", description = "O codigo de retorno HTTP 401 ocorre quando faltam credenciais de autenticação válidas", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = APIErrorResponse.class))
        }),
        @ApiResponse(responseCode = "403", description = "O codigo de retorno HTTP 403 ocorre quando as credenciais de autenticação são insuficientes para acessar o recurso", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = APIErrorResponse.class))
        }),
        @ApiResponse(responseCode = "404", description = "O codigo de retorno HTTP 404 ocorre quando a rota não existe", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = APIErrorResponse.class))
        }),
        @ApiResponse(responseCode = "500", description = "O codigo de retorno HTTP 500 ocorre para erros inesperados", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = APIErrorResponse.class))
        }),
        @ApiResponse(responseCode = "503", description = "O codigo de retorno HTTP 503 ocorre quando um ou mais serviços externos estão Indisponíveis", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = APIErrorResponse.class))
        })})
public interface PatientSwagger {

    @Operation(
            operationId = "createPatient",
            summary = "Endpoint responsible  for creating a new patient",
            description = "Endpoint responsible for creating a new patient"
    )
    @ApiResponses(value = {@ApiResponse(responseCode = "201", description = "CREATED")})
    ResponseEntity<PatientResponse> createPatient(PatientRequest request, UriComponentsBuilder uriBuilder);

    @Operation(
            operationId = "fetchPatient",
            summary = "Endpoint responsible for searching a patient",
            description = "Endpoint responsible for searching a patient"
    )
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "OK")})
    ResponseEntity<PatientResponse> fetchPatient(String email);

    @Operation(
            operationId = "updatePatient",
            summary = "Endpoint responsible for updating a patient",
            description = "Endpoint responsible for updating a patient"
    )
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "OK")})
    ResponseEntity<PatientResponse> updatePatient(String email, PatientRequest request);

    @Operation(
            operationId = "deletePatient",
            summary = "Endpoint responsible for deleting a patient",
            description = "Endpoint responsible for deleting a patient"
    )
    @ApiResponses(value = {@ApiResponse(responseCode = "204", description = "NO_CONTENT")})
    ResponseEntity<Void> deletePatient(String email);

    @Operation(
            operationId = "getAllPatients",
            summary = "Endpoint responsible for getting all patients",
            description = "Endpoint responsible for getting all patients"
    )
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "OK")})
    ResponseEntity<List<PatientResponse>> getAllPatients();

}
