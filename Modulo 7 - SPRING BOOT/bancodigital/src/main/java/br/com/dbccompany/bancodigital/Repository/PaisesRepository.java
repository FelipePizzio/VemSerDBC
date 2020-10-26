package br.com.dbccompany.bancodigital.Repository;

import br.com.dbccompany.bancodigital.Entity.Paises;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaisesRepository extends CrudRepository<Paises, Integer> {

    Paises findByNome( String nome );
    List<Paises> findAll();
}
