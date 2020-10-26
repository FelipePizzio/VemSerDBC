package br.com.dbccompany.coworking.Service;

import br.com.dbccompany.coworking.Entity.AcessoEntity;
import br.com.dbccompany.coworking.Repository.AcessoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class AcessoService {

    @Autowired
    AcessoRepository repository;

    @Transactional(rollbackFor = Exception.class)
    public AcessoEntity salvar(AcessoEntity acesso){
        return repository.save(acesso);
    }

    @Transactional(rollbackFor = Exception.class)
    public AcessoEntity editar(AcessoEntity acesso, Integer id){
        acesso.setId(id);
        return repository.save(acesso);
    }

    public List<AcessoEntity> todosAcessos(){
        return repository.findAll();
    }

    public AcessoEntity acessoEspecifico(Integer id){
        Optional<AcessoEntity> acesso = repository.findById(id);
        return acesso.get();
    }

    public AcessoEntity acessoByData(LocalDate data){
        return repository.findByData(data);
    }
}
