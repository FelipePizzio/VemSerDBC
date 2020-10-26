package br.com.dbccompany.Cartoes.Entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table( name = "LOJA_X_CREDENCIADOR" )
public class LojaXCredenciador {

	@Id
	@GeneratedValue( generator = "LOJA_X_CREDENCIADOR_SEQ", strategy = GenerationType.SEQUENCE )
	@SequenceGenerator( allocationSize = 1, name = "LOJA_X_CREDENCIADOR_SEQ", sequenceName = "LOJA_X_CREDENCIADOR_SEQ" )
	@Column( name = "ID_LOJA_X_CREDENCIADOR" )
	private Integer id;
	
	private Double taxa;
	
	@ManyToMany( cascade = CascadeType.ALL )
	@JoinTable( name = "id_loja",
		joinColumns = {
			@JoinColumn( name = "id_loja_x_credenciador" )},
		inverseJoinColumns = {
			@JoinColumn( name = "id_loja" )})
 	private List<LojaEntity> lojas = new ArrayList<>();
	
	@ManyToMany( cascade = CascadeType.ALL )
	@JoinTable( name = "id_credenciador",
		joinColumns = {
			@JoinColumn( name = "id_loja_x_credenciador" )},
		inverseJoinColumns = {
			@JoinColumn( name = "id_credenciador" )})
	private List<CredenciadorEntity> credenciadores = new ArrayList<>();

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public Double getTaxa() {
		return taxa;
	}
	public void setTaxa(Double taxa) {
		this.taxa = taxa;
	}

	public List<LojaEntity> getLojas() {
		return lojas;
	}
	public void setLojas(List<LojaEntity> lojas) {
		this.lojas = lojas;
	}

	public List<CredenciadorEntity> getCredenciadores() {
		return credenciadores;
	}
	public void setCredenciadores(List<CredenciadorEntity> credenciadores) {
		this.credenciadores = credenciadores;
	}
}
