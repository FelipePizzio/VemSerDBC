package br.com.dbccompany.ProjetoFinal.Document;

public class Experiencias {

    private String localExperiencia;
    private String cargo;
    private String periodo;

    public Experiencias(String localExperiencia, String cargo, String periodo) {
        this.localExperiencia = localExperiencia;
        this.cargo = cargo;
        this.periodo = periodo;
    }

    public String getlocalExperiencia() {
        return localExperiencia;
    }

    public void setlocalExperiencia(String localExperiencia) {
        this.localExperiencia = localExperiencia;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }
}