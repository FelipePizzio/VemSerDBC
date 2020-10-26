package br.com.dbccompany.Lotr.Entity;

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
@Table( name = "ITEM" )
public class ItemEntity {

	@Id
	@GeneratedValue( generator = "ITEM_SEQ", strategy = GenerationType.SEQUENCE )
	@SequenceGenerator( allocationSize = 1, name = "ITEM_SEQ", sequenceName = "ITEM_SEQ" )
	@Column( name = "ID_ITEM", nullable = false )
	private Integer id;
	
	@Column( name = "DESCRIÇÃO" )
	private String descricao;
	
	@ManyToMany( mappedBy = "itens" )
	private List<InventarioXItem> inventarioXItem = new ArrayList<>();

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
	
	public List<InventarioXItem> getInventarioXItem() {
		return inventarioXItem;
	}
	public void setInventarioXItem(List<InventarioXItem> inventarioXItem) {
		this.inventarioXItem = inventarioXItem;
	}
}
