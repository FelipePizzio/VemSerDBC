package br.com.dbccompany.bancodigital.Entity;

import javax.persistence.*;

@Entity
public class Paises {

    @Id
    @SequenceGenerator( allocationSize = 1, name = "PAISES_SEQ", sequenceName = "PAISES_SEQ")
    @GeneratedValue( generator = "PAISES_SEQ", strategy = GenerationType.SEQUENCE)
    @Column( name = "ID_PAISES")
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
