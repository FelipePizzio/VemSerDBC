package br.com.dbccompany.coworking.Repository;

import br.com.dbccompany.coworking.Entity.SaldoCliente;
import br.com.dbccompany.coworking.Entity.TipoContratacao;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface SaldoClienteRepository extends CrudRepository<SaldoCliente, Integer> {

    SaldoCliente findByTipoContratacao(TipoContratacao tipoContratacao);
    SaldoCliente findByQuantidade(Integer quantidade);
    SaldoCliente findByVencimento(LocalDate vencimento);
    List<SaldoCliente> findAll();
}
