package br.com.dbccompany.coworking.Repository;

import br.com.dbccompany.coworking.Entity.EspacoEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EspacoRepository extends CrudRepository<EspacoEntity, Integer> {

    EspacoEntity findByNome(String nome);
    EspacoEntity findByQtdPessoas(Integer qtdPessoas);
    EspacoEntity findByValor(Integer valor);
    List<EspacoEntity> findAll();
}
