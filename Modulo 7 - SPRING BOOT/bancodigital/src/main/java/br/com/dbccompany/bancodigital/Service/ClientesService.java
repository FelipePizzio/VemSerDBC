package br.com.dbccompany.bancodigital.Service;

import br.com.dbccompany.bancodigital.Entity.Clientes;
import br.com.dbccompany.bancodigital.Repository.ClientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ClientesService {

    @Autowired
    private ClientesRepository repository;

    @Transactional( rollbackFor = Exception.class)
    public Clientes salvar( Clientes cliente ){
        return repository.save( cliente );
    }

    @Transactional( rollbackFor = Exception.class)
    public Clientes editar( Clientes cliente, Integer id ){
        cliente.setId( id );
        return repository.save( cliente );
    }

    public List<Clientes> todosClientes(){
        return repository.findAll();
    }

    public Clientes clienteEspecifico( Integer id ){
        Optional<Clientes> cliente = repository.findById( id );
        return cliente.get();
    }
}
