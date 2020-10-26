package br.com.dbccompany.coworking.Repository;

import br.com.dbccompany.coworking.Entity.TipoContatoEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TipoContatoRepository extends CrudRepository<TipoContatoEntity, Integer> {

    TipoContatoEntity findByNome(String nome);
    List<TipoContatoEntity> findAll();
}
