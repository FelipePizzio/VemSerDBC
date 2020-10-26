package br.com.dbccompany.bancodigital.Entity;

import javax.persistence.*;

@Entity
public class Estados {

    @Id
    @SequenceGenerator( allocationSize = 1, name = "ESTADOS_SEQ", sequenceName = "ESTADOS_SEQ")
    @GeneratedValue( generator = "ESTADOS_SEQ", strategy = GenerationType.SEQUENCE)
    @Column( name = "ID_ESTADOS")
    private Integer id;

    private String nome;

    @ManyToOne( cascade = CascadeType.MERGE)
    @JoinColumn( name = "id_pais")
    private Paises pais;

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

    public Paises getPais() {
        return pais;
    }

    public void setPais(Paises pais) {
        this.pais = pais;
    }
}
