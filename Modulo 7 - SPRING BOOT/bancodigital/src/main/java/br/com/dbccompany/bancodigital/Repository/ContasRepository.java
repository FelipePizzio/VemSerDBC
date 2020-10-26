package br.com.dbccompany.bancodigital.Repository;

import br.com.dbccompany.bancodigital.Entity.Contas;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContasRepository extends CrudRepository<Contas, Integer> {

    Contas findByNumero( Number numero );
    Contas findBySaldo( Double saldo );
    List<Contas> findAll();
}
