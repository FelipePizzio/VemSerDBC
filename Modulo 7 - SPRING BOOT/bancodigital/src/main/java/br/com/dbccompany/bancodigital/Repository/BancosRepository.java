package br.com.dbccompany.bancodigital.Repository;

import br.com.dbccompany.bancodigital.Entity.Bancos;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BancosRepository extends CrudRepository<Bancos, Integer> {

    Bancos findByNome( String nome );
    List<Bancos> findAll();

}
