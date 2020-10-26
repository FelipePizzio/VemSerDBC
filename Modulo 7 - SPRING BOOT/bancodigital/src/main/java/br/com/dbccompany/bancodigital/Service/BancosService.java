package br.com.dbccompany.bancodigital.Service;

import br.com.dbccompany.bancodigital.Entity.Bancos;
import br.com.dbccompany.bancodigital.Repository.BancosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class BancosService {

    @Autowired
    private BancosRepository repository;

    @Transactional( rollbackFor = Exception.class )
    public Bancos salvar( Bancos banco ){
        return repository.save( banco );
    }

    @Transactional( rollbackFor = Exception.class )
    public Bancos editar( Bancos banco, Integer id ){
        banco.setId( id );
        return repository.save( banco );
    }

    public List<Bancos> todosBancos(){
        return repository.findAll();
    }

    public Bancos bancoEspecifico( Integer id ){
        Optional<Bancos> banco = repository.findById( id );
        return banco.get();
    }

}
