package br.com.dbccompany.Cartoes.Entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table( name = "LANÇAMENTO" )
public class LancamentoEntity {

	@Id
	@SequenceGenerator( allocationSize = 1, name = "LANÇAMENTO_SEQ", sequenceName = "LANÇAMENTO_SEQ" )
	@GeneratedValue( generator = "LANÇAMENTO_SEQ", strategy = GenerationType.SEQUENCE )
	@Column( name = "ID_LANÇAMENTO" )
	private Integer id;
	
	private String descricao;
	
	private Double valor;
	
	private String data_compra;
	
	@OneToOne( cascade = CascadeType.ALL )
	@JoinColumn( name = "FK_ID_CARTÃO" )
	private CartaoEntity cartao;
	
	@OneToOne( cascade = CascadeType.ALL )
	@JoinColumn( name = "FK_ID_LOJA" )
	private LojaEntity loja;
	
	@OneToOne( cascade = CascadeType.ALL )
	@JoinColumn( name = "FK_ID_EMISSOR" )
	private EmissorEntity emissor;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	public String getData_compra() {
		return data_compra;
	}
	public void setData_compra(String data_compra) {
		this.data_compra = data_compra;
	}
	public CartaoEntity getCartao() {
		return cartao;
	}
	public void setCartao(CartaoEntity cartao) {
		this.cartao = cartao;
	}
	public LojaEntity getLoja() {
		return loja;
	}
	public void setLoja(LojaEntity loja) {
		this.loja = loja;
	}
	public EmissorEntity getEmissor() {
		return emissor;
	}
	public void setEmissor(EmissorEntity emissor) {
		this.emissor = emissor;
	}
}
