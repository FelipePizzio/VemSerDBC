package br.com.dbccompany.coworking.Entity;

import javax.persistence.*;

@Entity
@Table(name = "TIPO_CONTATO")
public class TipoContatoEntity {

    @Id
    @SequenceGenerator(allocationSize = 1, name = "TIPO_CONTATO_SEQ", sequenceName = "TIPO_CONTATO_SEQ")
    @GeneratedValue(generator = "TIPO_CONTATO_SEQ", strategy = GenerationType.SEQUENCE)
    @Column(name = "ID_TIPO_CONTATO")
    private Integer id;

    private String nome;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
