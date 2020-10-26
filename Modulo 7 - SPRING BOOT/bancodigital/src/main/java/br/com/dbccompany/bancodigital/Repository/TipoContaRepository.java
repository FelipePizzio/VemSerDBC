package br.com.dbccompany.bancodigital.Repository;

import br.com.dbccompany.bancodigital.Entity.TipoConta;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TipoContaRepository extends CrudRepository<TipoConta, Integer> {

    TipoConta findByNome( String nome );
    List<TipoConta> findAll();
}
