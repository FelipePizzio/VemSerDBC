package br.com.dbccompany.ProjetoFinal.Document;

public class DadosEscolares {

    private String localEscolar;
    private String graduacao;
    private String anoGraduacao;

    public DadosEscolares(String localEscolar,String graduacao, String anoGraduacao) {
        this.localEscolar = localEscolar;
        this.graduacao = graduacao;
        this.anoGraduacao = String.format(anoGraduacao, "yyyy");
    }

    public String getAnoGraduacao() {
        return anoGraduacao;
    }

    public void setAnoGraduacao(String anoGraduacao) {
        this.anoGraduacao = anoGraduacao;
    }

    public String getLocalEscolar() {
        return localEscolar;
    }

    public void setLocalEscolar(String localEscolar) {
        this.localEscolar = localEscolar;
    }

    public String getGraduacao() {
        return graduacao;
    }

    public void setGraduacao(String graduacao) {
        this.graduacao = graduacao;
    }
}
