package br.com.dbccompany.Cartoes.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table( name = "BANDEIRA" )
public class BandeiraEntity {

	@Id
	@SequenceGenerator( allocationSize = 1, name = "BANDEIRA_SEQ", sequenceName = "BANDEIRA_SEQ" )
	@GeneratedValue( generator = "BANDEIRA_SEQ", strategy = GenerationType.SEQUENCE )
	@Column( name = "ID_BANDEIRA" )
	private Integer id;
	
	private String nome;
	
	private Double taxa;

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
	
	public Double getTaxa() {
		return taxa;
	}
	public void setTaxa(Double taxa) {
		this.taxa = taxa;
	}
	
}
