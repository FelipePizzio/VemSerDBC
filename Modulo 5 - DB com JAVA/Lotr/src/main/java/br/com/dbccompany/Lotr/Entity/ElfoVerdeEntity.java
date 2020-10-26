package br.com.dbccompany.Lotr.Entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table( name = "ELFO_VERDE" )
public class ElfoVerdeEntity extends ElfoEntity {

	public ElfoVerdeEntity() {
		super.setTipo(Tipo.ELFO_VERDE);
		super.setQtdXpAtk(2);
	}
}
