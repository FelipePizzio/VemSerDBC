package br.com.dbccompany.bancodigital.Repository;

import br.com.dbccompany.bancodigital.Entity.Cidades;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CidadesRepository extends CrudRepository<Cidades, Integer> {

    Cidades findByNome( String nome );
    List<Cidades> findAll();
}
