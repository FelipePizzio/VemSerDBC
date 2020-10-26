package br.com.dbccompany.bancodigital.Repository;

import br.com.dbccompany.bancodigital.Entity.Agencias;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AgenciasRepository extends CrudRepository<Agencias, Integer> {

    Agencias findByNome( String nome );
    List<Agencias> findAll();

}
