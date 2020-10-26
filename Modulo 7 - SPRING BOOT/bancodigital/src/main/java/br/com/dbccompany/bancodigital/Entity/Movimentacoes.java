package br.com.dbccompany.bancodigital.Entity;

import javax.persistence.*;

@Entity
public class Movimentacoes {

    @Id
    @SequenceGenerator( allocationSize = 1, name = "MOVIMENTACOES_SEQ", sequenceName = "MOVIMENTACOES_SEQ")
    @GeneratedValue( generator = "MOVIMENTACOES_SEQ", strategy = GenerationType.SEQUENCE)
    @Column( name = "ID_MOVIMENTACOES")
    private Integer id;

    private Double valor;

//    @Enumerated( EnumType.STRING )
//    private TipoMovimentacao tipoMovimentacao;

    @ManyToOne( cascade = CascadeType.ALL)
    @JoinColumn( name = "id_conta")
    private Contas conta;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

//    public TipoMovimentacao getTipoMovimentacao() {
//        return tipoMovimentacao;
//    }
//
//    public void setTipoMovimentacao(TipoMovimentacao tipoMovimentacao) {
//        this.tipoMovimentacao = tipoMovimentacao;
//    }

    public Contas getConta() {
        return conta;
    }

    public void setConta(Contas conta) {
        this.conta = conta;
    }
}
