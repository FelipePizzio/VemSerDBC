package br.com.dbccompany.coworking.Entity;

import javax.persistence.*;

@Entity
@Table(name = "PAGAMENTOS")
public class PagamentoEntity {

    @Id
    @SequenceGenerator(allocationSize = 1, name = "PAGAMENTO_SEQ", sequenceName = "PAGAMENTO_SEQ")
    @GeneratedValue(generator = "PAGAMENTO_SEQ", strategy = GenerationType.SEQUENCE)
    @Column(name = "ID_PAGAMENTO")
    private Integer id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_CLIENTE_PACOTE", referencedColumnName = "ID_CLIENTE_PACOTE")
    private ClientePacote clientePacote;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_CONTRATAÇÃO", referencedColumnName = "ID_CONTRATAÇÃO")
    private ContratacaoEntity contratacao;

    @Enumerated(EnumType.STRING)
    @Column(name = "TIPO_PAGAMENTO")
    private TipoPagamento tipoPagamento;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ClientePacote getClientePacote() {
        return clientePacote;
    }

    public void setClientePacote(ClientePacote clientePacote) {
        this.clientePacote = clientePacote;
    }

    public ContratacaoEntity getContratacao() {
        return contratacao;
    }

    public void setContratacao(ContratacaoEntity contratacao) {
        this.contratacao = contratacao;
    }

    public TipoPagamento getTipoPagamento() {
        return tipoPagamento;
    }

    public void setTipoPagamento(TipoPagamento tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }
}
