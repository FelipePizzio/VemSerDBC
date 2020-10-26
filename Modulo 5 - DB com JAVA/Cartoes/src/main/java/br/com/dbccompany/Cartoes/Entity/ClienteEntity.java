package br.com.dbccompany.Cartoes.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table( name = "CLIENTE" )
public class ClienteEntity {

	@Id
	@SequenceGenerator( allocationSize = 1, name = "CLIENTE_SEQ", sequenceName = "CLIENTE_SEQ" )
	@GeneratedValue( generator = "CLIENTE_SEQ", strategy = GenerationType.SEQUENCE )
	@Column( name = "ID_CLIENTE" )
	private Integer id;
	
	private String nome;

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
}
