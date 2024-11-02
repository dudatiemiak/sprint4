package br.com.fiap.to;

import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotBlank;

public class ProblemaMotorTO {
    @NotBlank
    private String problema_motor;
    @NotBlank
    private String diagnostico;
    @NotNull
    private Double orcamento;

    public ProblemaMotorTO() {
    }

    public ProblemaMotorTO(@NotBlank String problema_motor, @NotBlank String diagnostico, @NotNull Double orcamento) {
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

    public @NotNull Double getOrcamento() {
        return orcamento;
    }

    public void setOrcamento(@NotNull Double orcamento) {
        this.orcamento = orcamento;
    }
}
