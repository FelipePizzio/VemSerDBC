package br.com.dbccompany.coworking.Service;

import br.com.dbccompany.coworking.Entity.ContratacaoEntity;
import br.com.dbccompany.coworking.Repository.ContratacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ContratacaoService {

    @Autowired
    private ContratacaoRepository repository;

    @Transactional(rollbackFor = Exception.class)
    public ContratacaoEntity salvar(ContratacaoEntity contratacao){
        return repository.save(contratacao);
    }

    @Transactional(rollbackFor = Exception.class)
    public ContratacaoEntity editar(ContratacaoEntity contratacao, Integer id){
        contratacao.setId(id);
        return repository.save(contratacao);
    }

    public List<ContratacaoEntity> todasContratacoes(){
        return repository.findAll();
    }

    public ContratacaoEntity contracaoEspecifica(Integer id){
        Optional<ContratacaoEntity> contratacao = repository.findById(id);
        return contratacao.get();
    }
}
