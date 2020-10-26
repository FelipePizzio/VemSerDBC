package br.com.dbccompany.coworking.Service;

import br.com.dbccompany.coworking.Entity.ClientePacote;
import br.com.dbccompany.coworking.Repository.ClientePacoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ClientePacoteService {

    @Autowired
    private ClientePacoteRepository repository;

    @Transactional(rollbackFor = Exception.class)
    public ClientePacote salvar(ClientePacote clientePacote){
        return repository.save(clientePacote);
    }

    @Transactional(rollbackFor = Exception.class)
    public ClientePacote editar(ClientePacote clientePacote, Integer id){
        clientePacote.setId(id);
        return repository.save(clientePacote);
    }

    public List<ClientePacote> todosClientePacote(){
        return repository.findAll();
    }

    public ClientePacote clientePacoteEspecifico(Integer id){
        Optional<ClientePacote> clientePacote = repository.findById(id);
        return clientePacote.get();
    }

    public ClientePacote clientePacoteByQuantidade(Integer quantidade){
        return repository.findByQuantidade(quantidade);
    }
}
