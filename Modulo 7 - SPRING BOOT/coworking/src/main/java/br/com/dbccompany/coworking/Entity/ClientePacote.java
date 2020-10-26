package br.com.dbccompany.coworking.Entity;

import javax.persistence.*;

@Entity
public class ClientePacote {

    @Id
    @SequenceGenerator(allocationSize = 1, name = "CLIENTE_PACOTE_SEQ", sequenceName = "CLIENTE_PACOTE_SEQ")
    @GeneratedValue(generator = "CLIENTE_PACOTE_SEQ", strategy = GenerationType.SEQUENCE)
    @Column(name = "ID_CLIENTE_PACOTE")
    private Integer id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_CLIENTE", referencedColumnName = "ID_CLIENTE")
    private ClienteEntity cliente;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_PACOTE", referencedColumnName = "ID_PACOTE")
    private PacoteEntity pacote;

    private Integer quantidade;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ClienteEntity getCliente() {
        return cliente;
    }

    public void setCliente(ClienteEntity cliente) {
        this.cliente = cliente;
    }

    public PacoteEntity getPacote() {
        return pacote;
    }

    public void setPacote(PacoteEntity pacote) {
        this.pacote = pacote;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
}
