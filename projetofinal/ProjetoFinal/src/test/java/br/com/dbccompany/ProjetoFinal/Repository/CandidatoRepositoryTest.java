package br.com.dbccompany.ProjetoFinal.Repository;

import br.com.dbccompany.ProjetoFinal.Document.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;

@SpringBootTest
class CandidatoRepositoryTest {

    @Autowired
    CandidatoRepository repository;
    @Autowired
    MongoTemplate mongoTemplate;

    @BeforeEach
    public void setup() throws Exception {
        mongoTemplate.dropCollection(Candidato.class);
    }

    @AfterEach
    public void tearDown() throws Exception {
        mongoTemplate.dropCollection(Candidato.class);
    }
    
    Endereco endereco = new Endereco(
            "RS",
            "Porto Alegre",
            "Medianeira",
            "Gastão Mazeron",
            75,
            502
    );
    DadosPessoais dadosPessoais = new DadosPessoais(
            "03056249031",
            "23071992",
            "53991530053",
            endereco
    );
    DadosEscolares dadosEscolares = new DadosEscolares(
            "IFRS",
            "2022"
    );
    Experiencias experiencias = new Experiencias(
            "teste",
            "boss",
            "3 anos"
    );
    Candidato candidato = new Candidato(
            "Felipe P",
            dadosPessoais,
            dadosEscolares,
            experiencias,
            "www.exemplo.com",
            "AE3"
    );

    Endereco endereco1 = new Endereco(
            "RS",
            "Porto Alegre",
            "Menino Deus",
            "Jóse de Alencar",
            75,
            null
    );
    DadosPessoais dadosPessoais1 = new DadosPessoais(
            "03056249031",
            "23071992",
            "53991530053",
            endereco1
    );
    DadosEscolares dadosEscolares1 = new DadosEscolares(
            "IFRS",
            "2022"
    );
    Experiencias experiencias1 = new Experiencias(
            "teste",
            "boss",
            "3 anos"
    );
    Candidato candidato1 = new Candidato(
            "Felipe T",
            dadosPessoais1,
            dadosEscolares1,
            experiencias1,
            "www.exemplo2.com",
            "AE6"
    );

    @Test
    void salvarCandidatoTest(){
        repository.save(candidato1);
        Assertions.assertEquals(candidato1.getNome(), repository.findByNome("Felipe T").get(0).getNome());
    }

    @Test
    void deletarCandidatoTest(){
        repository.save(candidato);
        repository.save(candidato1);
        repository.delete(candidato);
        Assertions.assertEquals(candidato1.getNome(), repository.findByNome("Felipe T").get(0).getNome());
    }

    @Test
    void editarCandidatoTest(){
        repository.save(candidato);
        candidato.setCodigoVaga("");
        Assertions.assertEquals("", candidato.getCodigoVaga());
    }

    @Test
    void findByNomeTest() {
        repository.save(candidato);
        repository.save(candidato1);
        Assertions.assertEquals(candidato.getNome(), repository.findByNome("Felipe P").get(0).getNome());
        Assertions.assertNotNull(repository.findByNome("Felipe P"));
    }

    @Test
    void findByCodigoVagaTest() {
        repository.save(candidato);
        repository.save(candidato1);
        Assertions.assertNotNull(repository.findByCodigoVaga("AE6"));
    }

    @Test
    void findAllTest() {
        repository.save(candidato);
        repository.save(candidato1);
        Assertions.assertNotNull(repository.findAll());
    }
}