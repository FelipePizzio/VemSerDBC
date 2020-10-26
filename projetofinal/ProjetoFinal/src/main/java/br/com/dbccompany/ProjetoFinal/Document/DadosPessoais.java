package br.com.dbccompany.ProjetoFinal.Document;

import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotNull;

public class DadosPessoais {

    @CPF
    @NotNull
    private String cpf;
    @NotNull
    private String dataNascimento;
    private String telefone;
    private String email;

    public DadosPessoais(@CPF String cpf, String dataNascimento, String telefone, String email) {
        this.cpf = cpf;
        this.dataNascimento = String.format(dataNascimento, "dd/MM/yyyy");
        this.telefone = String.format(telefone, "(xx) xxxxx-xxxx");
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}
