package br.com.dbccompany.coworking.Service;

import br.com.dbccompany.coworking.Entity.EspacoEntity;
import br.com.dbccompany.coworking.Repository.EspacoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EspacoService {

    @Autowired
    private EspacoRepository repository;

    @Transactional(rollbackFor = Exception.class)
    public EspacoEntity salvar(EspacoEntity espaco){
        return repository.save(espaco);
    }

    @Transactional(rollbackFor = Exception.class)
    public EspacoEntity editar(EspacoEntity espaco, Integer id){
        espaco.setId(id);
        return repository.save(espaco);
    }

    public List<EspacoEntity> todosEspacos(){
        return repository.findAll();
    }

    public EspacoEntity espacoEspecifico(Integer id){
        Optional<EspacoEntity> espaco = repository.findById(id);
        return espaco.get();
    }
}
