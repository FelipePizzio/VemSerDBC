package br.com.dbccompany.ProjetoFinal.Service;

import br.com.dbccompany.ProjetoFinal.Document.Candidato;
import br.com.dbccompany.ProjetoFinal.Repository.CandidatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CandidatoService {

    @Autowired
    private CandidatoRepository repository;

    @Transactional(rollbackFor = Exception.class)
    public Candidato salvar(Candidato candidato){
        return repository.save(candidato);
    }

    @Transactional(rollbackFor = Exception.class)
    public Candidato editar(Candidato candidato, String id){
        candidato.setId(id);
        return repository.save(candidato);
    }

    @Transactional(rollbackFor = Exception.class)
    public void deletar(String id){
        repository.deleteById(id);
    }

    public List<Candidato> todosCandidatos(){
        return repository.findAll();
    }

    public Candidato candidatoEspecifico(String id){
        Optional<Candidato> candidato = repository.findById(id);
        return candidato.get();
    }

    public List<Candidato> buscarPorNome(String nome){
        return repository.findByNome(nome);
    }

    public List<Candidato> buscarPorCodigoVaga(String codigoVaga){
        return repository.findByCodigoVaga(codigoVaga);
    }
}
