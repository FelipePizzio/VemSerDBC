package br.com.dbccompany.coworking.Entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Entity
public class SaldoCliente {

    @EmbeddedId
    private SaldoClienteId id;

    @Enumerated(EnumType.STRING)
    @NotBlank
    @Column(name = "TIPO_CONTRATAÇÃO")
    private TipoContratacao tipoContratacao;

    @NotBlank
    private Integer quantidade;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @NotBlank
    private LocalDate vencimento;

    public SaldoClienteId getId() {
        return id;
    }

    public void setId(SaldoClienteId id) {
        this.id = id;
    }

    public TipoContratacao getTipoContratacao() {
        return tipoContratacao;
    }

    public void setTipoContratacao(TipoContratacao tipoContratacao) {
        this.tipoContratacao = tipoContratacao;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public LocalDate getVencimento() {
        return vencimento;
    }

    public void setVencimento(LocalDate vencimento) {
        this.vencimento = vencimento;
    }
}
