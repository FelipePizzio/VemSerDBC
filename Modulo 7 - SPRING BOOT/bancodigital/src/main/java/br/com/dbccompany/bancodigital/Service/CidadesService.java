package br.com.dbccompany.bancodigital.Service;

import br.com.dbccompany.bancodigital.Entity.Cidades;
import br.com.dbccompany.bancodigital.Repository.CidadesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CidadesService {

    @Autowired
    private CidadesRepository repository;

    @Transactional( rollbackFor = Exception.class)
    public Cidades salvar( Cidades cidade ){
        return repository.save( cidade );
    }

    @Transactional( rollbackFor = Exception.class)
    public Cidades editar( Cidades cidade, Integer id ){
        cidade.setId( id );
        return repository.save( cidade );
    }

    public List<Cidades> todasCidades(){
        return repository.findAll();
    }

    public Cidades cidadeEspecifica( Integer id ){
        Optional<Cidades> cidade = repository.findById( id );
        return cidade.get();
    }
}
