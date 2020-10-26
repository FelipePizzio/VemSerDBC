package br.com.dbccompany.bancodigital.Entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Contas {

    @Id
    @SequenceGenerator( allocationSize = 1, name = "CONTAS_SEQ", sequenceName = "CONTAS_SEQ")
    @GeneratedValue( generator = "CONTAS_SEQ", strategy = GenerationType.SEQUENCE)
    @Column( name = "ID_CONTAS")
    private Integer id;

    private Number numero;

    private Double saldo;

    @ManyToOne( cascade = CascadeType.ALL)
    @JoinColumn( name = "id_tipo_conta")
    private TipoConta tipoConta;

    @ManyToOne( cascade = CascadeType.ALL)
    @JoinColumn( name = "id_agencia")
    private Agencias agencia;

    @ManyToMany( cascade = CascadeType.ALL)
    @JoinTable( name = "clientes_x_contas",
            joinColumns = { @JoinColumn( name = "id_conta" ) },
            inverseJoinColumns = { @JoinColumn( name = "id_cliente") } )
    private List<Clientes> clientes = new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Number getNumero() {
        return numero;
    }

    public void setNumero(Number numero) {
        this.numero = numero;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public TipoConta getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(TipoConta tipoConta) {
        this.tipoConta = tipoConta;
    }

    public Agencias getAgencia() {
        return agencia;
    }

    public void setAgencia(Agencias agencia) {
        this.agencia = agencia;
    }

    public List<Clientes> getClientes() {
        return clientes;
    }

    public void setClientes(List<Clientes> clientes) {
        this.clientes = clientes;
    }
}
