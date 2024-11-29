package br.com.enzomoralesl.medapp.adapter.input.controllers.doctor;


import br.com.enzomoralesl.medapp.adapter.input.controllers.doctor.model.DoctorRequest;
import br.com.enzomoralesl.medapp.adapter.input.controllers.doctor.model.DoctorResponse;
import br.com.enzomoralesl.medapp.infrastructure.config.exception.ApiErroResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.util.UriComponentsBuilder;

@Tag(name = "Doctor Endpoint", description = "Operation to create a new Doctor")
@io.swagger.v3.oas.annotations.responses.ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Criação realizada com sucesso", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = DoctorResponse.class))
        }),
        @ApiResponse(responseCode = "400", description = "O codigo de retorno HTTP 400 ocorre quando um ou mais campos obrigatórios não foram informados", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = ApiErroResponse.class))
        }),
        @ApiResponse(responseCode = "401", description = "O codigo de retorno HTTP 401 ocorre quando faltam credenciais de autenticação válidas", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = ApiErroResponse.class))
        }),
        @ApiResponse(responseCode = "403", description = "O codigo de retorno HTTP 403 ocorre quando as credenciais de autenticação são insuficientes para acessar o recurso", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = ApiErroResponse.class))
        }),
        @ApiResponse(responseCode = "404", description = "O codigo de retorno HTTP 404 ocorre quando a rota não existe", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = ApiErroResponse.class))
        }),
        @ApiResponse(responseCode = "500", description = "O codigo de retorno HTTP 500 ocorre para erros inesperados", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = ApiErroResponse.class))
        }),
        @ApiResponse(responseCode = "503", description = "O codigo de retorno HTTP 503 ocorre quando um ou mais serviços externos estão Indisponíveis", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = ApiErroResponse.class))
        })})
public interface DoctorSwagger {

    @Operation(
            operationId = "createDoctor",
            summary = "Endpoint responsable for creating a new doctor",
            description = "Endpoint responsable for creating a new doctor"
    )
    @ApiResponses(value = {@ApiResponse(responseCode = "201", description = "CREATED")})
    ResponseEntity<DoctorResponse> createDoctor(@RequestBody DoctorRequest request, UriComponentsBuilder uriBuilder);
}
