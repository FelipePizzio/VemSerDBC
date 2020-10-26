package br.com.dbccompany.coworking.Entity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "USUARIOS")
public class UsuarioEntity {

    @Id
    @SequenceGenerator(allocationSize = 1, name = "USUARIO_SEQ", sequenceName = "USUARIO_SEQ")
    @GeneratedValue(generator = "USUARIO_SEQ", strategy = GenerationType.SEQUENCE)
    @Column(name = "ID_USUARIO")
    private Integer id;

    private String nome;

    @Email
    @Column(unique = true)
    private String email;

    @Column(unique = true)
    private String login;

    private String senha;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
