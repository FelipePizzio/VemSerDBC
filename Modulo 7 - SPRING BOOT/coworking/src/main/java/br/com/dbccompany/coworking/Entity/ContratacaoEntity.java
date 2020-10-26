package br.com.dbccompany.coworking.Entity;

import javax.persistence.*;

@Entity
@Table(name = "CONTRATAÇÕES")
public class ContratacaoEntity {

    @Id
    @SequenceGenerator(allocationSize = 1, name = "CONTRATAÇÃO_SEQ", sequenceName = "CONTRATAÇÃO_SEQ")
    @GeneratedValue(generator = "CONTRATAÇÃO_SEQ", strategy = GenerationType.SEQUENCE)
    @Column(name = "ID_CONTRATAÇÃO")
    private Integer id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_ESPAÇO", referencedColumnName = "ID_ESPAÇO")
    private EspacoEntity espaco;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_CLIENTE", referencedColumnName = "ID_CLIENTE")
    private ClienteEntity cliente;

    @Enumerated(EnumType.STRING)
    @Column(name = "TIPO_CONTRATAÇÃO")
    private TipoContratacao tipoContratacao;

    private Integer quantidade;

    @Column(nullable = true)
    private Integer desconto;

    private Integer prazo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public EspacoEntity getEspaco() {
        return espaco;
    }

    public void setEspaco(EspacoEntity espaco) {
        this.espaco = espaco;
    }

    public ClienteEntity getCliente() {
        return cliente;
    }

    public void setCliente(ClienteEntity cliente) {
        this.cliente = cliente;
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

    public Integer getDesconto() {
        return desconto;
    }

    public void setDesconto(Integer desconto) {
        this.desconto = desconto;
    }

    public Integer getPrazo() {
        return prazo;
    }

    public void setPrazo(Integer prazo) {
        this.prazo = prazo;
    }
}
