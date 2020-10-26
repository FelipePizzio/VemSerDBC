package br.com.dbccompany.Cartoes.Entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table; 

@Entity
@Table( name = "CREDENCIADOR" )
public class CredenciadorEntity {

	@Id
	@SequenceGenerator( allocationSize = 1, name = "CREDENCIADOR_SEQ", sequenceName = "CREDENCIADOR_SEQ" )
	@GeneratedValue( generator = "CREDENCIADOR_SEQ", strategy = GenerationType.SEQUENCE )
	@Column( name = "ID_CREDENCIADOR" )
	private Integer id;
	
	private String nome;
	
	@ManyToMany( mappedBy = "credenciadores" )
	private List<LojaXCredenciador> lojaXCredenciador = new ArrayList<>();

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
	
	public List<LojaXCredenciador> getLojaXCredenciador() {
		return lojaXCredenciador;
	}
	public void setLojaXCredenciador(List<LojaXCredenciador> lojaXCredenciador) {
		this.lojaXCredenciador = lojaXCredenciador;
	}
}
