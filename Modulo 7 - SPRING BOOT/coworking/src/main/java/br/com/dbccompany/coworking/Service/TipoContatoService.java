package br.com.dbccompany.coworking.Service;

import br.com.dbccompany.coworking.Entity.TipoContatoEntity;
import br.com.dbccompany.coworking.Repository.TipoContatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class TipoContatoService {

    @Autowired
    private TipoContatoRepository repository;

    @Transactional(rollbackFor = Exception.class)
    public TipoContatoEntity salvar(TipoContatoEntity tipoContato){
        return repository.save(tipoContato);
    }

    @Transactional(rollbackFor = Exception.class)
    public TipoContatoEntity editar(TipoContatoEntity tipoContato, Integer id){
        tipoContato.setId(id);
        return repository.save(tipoContato);
    }

    public List<TipoContatoEntity> todosTipoContato(){
        return repository.findAll();
    }

    public TipoContatoEntity tipoContatoEspecifico(Integer id){
        Optional<TipoContatoEntity> tipoContato = repository.findById(id);
        return tipoContato.get();
    }
}
