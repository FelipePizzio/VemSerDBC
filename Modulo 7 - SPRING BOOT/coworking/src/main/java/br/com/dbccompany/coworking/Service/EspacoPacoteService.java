package br.com.dbccompany.coworking.Service;

import br.com.dbccompany.coworking.Entity.EspacoPacote;
import br.com.dbccompany.coworking.Repository.EspacoPacoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EspacoPacoteService {

    @Autowired
    private EspacoPacoteRepository repository;

    @Transactional(rollbackFor = Exception.class)
    public EspacoPacote salvar(EspacoPacote espacoPacote){
        return repository.save(espacoPacote);
    }

    @Transactional(rollbackFor = Exception.class)
    public EspacoPacote editar(EspacoPacote espacoPacote, Integer id){
        espacoPacote.setId(id);
        return repository.save(espacoPacote);
    }

    public List<EspacoPacote> todosEspacosPacotes(){
        return repository.findAll();
    }

    public EspacoPacote espacoPacoteEspecifico(Integer id){
        Optional<EspacoPacote> espacoPacote = repository.findById(id);
        return espacoPacote.get();
    }
}
