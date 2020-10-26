package br.com.dbccompany.coworking.Service;

import br.com.dbccompany.coworking.Entity.PagamentoEntity;
import br.com.dbccompany.coworking.Repository.PagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PagamentoService {

    @Autowired
    private PagamentoRepository repository;

    @Transactional(rollbackFor = Exception.class)
    public PagamentoEntity salvar(PagamentoEntity pagamento){
        return repository.save(pagamento);
    }

    @Transactional(rollbackFor = Exception.class)
    public PagamentoEntity editar(PagamentoEntity pagamento, Integer id){
        pagamento.setId(id);
        return repository.save(pagamento);
    }

    public List<PagamentoEntity> todosPagamentos(){
        return repository.findAll();
    }

    public PagamentoEntity pagamentoEspecifico(Integer id){
        Optional<PagamentoEntity> pagamento = repository.findById(id);
        return pagamento.get();
    }
}
