package br.com.dbccompany.coworking.Entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class SaldoClienteId implements Serializable {

    @Column(name = "ID_CLIENTE")
    private Integer idCliente;

    @Column(name = "ID_ESPAÇO")
    private Integer idEspaco;

    public SaldoClienteId(){}

    public SaldoClienteId(Integer idCliente, Integer idEspaco){
        this.idCliente = idCliente;
        this.idEspaco = idEspaco;
    }
}
