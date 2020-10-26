package br.com.dbccompany.Cartoes.Entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class LojaCredenciadorId {

	@Column( name = "ID_LOJA" )
	private Integer idLoja;
	
	@Column( name = "ID_CREDENCIADOR" )
	private Integer idCredenciador;
	
	public LojaCredenciadorId(){}
	
	public LojaCredenciadorId( Integer idLoja, Integer idCredenciador ){
		this.idLoja = idLoja;
		this.idCredenciador = idCredenciador;
	}
}
