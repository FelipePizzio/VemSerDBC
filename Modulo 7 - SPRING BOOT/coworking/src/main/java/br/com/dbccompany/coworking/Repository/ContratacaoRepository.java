package br.com.dbccompany.coworking.Repository;

import br.com.dbccompany.coworking.Entity.ContratacaoEntity;
import br.com.dbccompany.coworking.Entity.TipoContratacao;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContratacaoRepository extends CrudRepository<ContratacaoEntity, Integer> {

    ContratacaoEntity findByTipoContratacao(TipoContratacao tipoContratacao);
    ContratacaoEntity findByQuantidade(Integer quantidade);
    ContratacaoEntity findByDesconto(Integer desconto);
    ContratacaoEntity findByPrazo(Integer prazo);
    List<ContratacaoEntity> findAll();
}
