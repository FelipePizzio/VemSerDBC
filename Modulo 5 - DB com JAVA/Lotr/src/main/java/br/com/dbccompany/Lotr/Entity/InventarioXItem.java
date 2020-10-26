package br.com.dbccompany.Lotr.Entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
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
@Table( name = "INVENTARIO_X_ITEM" )
public class InventarioXItem {
	
	@Id
	@GeneratedValue( generator = "INVENTARIO_X_ITEM_SEQ", strategy = GenerationType.SEQUENCE )
	@SequenceGenerator( allocationSize = 1, name = "INVENTARIO_X_ITEM_SEQ", sequenceName = "INVENTARIO_X_ITEM_SEQ" )
	private Integer id;
	
	@ManyToMany( cascade = CascadeType.ALL )
	@JoinTable( name = "id_inventario",
		joinColumns = { 
			@JoinColumn( name = "id_inventario_x_item" )},
		inverseJoinColumns = { 
			@JoinColumn( name = "id_inventario" )})
	private List<InventarioEntity> inventario = new ArrayList<>();
	
	@ManyToMany( cascade = CascadeType.ALL )
	@JoinTable( name = "id_item",
		joinColumns = { 
			@JoinColumn( name = "id_inventario_x_item" )},
		inverseJoinColumns = { 
			@JoinColumn( name = "id_item" )})
	private List<ItemEntity> itens = new ArrayList<>();
	
	private Integer quantidade;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public List<InventarioEntity> getInventario() {
		return inventario;
	}
	public void setInventario(List<InventarioEntity> inventario) {
		this.inventario = inventario;
	}

	public List<ItemEntity> getItens() {
		return itens;
	}
	public void setItens(List<ItemEntity> itens) {
		this.itens = itens;
	}

	public Integer getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
}
