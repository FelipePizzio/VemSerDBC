package br.com.dbccompany.bancodigital.Entity;

import javax.persistence.*;

@Entity
public class Agencias {

    @Id
    @SequenceGenerator( allocationSize = 1, name = "AGENCIAS_SEQ", sequenceName = "AGENCIAS_SEQ")
    @GeneratedValue( generator = "AGENCIAS_SEQ", strategy = GenerationType.SEQUENCE)
    @Column( name = "ID_AGENCIAS")
    private Integer id;

    private String nome;

    @ManyToOne( cascade = CascadeType.MERGE )
    @JoinColumn( name = "id_banco")
    private Bancos banco;

    @ManyToOne( cascade = CascadeType.MERGE )
    @JoinColumn( name = "id_cidade" )
    private Cidades cidade;

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

    public Bancos getBanco() {
        return banco;
    }

    public void setBanco(Bancos banco) {
        this.banco = banco;
    }

    public Cidades getCidade() {
        return cidade;
    }

    public void setCidade(Cidades cidade) {
        this.cidade = cidade;
    }
}

