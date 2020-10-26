package br.com.dbccompany.coworking.Entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Entity
@Table(name = "ACESSOS")
public class AcessoEntity {

    @Id
    @SequenceGenerator( allocationSize = 1, name = "ACESSO_SEQ", sequenceName = "ACESSO_SEQ")
    @GeneratedValue( generator = "ACESSO_SEQ", strategy = GenerationType.SEQUENCE)
    @Column( name = "ID_ACESSO")
    private Integer id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_CLIENTE", referencedColumnName = "ID_CLIENTE")
    private ClienteEntity cliente;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_ESPAÇO", referencedColumnName = "ID_ESPAÇO")
    private EspacoEntity espaco;

    @Column(name = "ENTRADA")
    private Boolean is_Entrada;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @NotBlank
    private LocalDate data;

    @Column(name = "EXCEÇÃO")
    private Boolean is_Excecao;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ClienteEntity getCliente() {
        return cliente;
    }

    public void setCliente(ClienteEntity cliente) {
        this.cliente = cliente;
    }

    public EspacoEntity getEspaco() {
        return espaco;
    }

    public void setEspaco(EspacoEntity espaco) {
        this.espaco = espaco;
    }

    public Boolean getIs_Entrada() {
        return is_Entrada;
    }

    public void setIs_Entrada(Boolean is_Entrada) {
        this.is_Entrada = is_Entrada;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Boolean getIs_Excecao() {
        return is_Excecao;
    }

    public void setIs_Excecao(Boolean is_Excecao) {
        this.is_Excecao = is_Excecao;
    }
}
