package br.com.fiap.to;

import org.hibernate.validator.constraints.NotBlank;

public class ProblemaArCondicionadoTO {
    @NotBlank
    private String problema_ar;
    @NotBlank
    private String diagnostico;
    @NotBlank
    private Double orcamento;

    public ProblemaArCondicionadoTO() {
    }

    public ProblemaArCondicionadoTO(@NotBlank String problema_ar, @NotBlank String diagnostico, @NotBlank Double orcamento) {
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

    public @NotBlank Double getOrcamento() {
        return orcamento;
    }

    public void setOrcamento(@NotBlank Double orcamento) {
        this.orcamento = orcamento;
    }
}
