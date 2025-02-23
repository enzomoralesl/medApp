package br.com.enzomoralesl.medapp.infrastructure.config.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
@JsonTypeName("error")
@JsonTypeInfo(include = JsonTypeInfo.As.WRAPPER_OBJECT, use = JsonTypeInfo.Id.NAME)
public class APIErrorResponse {
    @JsonProperty("timestamp")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private final LocalDateTime timestamp;
    @JsonProperty("statusCode")
    private Integer statusCode;
    @JsonProperty("status")
    private HttpStatus status;
    @JsonProperty("message")
    private String message;
    @JsonProperty("errorDetails")
    private String errorDetails;

    private APIErrorResponse() {
        timestamp = LocalDateTime.now();
    }

    public APIErrorResponse(HttpStatus status) {
        this();
        this.status = status;
        this.statusCode = status.value();
    }

    public APIErrorResponse(HttpStatus status, Throwable ex) {
        this();
        this.status = status;
        this.statusCode = status.value();
        this.message = "Erro inesperado: " + ex.getLocalizedMessage();
        this.errorDetails = ex.getLocalizedMessage();
    }

    public APIErrorResponse(HttpStatus status, String message, Throwable ex) {
        this();
        this.status = status;
        this.statusCode = status.value();
        this.message = message;
        this.errorDetails = ex.getLocalizedMessage();
    }
}
