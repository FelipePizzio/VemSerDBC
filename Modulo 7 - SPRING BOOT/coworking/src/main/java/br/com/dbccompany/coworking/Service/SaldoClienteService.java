package br.com.dbccompany.coworking.Service;

import br.com.dbccompany.coworking.Entity.SaldoCliente;
import br.com.dbccompany.coworking.Entity.SaldoClienteId;
import br.com.dbccompany.coworking.Repository.SaldoClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class SaldoClienteService {

    @Autowired
    private SaldoClienteRepository repository;

    @Transactional(rollbackFor = Exception.class)
    public SaldoCliente salvar(SaldoCliente saldoCliente){
        return repository.save(saldoCliente);
    }

    @Transactional(rollbackFor = Exception.class)
    public SaldoCliente editar(SaldoCliente saldoCliente, SaldoClienteId id){
        saldoCliente.setId(id);
        return repository.save(saldoCliente);
    }

    public List<SaldoCliente> todosSaldoCliente(){
        return repository.findAll();
    }

    public SaldoCliente saldoClienteEspecifico(Integer id){
        Optional<SaldoCliente> saldoCliente = repository.findById(id);
        return saldoCliente.get();
    }
}
