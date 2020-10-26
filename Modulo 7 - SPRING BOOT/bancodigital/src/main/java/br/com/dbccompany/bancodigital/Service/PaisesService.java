package br.com.dbccompany.bancodigital.Service;

import br.com.dbccompany.bancodigital.Entity.Paises;
import br.com.dbccompany.bancodigital.Repository.PaisesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PaisesService {

    @Autowired
    private PaisesRepository repository;

    @Transactional( rollbackFor = Exception.class )
    public Paises salvar( Paises pais ){
        return repository.save( pais );
    }

    @Transactional( rollbackFor = Exception.class )
    public Paises editar( Paises pais, Integer id ){
        pais.setId( id );
        return repository.save( pais );
    }

    public List<Paises> todosPaises(){
        return repository.findAll();
    }

    public Paises paisEspecifico( Integer id ){
        Optional<Paises> pais = repository.findById( id );
        return pais.get();
    }
}
