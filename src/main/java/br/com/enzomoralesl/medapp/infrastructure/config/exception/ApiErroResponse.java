package br.com.enzomoralesl.medapp.infrastructure.config.exception;

public class ApiErroResponse {
    private final String mensagem;

    public ApiErroResponse(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getMensagem() {
        return mensagem;
    }
}
