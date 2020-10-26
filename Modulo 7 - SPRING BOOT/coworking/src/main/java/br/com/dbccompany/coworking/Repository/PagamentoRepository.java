package br.com.dbccompany.coworking.Repository;

import br.com.dbccompany.coworking.Entity.PagamentoEntity;
import br.com.dbccompany.coworking.Entity.TipoPagamento;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PagamentoRepository extends CrudRepository<PagamentoEntity, Integer> {

    PagamentoEntity findByTipoPagamento(TipoPagamento tipoPagamento);
    List<PagamentoEntity> findAll();
}
