package br.com.dbccompany.Lotr.Entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table( name = "INVENTARIO" )
public class InventarioEntity {

	@Id
	@SequenceGenerator( allocationSize = 1, name = "INVENTARIO_SEQ", sequenceName = "INVENTARIO_SEQ" )
	@GeneratedValue( generator = "INVENTARIO_SEQ", strategy = GenerationType.SEQUENCE )
	@Column( name = "ID_INVENTARIO" )
	private Integer id;

	@ManyToMany( mappedBy = "inventario" )
	private List<InventarioXItem> inventarioXItem = new ArrayList<>();
	
	@OneToOne( mappedBy = "inventario" )
	private ElfoEntity personagem;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public List<InventarioXItem> getInventarioXItem() {
		return inventarioXItem;
	}
	public void setInventarioXItem(List<InventarioXItem> inventarioXItem) {
		this.inventarioXItem = inventarioXItem;
	}
	
	public ElfoEntity getPersonagem() {
		return personagem;
	}
	public void setPersonagem(ElfoEntity personagem) {
		this.personagem = personagem;
	}
}
