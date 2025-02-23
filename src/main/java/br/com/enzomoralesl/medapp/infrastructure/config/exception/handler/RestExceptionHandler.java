package br.com.enzomoralesl.medapp.infrastructure.config.exception.handler;

import br.com.enzomoralesl.medapp.infrastructure.config.exception.APIErrorResponse;
import feign.FeignException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingRequestHeaderException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Objects;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;


@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    public static final String HEADER_REQUIRED = "Header de entrada obrigatório";
    private static final Logger LOGGER_TECNICO = LoggerFactory.getLogger(RestExceptionHandler.class);

    @ExceptionHandler(FeignException.class)
    public ResponseEntity<Object> handleFeignException(FeignException ex) {
        var apiErro = new APIErrorResponse(Objects.requireNonNull(HttpStatus.resolve(ex.status())), ex);
        apiErro.setErrorDetails(ex.getMessage());
        return buildAPIResponseError(apiErro, ex);
    }
    
    @ExceptionHandler(MissingRequestHeaderException.class)
    public ResponseEntity<Object> handleMissingRequestHeaderException(MissingRequestHeaderException ex) {
        return buildAPIResponseError(new APIErrorResponse(BAD_REQUEST, HEADER_REQUIRED, ex), ex);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleException(Exception ex) {
        var apiErro = new APIErrorResponse(INTERNAL_SERVER_ERROR, ex);
        return buildAPIResponseError(apiErro, ex);
    }

    private ResponseEntity<Object> buildAPIResponseError(APIErrorResponse apiErro, Exception ex) {
        LOGGER_TECNICO.error("Excecao sendo capturada pelo ExceptionHandler, APIErrorCode: {}, Mensagem: {}, Excecao: ", apiErro.getStatusCode(), apiErro.getMessage(), ex);
        return new ResponseEntity<>(apiErro, apiErro.getStatus());
    }

}
