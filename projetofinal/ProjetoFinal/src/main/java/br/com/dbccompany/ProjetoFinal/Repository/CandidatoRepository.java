package br.com.dbccompany.ProjetoFinal.Repository;

import br.com.dbccompany.ProjetoFinal.Document.Candidato;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CandidatoRepository extends MongoRepository<Candidato, String> {

    List<Candidato> findByNome(String nome);
    List<Candidato> findByCodigoVaga(String codigoVaga);
    List<Candidato> findAll();
}
