package br.com.dbccompany.Lotr.Entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table( name = "DWARF" )
public class DwarfEntity extends PersonagemEntity {
	
	public DwarfEntity() {
		super.setTipo(Tipo.DWARF);
		super.setVida(110.0);
		super.setQtdDano(10.0);
	}
	
}
