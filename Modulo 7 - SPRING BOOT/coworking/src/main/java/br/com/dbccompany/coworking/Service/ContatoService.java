package br.com.dbccompany.coworking.Service;

import br.com.dbccompany.coworking.Entity.ContatoEntity;
import br.com.dbccompany.coworking.Entity.TipoContatoEntity;
import br.com.dbccompany.coworking.Repository.ContatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ContatoService {

    @Autowired
    private ContatoRepository repository;

    @Transactional(rollbackFor = Exception.class)
    public ContatoEntity salvar(ContatoEntity contato){
        return repository.save(contato);
    }

    @Transactional(rollbackFor = Exception.class)
    public ContatoEntity editar(ContatoEntity contato, Integer id){
        contato.setId(id);
        return repository.save(contato);
    }

    public List<ContatoEntity> todosContatos(){
        return repository.findAll();
    }

    public ContatoEntity contatoEspecifico(Integer id){
        Optional<ContatoEntity> contato = repository.findById(id);
        return contato.get();
    }

    public ContatoEntity contatoByTipoContato(TipoContatoEntity tipoContato){
        return repository.findByTipoContato(tipoContato);
    }

    public ContatoEntity contatoByValor(String valor){
        return repository.findByValor(valor);
    }
}