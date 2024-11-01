package br.com.fiap.to;

import org.hibernate.validator.constraints.NotBlank;

public class ProblemaSistemaEletricoTO {
    @NotBlank
    private String problema_se;
    @NotBlank
    private String diagnostico;
    @NotBlank
    private Double orcamento;

    public ProblemaSistemaEletricoTO() {
    }

    public ProblemaSistemaEletricoTO(@NotBlank String problema_se, @NotBlank String diagnostico, @NotBlank Double orcamento) {
        this.problema_se = problema_se;
        this.diagnostico = diagnostico;
        this.orcamento = orcamento;
    }

    public @NotBlank String getProblema_se() {
        return problema_se;
    }

    public void setProblema_se(@NotBlank String problema_se) {
        this.problema_se = problema_se;
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
