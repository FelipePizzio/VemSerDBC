package br.com.dbccompany.Lotr.Entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@MappedSuperclass
@Inheritance( strategy = InheritanceType.TABLE_PER_CLASS )
@Table(name = "PERSONAGEM")
public class PersonagemEntity {

	@Id
	@SequenceGenerator( allocationSize = 1, name = "PERSONAGEM_SEQ", sequenceName = "PERSONAGEM_SEQ" )
	@GeneratedValue( generator = "PERSONAGEM_SEQ", strategy = GenerationType.SEQUENCE )
	@Column( name = "ID_PERSONAGEM" )
	private Integer id;
	
	@Column( name = "NOME" )
	private String nome;
	
	@Enumerated( EnumType.STRING )
	private Status status;
	
	private Double vida;
	
	@Column( name = "QTD_DANO" )
	private Double qtdDano;
	
	private Integer xp;
	
	@Column( name = "QTD_XP_POR_ATK" )
	private Integer qtdXpAtk;
	
	@Enumerated( EnumType.STRING )
	@Column( name = "RAÇA" )
	private Tipo tipo;
	
	@OneToOne( cascade = CascadeType.ALL )
	@JoinColumn( name = "FK_ID_INVENTARIO" )
	private InventarioEntity inventario;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}

	public Double getVida() {
		return vida;
	}
	public void setVida(Double vida) {
		this.vida = vida;
	}

	public Double getQtdDano() {
		return qtdDano;
	}
	public void setQtdDano(Double qtdDano) {
		this.qtdDano = qtdDano;
	}

	public Integer getXp() {
		return xp;
	}
	public void setXp(Integer xp) {
		this.xp = xp;
	}

	public Integer getQtdXpAtk() {
		return qtdXpAtk;
	}
	public void setQtdXpAtk(Integer qtdXpAtk) {
		this.qtdXpAtk = qtdXpAtk;
	}

	public Tipo getTipo() {
		return tipo;
	}
	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}
	
	public InventarioEntity getInventario() {
		return inventario;
	}
	public void setInventario(InventarioEntity inventario) {
		this.inventario = inventario;
	}
}
