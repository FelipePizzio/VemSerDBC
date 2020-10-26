package br.com.dbccompany.coworking.Entity;

import javax.persistence.*;

@Entity
public class EspacoPacote {

    @Id
    @SequenceGenerator(allocationSize = 1, name = "ESPACO_PACOTE_SEQ", sequenceName = "ESPACO_PACOTE_SEQ")
    @GeneratedValue(generator = "ESPACO_PACOTE_SEQ", strategy = GenerationType.SEQUENCE)
    @Column(name = "ID_ESPACO_PACOTE")
    private Integer id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_ESPAÇO", referencedColumnName = "ID_ESPAÇO")
    private EspacoEntity espaco;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_PACOTE", referencedColumnName = "ID_PACOTE")
    private PacoteEntity pacote;

    @Enumerated(EnumType.STRING)
    @Column(name = "TIPO_CONTRATAÇÃO")
    private TipoContratacao tipoContratacao;

    private Integer quantidade;

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

    public PacoteEntity getPacote() {
        return pacote;
    }

    public void setPacote(PacoteEntity pacote) {
        this.pacote = pacote;
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

    public Integer getPrazo() {
        return prazo;
    }

    public void setPrazo(Integer prazo) {
        this.prazo = prazo;
    }
}
