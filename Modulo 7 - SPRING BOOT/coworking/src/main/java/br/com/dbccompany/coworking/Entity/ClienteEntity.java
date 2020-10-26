package br.com.dbccompany.coworking.Entity;

import org.hibernate.validator.constraints.br.CPF;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Entity
@Table(name = "CLIENTES")
public class ClienteEntity {

    @Id
    @SequenceGenerator(allocationSize = 1, name = "CLIENTE_SEQ", sequenceName = "CLIENTE_SEQ")
    @GeneratedValue(generator = "CLIENTE_SEQ", strategy = GenerationType.SEQUENCE)
    @Column(name = "ID_CLIENTE")
    private Integer id;

    @NotBlank
    private String nome;

    @CPF
    @NotBlank
    @Column(unique = true)
    private Integer cpf;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @NotBlank
    private LocalDate dataNascimento;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_CONTATO", referencedColumnName = "ID_CONTATO")
    private ContatoEntity contato;

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

    public Integer getCpf() {
        return cpf;
    }

    public void setCpf(Integer cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public ContatoEntity getContato() {
        return contato;
    }

    public void setContato(ContatoEntity contato) {
        this.contato = contato;
    }
}