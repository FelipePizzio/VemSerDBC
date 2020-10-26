package br.com.dbccompany.coworking.Service;

import br.com.dbccompany.coworking.Entity.ClienteEntity;
import br.com.dbccompany.coworking.Repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    @Transactional(rollbackFor = Exception.class)
    public ClienteEntity salvar(ClienteEntity cliente){
        return repository.save(cliente);
    }

    @Transactional(rollbackFor = Exception.class)
    public ClienteEntity editar(ClienteEntity cliente, Integer id){
        cliente.setId(id);
        return repository.save(cliente);
    }

    public List<ClienteEntity> todosClientes(){
        return repository.findAll();
    }

    public ClienteEntity clienteEspecifico(Integer id){
        Optional<ClienteEntity> cliente = repository.findById(id);
        return cliente.get();
    }

    public ClienteEntity clienteByNome(String nome){
        return repository.findByNome(nome);
    }

    public ClienteEntity clienteByCpf(Integer cpf){
        return repository.findByCpf(cpf);
    }

    public ClienteEntity clienteByDataNascimento(LocalDate dataNascimento){
        return repository.findByDataNascimento(dataNascimento);
    }
}
