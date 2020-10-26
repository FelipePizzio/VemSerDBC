package br.com.dbccompany.bancodigital.Service;

import br.com.dbccompany.bancodigital.Entity.TipoConta;
import br.com.dbccompany.bancodigital.Repository.TipoContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class TipoContaService {

    @Autowired
    private TipoContaRepository repository;

    @Transactional( rollbackFor = Exception.class )
    public TipoConta salvar( TipoConta tipoConta ){
        return  repository.save( tipoConta );
    }

    @Transactional( rollbackFor = Exception.class )
    public TipoConta editar( TipoConta tipoConta, Integer id ){
        tipoConta.setId( id );
        return  repository.save( tipoConta );
    }

    public List<TipoConta> todosTipoConta(){
        return repository.findAll();
    }

    public TipoConta tipoContaEspecifico( Integer id ){
        Optional<TipoConta> tipoConta = repository.findById( id );
        return tipoConta.get();
    }
}
