package br.com.dbccompany.coworking.Repository;

import br.com.dbccompany.coworking.Entity.ClientePacote;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientePacoteRepository extends CrudRepository<ClientePacote, Integer> {

    ClientePacote findByQuantidade(Integer quantidade);
    List<ClientePacote> findAll();
}
