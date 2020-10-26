package br.com.dbccompany.bancodigital.Repository;

import br.com.dbccompany.bancodigital.Entity.Clientes;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientesRepository extends CrudRepository<Clientes, Integer> {

    Clientes findByNome( String nome );
    Clientes findByCpf( String cpf );
    List<Clientes> findAll();
}
