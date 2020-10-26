package br.com.dbccompany.bancodigital.Repository;

import br.com.dbccompany.bancodigital.Entity.Estados;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EstadosRepository extends CrudRepository<Estados, Integer> {

    Estados findByNome( String nome );
    List<Estados> findAll();
}
