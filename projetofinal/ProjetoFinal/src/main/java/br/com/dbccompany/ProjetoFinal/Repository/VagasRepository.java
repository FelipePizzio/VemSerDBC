package br.com.dbccompany.ProjetoFinal.Repository;

import br.com.dbccompany.ProjetoFinal.Document.Vagas;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VagasRepository extends MongoRepository<Vagas, String> {

    List<Vagas> findByTitulo(String titulo);
    List<Vagas> findByDataabertura(String dataAbertura);
    List<Vagas> findByCodigovaga(String codigoVaga);
    Vagas findByUrl(String url);
    List<Vagas> findByCidade(String cidade);
    List<Vagas> findByEstado(String estado);
    List<Vagas> findByCodigofilial(Integer codigoFilial);
    List<Vagas> findByNomefilial(String nomeFilial);
    Vagas findByDescricaovaga(String descricaoVaga);
    List<Vagas> findAll();


}
