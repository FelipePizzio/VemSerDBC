package br.com.dbccompany.Lotr.Entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table( name = "ELFO_NOTURNO" )
public class ElfoNoturnoEntity extends ElfoEntity {

	public ElfoNoturnoEntity() {
		super.setTipo(Tipo.ELFO_NOTURNO);
		super.setQtdXpAtk(3); 
		super.setQtdDano(15.0);
	}
}
