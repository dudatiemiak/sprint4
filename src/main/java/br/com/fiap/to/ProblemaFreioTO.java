package br.com.fiap.to;

import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotBlank;

public class ProblemaFreioTO {
    @NotBlank
    private String problema_freio;
    @NotBlank
    private String diagnostico;
    @NotNull
    private Double orcamento;

    public ProblemaFreioTO() {
    }

    public ProblemaFreioTO(@NotBlank String problema_freio, @NotBlank String diagnostico, @NotNull Double orcamento) {
        this.problema_freio = problema_freio;
        this.diagnostico = diagnostico;
        this.orcamento = orcamento;
    }

    public @NotBlank String getProblema_freio() {
        return problema_freio;
    }

    public void setProblema_freio(@NotBlank String problema_freio) {
        this.problema_freio = problema_freio;
    }

    public @NotBlank String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(@NotBlank String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public @NotNull Double getOrcamento() {
        return orcamento;
    }

    public void setOrcamento(@NotNull Double orcamento) {
        this.orcamento = orcamento;
    }
}
