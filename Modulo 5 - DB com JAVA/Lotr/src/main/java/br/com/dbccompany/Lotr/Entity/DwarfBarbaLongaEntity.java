package br.com.dbccompany.Lotr.Entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table( name = "DWARF_BARBA_LONGA" )
public class DwarfBarbaLongaEntity extends DwarfEntity {
	
	public DwarfBarbaLongaEntity() {
		super.setTipo(Tipo.DWARF_BARBA_LONGA);
	}
	
}
