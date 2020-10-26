package br.com.dbccompany.Lotr.Entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table( name = "ELFO" )
public class ElfoEntity extends PersonagemEntity {
	
	public ElfoEntity() {
		super.setTipo(Tipo.ELFO);
		super.setVida(100.0);
		super.setQtdXpAtk(1);
	}
	
}
