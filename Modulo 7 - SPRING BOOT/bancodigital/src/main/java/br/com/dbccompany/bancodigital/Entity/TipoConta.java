package br.com.dbccompany.bancodigital.Entity;

import javax.persistence.*;

@Entity
public class TipoConta {

    @Id
    @SequenceGenerator( allocationSize = 1, name = "TIPO_CONTA_SEQ", sequenceName = "TIPO_CONTA_SEQ")
    @GeneratedValue( generator = "TIPO_CONTA_SEQ", strategy = GenerationType.SEQUENCE)
    @Column( name = "ID_TIPO_CONTA")
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