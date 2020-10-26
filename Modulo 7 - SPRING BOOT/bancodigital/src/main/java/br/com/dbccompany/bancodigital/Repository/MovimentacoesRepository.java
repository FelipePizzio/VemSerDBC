package br.com.dbccompany.bancodigital.Repository;

import br.com.dbccompany.bancodigital.Entity.Movimentacoes;
import br.com.dbccompany.bancodigital.Entity.TipoMovimentacao;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovimentacoesRepository extends CrudRepository<Movimentacoes, Integer> {

    Movimentacoes findByValor( Double valor );
    //Movimentacoes findByType( TipoMovimentacao tipoMovimentacao);
    List<Movimentacoes> findAll();
}
