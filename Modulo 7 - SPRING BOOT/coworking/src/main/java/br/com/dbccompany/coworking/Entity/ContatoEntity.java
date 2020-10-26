package br.com.dbccompany.coworking.Entity;

import javax.persistence.*;

@Entity
@Table(name = "CONTATOS")
public class ContatoEntity {

    @Id
    @SequenceGenerator(allocationSize = 1, name = "CONTATO_SEQ", sequenceName = "CONTATO_SEQ")
    @GeneratedValue(generator = "CONTATO_SEQ", strategy = GenerationType.SEQUENCE)
    @Column(name = "ID_CONTATO")
    private Integer id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_TIPO_CONTATO", referencedColumnName = "ID_TIPO_CONTATO")
    private TipoContatoEntity tipoContato;

    private String valor;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public TipoContatoEntity getTipoContato() {
        return tipoContato;
    }

    public void setTipoContato(TipoContatoEntity tipoContato) {
        this.tipoContato = tipoContato;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
}
