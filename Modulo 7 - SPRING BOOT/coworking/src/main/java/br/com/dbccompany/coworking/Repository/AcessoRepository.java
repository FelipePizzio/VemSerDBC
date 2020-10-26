package br.com.dbccompany.coworking.Repository;

import br.com.dbccompany.coworking.Entity.AcessoEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AcessoRepository extends CrudRepository<AcessoEntity, Integer> {

    AcessoEntity findByData(LocalDate data);
    List<AcessoEntity> findAll();
}
