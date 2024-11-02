package br.com.fiap.to;

import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotBlank;

public class ProblemaTransmissaoTO {
    @NotBlank
    private String problema_transmissao;
    @NotBlank
    private String diagnostico;
    @NotNull
    private Double orcamento;

    public ProblemaTransmissaoTO() {
    }

    public ProblemaTransmissaoTO(@NotBlank String problema_transmissao, @NotBlank String diagnostico, @NotNull Double orcamento) {
        this.problema_transmissao = problema_transmissao;
        this.diagnostico = diagnostico;
        this.orcamento = orcamento;
    }

    public @NotBlank String getProblema_transmissao() {
        return problema_transmissao;
    }

    public void setProblema_transmissao(@NotBlank String problema_transmissao) {
        this.problema_transmissao = problema_transmissao;
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
