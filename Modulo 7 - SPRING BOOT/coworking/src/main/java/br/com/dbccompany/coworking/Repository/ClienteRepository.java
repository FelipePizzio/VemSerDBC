package br.com.dbccompany.coworking.Repository;

import br.com.dbccompany.coworking.Entity.ClienteEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ClienteRepository extends CrudRepository<ClienteEntity, Integer> {

    ClienteEntity findByNome(String nome);
    ClienteEntity findByCpf(Integer cpf);
    ClienteEntity findByDataNascimento(LocalDate dataNascimento);
    List<ClienteEntity> findAll();
}
