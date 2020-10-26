package br.com.dbccompany.ProjetoFinal.Document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


@Document(collection = "vagas")
public class Vagas {

    @Id
    private String id;
    private String titulo;
    private String dataabertura;
    private String codigovaga;
    private String url;
    private String cidade;
    private String estado;
    private Integer codigofilial;
    private String nomefilial;
    private String descricaovaga;
    private List<Candidato> candidatos;

    public Vagas(){}

    public Vagas(String titulo, String dataabertura, String codigoVaga,
                 String url, String cidade, String estado, Integer codigoFilial,
                 String nomeFilial, String descricaoVaga, List<Candidato> candidatos ) {
        this.titulo = titulo;
        this.dataabertura = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
        this.codigovaga = codigoVaga;
        this.url = url;
        this.cidade = cidade;
        this.estado = estado;
        this.codigofilial = codigoFilial;
        this.nomefilial = nomeFilial;
        this.descricaovaga = descricaoVaga;
        this.candidatos = candidatos;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDataabertura() {
        return dataabertura;
    }
    public void setDataabertura(String dataabertura) {
        this.dataabertura = dataabertura;
    }

    public String getCodigovaga() {
        return codigovaga;
    }
    public void setCodigovaga(String codigovaga) {
        this.codigovaga = codigovaga;
    }

    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }

    public String getCidade() {
        return cidade;
    }
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Integer getCodigofilial() {
        return codigofilial;
    }
    public void setCodigofilial(Integer codigofilial) {
        this.codigofilial = codigofilial;
    }

    public String getNomefilial() {
        return nomefilial;
    }
    public void setNomefilial(String nomefilial) {
        this.nomefilial = nomefilial;
    }

    public String getDescricaovaga() {
        return descricaovaga;
    }
    public void setDescricaovaga(String descricaovaga) {
        this.descricaovaga = descricaovaga;
    }

    public List<Candidato> getCandidatos() {
        return candidatos;
    }

    public void setCandidatos(List<Candidato> candidatos) {
        this.candidatos = candidatos;
    }
}
