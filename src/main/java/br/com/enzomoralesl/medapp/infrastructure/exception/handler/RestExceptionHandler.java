package br.com.enzomoralesl.medapp.infrastructure.exception.handler;

import br.com.enzomoralesl.medapp.infrastructure.exception.APIErrorResponse;
import br.com.enzomoralesl.medapp.infrastructure.exception.ResourceNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingRequestHeaderException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import static org.springframework.http.HttpStatus.*;


@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    public static final String ERROR_HEADER_REQUIRED = "Header de entrada obrigatório";
    public static final String ERROR_CPF_DUPLICATED = "CPF já cadastrado";
    public static final String  ERROR_EMAIL_DUPLICATED = "Email já cadastrado";
    public static final String ERROR_VALUE_DUPLICATED = "Existe algum valor já cadastrado";

    public static final String ERROR_INTEGRITY_VIOLATION = "Erro de violação de integridade na base de dados";
    private static final Logger LOGGER_TECNICO = LoggerFactory.getLogger(RestExceptionHandler.class);

    
    @ExceptionHandler(MissingRequestHeaderException.class)
    public ResponseEntity<Object> handleMissingRequestHeaderException(MissingRequestHeaderException ex) {
        return buildAPIResponseError(new APIErrorResponse(BAD_REQUEST, ERROR_HEADER_REQUIRED, ex), ex);
    }
    
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<Object> handleDataIntegrityViolationException(DataIntegrityViolationException ex) {
        if(ex.getMessage().contains("duplicate key value violates unique constraint")) {
            if(ex.getMessage().contains("tb_patient_email_key"))
                return buildAPIResponseError(new APIErrorResponse(INTERNAL_SERVER_ERROR, ERROR_EMAIL_DUPLICATED, ex), ex);
            if(ex.getMessage().contains("tb_patient_cpf_key"))
                return buildAPIResponseError(new APIErrorResponse(INTERNAL_SERVER_ERROR, ERROR_CPF_DUPLICATED, ex), ex);
            return buildAPIResponseError(new APIErrorResponse(INTERNAL_SERVER_ERROR, ERROR_VALUE_DUPLICATED, ex), ex);
        }
        return buildAPIResponseError(new APIErrorResponse(INTERNAL_SERVER_ERROR, ERROR_INTEGRITY_VIOLATION, ex), ex);
    }

    @Override
    public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        return buildAPIResponseError(new APIErrorResponse(BAD_REQUEST, ex.getMessage(), ex), ex);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Object> handleResourceNotFoundException(ResourceNotFoundException ex) {
        return buildAPIResponseError(new APIErrorResponse(NOT_FOUND, ex.getMessage(), ex), ex);
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
