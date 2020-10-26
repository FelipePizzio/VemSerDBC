package br.com.dbccompany.bancodigital.Service;

import br.com.dbccompany.bancodigital.Entity.Agencias;
import br.com.dbccompany.bancodigital.Repository.AgenciasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class AgenciasService {

    @Autowired
    private AgenciasRepository repository;

    @Transactional( rollbackFor = Exception.class)
    public Agencias salvar( Agencias agencia ){
        return repository.save( agencia );
    }

    @Transactional( rollbackFor = Exception.class)
    public Agencias editar( Agencias agencia, Integer id ){
        agencia.setId( id );
        return repository.save( agencia );
    }

    public List<Agencias> todasAgencias(){
        return repository.findAll();
    }

    public Agencias agenciaEspecifica( Integer id ){
        Optional<Agencias> agencia = repository.findById( id );
        return agencia.get();
    }
}
