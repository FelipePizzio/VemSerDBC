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
@Table( name = "LOJA" )
public class LojaEntity {

	@Id
	@SequenceGenerator( allocationSize = 1, name = "LOJA_SEQ", sequenceName = "LOJA_SEQ" )
	@GeneratedValue( generator = "LOJA_SEQ", strategy = GenerationType.SEQUENCE )
	@Column( name = "ID_LOJA" )
	private Integer id;
	
	private String nome;
	
	@ManyToMany( mappedBy = "lojas" )
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
