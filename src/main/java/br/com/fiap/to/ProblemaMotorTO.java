package br.com.fiap.to;

import org.hibernate.validator.constraints.NotBlank;

public class ProblemaMotorTO {
    @NotBlank
    private String problema_motor;
    @NotBlank
    private String diagnostico;
    @NotBlank
    private Double orcamento;

    public ProblemaMotorTO() {
    }

    public ProblemaMotorTO(@NotBlank String problema_motor, @NotBlank String diagnostico, @NotBlank Double orcamento) {
        this.problema_motor = problema_motor;
        this.diagnostico = diagnostico;
        this.orcamento = orcamento;
    }

    public @NotBlank String getProblema_motor() {
        return problema_motor;
    }

    public void setProblema_motor(@NotBlank String problema_motor) {
        this.problema_motor = problema_motor;
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
