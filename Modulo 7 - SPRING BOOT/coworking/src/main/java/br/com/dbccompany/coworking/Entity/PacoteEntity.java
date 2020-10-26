package br.com.dbccompany.coworking.Entity;

import javax.persistence.*;

@Entity
@Table(name = "PACOTES")
public class PacoteEntity {

    @Id
    @SequenceGenerator(allocationSize = 1, name = "PACOTE_SEQ", sequenceName = "PACOTE_SEQ")
    @GeneratedValue(generator = "PACOTE_SEQ", strategy = GenerationType.SEQUENCE)
    @Column(name = "ID_PACOTE")
    private Integer id;

    private Integer valor;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }
}
