package br.com.dbccompany.coworking.Repository;

import br.com.dbccompany.coworking.Entity.ContatoEntity;
import br.com.dbccompany.coworking.Entity.TipoContatoEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContatoRepository extends CrudRepository<ContatoEntity, Integer> {

    ContatoEntity findByTipoContato(TipoContatoEntity tipoContato);
    ContatoEntity findByValor(String valor);
    List<ContatoEntity> findAll();
}
