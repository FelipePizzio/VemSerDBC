package br.com.dbccompany.bancodigital.Service;

import br.com.dbccompany.bancodigital.Entity.Estados;
import br.com.dbccompany.bancodigital.Repository.EstadosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EstadosService {

    @Autowired
    private EstadosRepository repository;

    @Transactional( rollbackFor = Exception.class )
    public Estados salvar( Estados estado ){
        return repository.save( estado );
    }

    @Transactional( rollbackFor = Exception.class )
    public Estados editar( Estados estado, Integer id ){
        estado.setId( id );
        return repository.save( estado );
    }

    public List<Estados> todosEstados(){
        return repository.findAll();
    }

    public Estados estadoEspecifico( Integer id ){
        Optional<Estados> estado = repository.findById( id );
        return estado.get();
    }
}
