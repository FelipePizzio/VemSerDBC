package br.com.dbccompany.coworking.Entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "ESPAÇOS")
public class EspacoEntity {

    @Id
    @SequenceGenerator(allocationSize = 1, name = "ESPAÇO_SEQ", sequenceName = "ESPAÇO_SEQ")
    @GeneratedValue(generator = "ESPAÇO_SEQ", strategy = GenerationType.SEQUENCE)
    @Column(name = "ID_ESPAÇO")
    private Integer id;

    @NotBlank
    @Column(unique = true)
    private String nome;

    @NotBlank
    private Integer qtdPessoas;

    @NotBlank
    private Integer valor;

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

    public Integer getQtdPessoas() {
        return qtdPessoas;
    }

    public void setQtdPessoas(Integer qtdPessoas) {
        this.qtdPessoas = qtdPessoas;
    }

    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }
}
