package br.com.dbccompany.coworking.Repository;

import br.com.dbccompany.coworking.Entity.PacoteEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PacoteRepository extends CrudRepository<PacoteEntity, Integer> {

    PacoteEntity findByValor(Integer valor);
    List<PacoteEntity> findAll();
}
