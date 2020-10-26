package br.com.dbccompany.bancodigital.Entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Clientes {

    @Id
    @SequenceGenerator(allocationSize = 1, name = "CLIENTES_SEQ", sequenceName = "CLIENTES_SEQ")
    @GeneratedValue(generator = "CLIENTES_SEQ", strategy = GenerationType.SEQUENCE)
    @Column(name = "ID_CLIENTES")
    private Integer id;

    private String cpf;

    private String nome;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "clientes_x_contas",
            joinColumns = {@JoinColumn(name = "id_cliente")},
            inverseJoinColumns = {@JoinColumn(name = "id_conta")})
    private List<Contas> contas = new ArrayList<>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "clientes_x_cidades",
            joinColumns = {@JoinColumn(name = "id_cliente")},
            inverseJoinColumns = {@JoinColumn(name = "id_cidade")})
    private List<Cidades> cidades = new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Contas> getContas() {
        return contas;
    }

    public void setContas(List<Contas> contas) {
        this.contas = contas;
    }

    public List<Cidades> getCidades() {
        return cidades;
    }

    public void setCidades(List<Cidades> cidades) {
        this.cidades = cidades;
    }
}
