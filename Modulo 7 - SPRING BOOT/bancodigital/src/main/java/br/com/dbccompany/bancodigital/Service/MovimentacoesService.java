package br.com.dbccompany.bancodigital.Service;

import br.com.dbccompany.bancodigital.Entity.Movimentacoes;
import br.com.dbccompany.bancodigital.Repository.MovimentacoesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class MovimentacoesService {

    @Autowired
    private MovimentacoesRepository repository;

    @Transactional( rollbackFor = Exception.class )
    public Movimentacoes salvar( Movimentacoes movimentacao ){
        return repository.save( movimentacao );
    }

    @Transactional( rollbackFor = Exception.class )
    public Movimentacoes editar( Movimentacoes movimentacao, Integer id ){
        movimentacao.setId( id );
        return repository.save( movimentacao );
    }

    public List<Movimentacoes> todasMovimentacoes(){
        return repository.findAll();
    }

    public Movimentacoes movimentacaoEspecifica( Integer id ){
        Optional<Movimentacoes> movimentacao = repository.findById( id );
        return movimentacao.get();
    }
}
