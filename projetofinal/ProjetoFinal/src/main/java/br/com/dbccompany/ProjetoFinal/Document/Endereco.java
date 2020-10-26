package br.com.dbccompany.ProjetoFinal.Document;

import com.mongodb.lang.Nullable;

import javax.validation.constraints.NotNull;

public class Endereco {

    @NotNull
    private String estado;
    @NotNull
    private String cidade;
    @NotNull
    private String bairro;
    @NotNull
    private String rua;
    @NotNull
    private Integer numero;
    @Nullable
    private String complemento;

    public Endereco(String estado, String cidade, String bairro, String rua, Integer numero, @Nullable String complemento) {
        this.estado = estado;
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
        this.numero = numero;
        this.complemento = complemento;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    @Nullable
    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(@Nullable String complemento) {
        this.complemento = complemento;
    }
}
