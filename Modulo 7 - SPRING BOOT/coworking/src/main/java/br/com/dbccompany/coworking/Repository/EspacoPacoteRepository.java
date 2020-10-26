package br.com.dbccompany.coworking.Repository;

import br.com.dbccompany.coworking.Entity.EspacoPacote;
import br.com.dbccompany.coworking.Entity.TipoContratacao;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EspacoPacoteRepository extends CrudRepository<EspacoPacote, Integer> {

    EspacoPacote findByTipoContratacao(TipoContratacao tipoContratacao);
    EspacoPacote findByQuantidade(Integer quantidade);
    EspacoPacote findByPrazo(Integer prazo);
    List<EspacoPacote> findAll();
}
