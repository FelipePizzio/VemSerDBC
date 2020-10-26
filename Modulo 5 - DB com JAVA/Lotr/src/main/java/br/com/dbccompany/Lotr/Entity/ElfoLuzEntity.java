package br.com.dbccompany.Lotr.Entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table( name = "ELFO_LUZ" )
public class ElfoLuzEntity extends ElfoEntity {

	public ElfoLuzEntity() {
		super.setTipo(Tipo.ELFO_LUZ); 
		super.setQtdDano(21.0);
	}
}
