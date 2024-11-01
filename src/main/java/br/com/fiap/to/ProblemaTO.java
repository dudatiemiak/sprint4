package br.com.fiap.to;

import org.hibernate.validator.constraints.NotBlank;

public class ProblemaTO {
    @NotBlank
    private String problema;
    @NotBlank
    private String diagnostico;
    @NotBlank
    private Double orcamento;

    public ProblemaTO() {
    }

    public ProblemaTO(@NotBlank String problema, @NotBlank String diagnostico, @NotBlank Double orcamento) {
        this.problema = problema;
        this.diagnostico = diagnostico;
        this.orcamento = orcamento;
    }

    public @NotBlank String getProblema() {
        return problema;
    }

    public void setProblema(@NotBlank String problema) {
        this.problema = problema;
    }

    public @NotBlank String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(@NotBlank String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public @NotBlank Double getOrcamento() {
        return orcamento;
    }

    public void setOrcamento(@NotBlank Double orcamento) {
        this.orcamento = orcamento;
    }
}
