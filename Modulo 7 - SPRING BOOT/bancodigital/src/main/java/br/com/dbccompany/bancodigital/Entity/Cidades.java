package br.com.dbccompany.bancodigital.Entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Cidades {

    @Id
    @SequenceGenerator( allocationSize = 1, name = "CIDADES_SEQ", sequenceName = "CIDADES_SEQ")
    @GeneratedValue( generator = "CIDADES_SEQ", strategy = GenerationType.SEQUENCE)
    @Column( name = "ID_CIDADES")
    private Integer id;

    private String nome;

    @ManyToOne( cascade = CascadeType.ALL)
    @JoinColumn( name = "id_estado")
    private Estados estado;

    @ManyToMany( cascade = CascadeType.ALL)
    @JoinTable( name = "clientes_x_cidades",
            joinColumns = { @JoinColumn( name = "id_cidade" ) },
            inverseJoinColumns = { @JoinColumn( name = "id_cliente") } )
    private List<Clientes> clientes = new ArrayList<>();

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

    public Estados getEstado() {
        return estado;
    }

    public void setEstado(Estados estado) {
        this.estado = estado;
    }

    public List<Clientes> getClientes() {
        return clientes;
    }

    public void setClientes(List<Clientes> clientes) {
        this.clientes = clientes;
    }
}
