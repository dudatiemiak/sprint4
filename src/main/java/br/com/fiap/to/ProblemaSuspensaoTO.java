package br.com.fiap.to;

import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotBlank;

public class ProblemaSuspensaoTO {
    @NotBlank
    private String problema_suspensao;
    @NotBlank
    private String diagnostico;
    @NotNull
    private Double orcamento;

    public ProblemaSuspensaoTO() {
    }

    public ProblemaSuspensaoTO(@NotBlank String problema_suspensao, @NotBlank String diagnostico, @NotNull Double orcamento) {
        this.problema_suspensao = problema_suspensao;
        this.diagnostico = diagnostico;
        this.orcamento = orcamento;
    }

    public @NotBlank String getProblema_suspensao() {
        return problema_suspensao;
    }

    public void setProblema_suspensao(@NotBlank String problema_suspensao) {
        this.problema_suspensao = problema_suspensao;
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
