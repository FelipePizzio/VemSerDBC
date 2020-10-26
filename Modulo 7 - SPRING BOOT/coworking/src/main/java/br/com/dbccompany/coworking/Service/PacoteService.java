package br.com.dbccompany.coworking.Service;

import br.com.dbccompany.coworking.Entity.PacoteEntity;
import br.com.dbccompany.coworking.Repository.PacoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PacoteService {

    @Autowired
    private PacoteRepository repository;

    @Transactional(rollbackFor = Exception.class)
    public PacoteEntity salvar(PacoteEntity pacote){
        return repository.save(pacote);
    }

    @Transactional(rollbackFor = Exception.class)
    public PacoteEntity editar(PacoteEntity pacote, Integer id){
        pacote.setId(id);
        return repository.save(pacote);
    }

    public List<PacoteEntity> todosPacotes(){
        return repository.findAll();
    }

    public PacoteEntity pacoteEspecifico(Integer id){
        Optional<PacoteEntity> pacote = repository.findById(id);
        return pacote.get();
    }
}
