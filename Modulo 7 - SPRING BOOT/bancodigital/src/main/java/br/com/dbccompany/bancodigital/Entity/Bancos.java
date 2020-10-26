package br.com.dbccompany.bancodigital.Entity;

import javax.persistence.*;

@Entity
public class Bancos {

    @Id
    @SequenceGenerator( allocationSize = 1, name = "BANCOS_SEQ", sequenceName = "BANCOS_SEQ")
    @GeneratedValue( generator = "BANCOS_SEQ", strategy = GenerationType.SEQUENCE)
    @Column( name = "ID_BANCOS" )
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
