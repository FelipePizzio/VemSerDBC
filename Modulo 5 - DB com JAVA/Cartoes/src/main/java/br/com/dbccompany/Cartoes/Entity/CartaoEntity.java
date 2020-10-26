package br.com.dbccompany.Cartoes.Entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table( name = "CARTÃO" )
public class CartaoEntity {

	@Id
	@SequenceGenerator( allocationSize = 1, name = "CARTAO_SEQ", sequenceName = "CARTAO_SEQ" )
	@GeneratedValue( generator = "CARTAO_SEQ", strategy = GenerationType.SEQUENCE )
	@Column( name = "ID_CARTAO" )
	private Integer id;
	
	private Boolean chip;
	
	private String vencimento;
	
	@ManyToOne( cascade = CascadeType.ALL )
	@JoinColumn( name = "FK_ID_CLIENTE" )
	private ClienteEntity cliente;
	
	@ManyToOne( cascade = CascadeType.ALL )
	@JoinColumn( name = "FK_ID_BANDEIRA" )
	private BandeiraEntity bandeira;
	
	@ManyToOne( cascade = CascadeType.ALL )
	@JoinColumn( name = "FK_ID_EMISSOR" )
	private EmissorEntity emissor;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public Boolean getChip() {
		return chip;
	}
	public void setChip(Boolean chip) {
		this.chip = chip;
	}

	public String getVencimento() {
		return vencimento;
	}
	public void setVencimento(String vencimento) {
		this.vencimento = vencimento;
	}

	public ClienteEntity getCliente() {
		return cliente;
	}
	public void setCliente(ClienteEntity cliente) {
		this.cliente = cliente;
	}

	public BandeiraEntity getBandeira() {
		return bandeira;
	}
	public void setBandeira(BandeiraEntity bandeira) {
		this.bandeira = bandeira;
	}

	public EmissorEntity getEmissor() {
		return emissor;
	}
	public void setEmissor(EmissorEntity emissor) {
		this.emissor = emissor;
	}
}
