package br.com.dbccompany.Cartoes.Entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table( name = "LOJA_CREDENCIADOR" )
public class LojaCredenciador {

	@EmbeddedId
	private LojaCredenciadorId id;

	public LojaCredenciadorId getId() {
		return id;
	}
	public void setId(LojaCredenciadorId id) {
		this.id = id;
	}
}
