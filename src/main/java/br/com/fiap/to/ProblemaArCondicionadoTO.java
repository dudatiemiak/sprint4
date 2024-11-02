package br.com.fiap.to;

import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotBlank;

public class ProblemaArCondicionadoTO {
    @NotBlank
    private String problema_ar;
    @NotBlank
    private String diagnostico;
    @NotNull
    private Double orcamento;

    public ProblemaArCondicionadoTO() {
    }

    public ProblemaArCondicionadoTO(@NotBlank String problema_ar, @NotBlank String diagnostico, @NotNull Double orcamento) {
        this.problema_ar = problema_ar;
        this.diagnostico = diagnostico;
        this.orcamento = orcamento;
    }

    public @NotBlank String getProblema_ar() {
        return problema_ar;
    }

    public void setProblema_ar(@NotBlank String problema_ar) {
        this.problema_ar = problema_ar;
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
