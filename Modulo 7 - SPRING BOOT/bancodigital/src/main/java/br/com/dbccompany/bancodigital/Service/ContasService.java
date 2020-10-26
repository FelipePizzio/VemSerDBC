package br.com.dbccompany.bancodigital.Service;

import br.com.dbccompany.bancodigital.Entity.Contas;
import br.com.dbccompany.bancodigital.Repository.ContasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ContasService {

    @Autowired
    private ContasRepository repository;

    @Transactional( rollbackFor = Exception.class )
    public Contas salvar( Contas conta ){
        return repository.save( conta );
    }

    @Transactional( rollbackFor = Exception.class )
    public Contas editar( Contas conta, Integer id ){
        conta.setId( id );
        return repository.save( conta );
    }

    public List<Contas> todasContas(){
        return repository.findAll();
    }

    public Contas contaEspecifica( Integer id ){
        Optional<Contas> conta = repository.findById( id );
        return conta.get();
    }
}
