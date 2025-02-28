package br.com.enzomoralesl.medapp.controller.medicalrecord;


import br.com.enzomoralesl.medapp.controller.medicalrecord.model.MedicalRecordRequest;
import br.com.enzomoralesl.medapp.controller.medicalrecord.model.MedicalRecordResponse;
import br.com.enzomoralesl.medapp.infrastructure.exception.APIErrorResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

@Tag(name = "MedicalRecord Endpoint", description = "Operation to create a new MedicalRecord")
@ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Criação realizada com sucesso", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = MedicalRecordResponse.class))
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
public interface MedicalRecordSwagger {

    @Operation(
            operationId = "createMedicalRecord",
            summary = "Endpoint responsible  for creating a new medical record",
            description = "Endpoint responsible for creating a new medical record"
    )
    @ApiResponses(value = {@ApiResponse(responseCode = "201", description = "CREATED")})
    ResponseEntity<MedicalRecordResponse> createMedicalRecord(MedicalRecordRequest request, UriComponentsBuilder uriBuilder);

    @Operation(
            operationId = "fetchMedicalRecord",
            summary = "Endpoint responsible for searching a medical record",
            description = "Endpoint responsible for searching a medical record"
    )
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "OK")})
    ResponseEntity<MedicalRecordResponse> fetchMedicalRecord(String email);

}
