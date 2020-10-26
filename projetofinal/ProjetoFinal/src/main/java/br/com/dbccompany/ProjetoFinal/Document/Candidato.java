package br.com.dbccompany.ProjetoFinal.Document;

import com.mongodb.lang.Nullable;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.util.List;

@Document(collection = "candidatos")
public class Candidato {
    @Id
    private String id;
    @NotNull
    private String nome;
    @NotNull
    private DadosPessoais dadosPessoais;
    private Endereco endereco;
    private DadosEscolares dadosEscolares;
    private Experiencias experiencias;
    private String linkCurriculo;
    @Nullable
    private List<String> codigoVaga;

    public Candidato(@NotNull String nome, @NotNull DadosPessoais dadosPessoais, DadosEscolares dadosEscolares, Experiencias experiencias, String linkCurriculo, @Nullable List<String>  codigoVaga) {
        this.nome = nome;
        this.dadosPessoais = dadosPessoais;
        this.dadosEscolares = dadosEscolares;
        this.experiencias = experiencias;
        this.linkCurriculo = linkCurriculo;
        this.codigoVaga = codigoVaga;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public DadosPessoais getDadosPessoais() {
        return dadosPessoais;
    }
    public void setDadosPessoais(DadosPessoais dadosPessoais) {
        this.dadosPessoais = dadosPessoais;
    }

    public DadosEscolares getDadosEscolares() {
        return dadosEscolares;
    }
    public void setDadosEscolares(DadosEscolares dadosEscolares) {
        this.dadosEscolares = dadosEscolares;
    }

    public Experiencias getExperiencias() {
        return experiencias;
    }
    public void setExperiencias(Experiencias experiencias) {
        this.experiencias = experiencias;
    }

    public String getLinkCurriculo() {
        return linkCurriculo;
    }
    public void setLinkCurriculo(String linkCurriculo) {
        this.linkCurriculo = linkCurriculo;
    }

    public List<String> getCodigoVaga() {
        return codigoVaga;
    }

    public void setCodigoVaga(List<String> codigoVaga) {
        this.codigoVaga = codigoVaga;
    }

    public Endereco getEndereco() {
        return endereco;
    }
    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

}