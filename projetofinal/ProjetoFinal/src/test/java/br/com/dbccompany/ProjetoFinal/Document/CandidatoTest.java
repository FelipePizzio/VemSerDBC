package br.com.dbccompany.ProjetoFinal.Document;

import br.com.dbccompany.ProjetoFinal.Repository.CandidatoRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CandidatoTest {

    @Autowired
    CandidatoRepository repository;

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
            "Felipe",
            dadosPessoais,
            dadosEscolares,
            experiencias,
            "www.exemplo.com",
            "AE3"
    );

    @Test
    void getIdTest() {
        repository.save(candidato);
        Assertions.assertNotNull(candidato.getId());
    }

    @Test
    void setIdTest() {
        candidato.setId("1");
        Assertions.assertEquals("1", candidato.getId());
    }

    @Test
    void getNomeTest() {
        repository.save(candidato);
        Assertions.assertEquals("Felipe", candidato.getNome());
    }

    @Test
    void setNomeTest() {
        candidato.setNome("Felipe P");
        Assertions.assertEquals("Felipe P", candidato.getNome());
    }

    @Test
    void getDadosPessoaisTest() {
        repository.save(candidato);
        Assertions.assertEquals(dadosPessoais, candidato.getDadosPessoais());
    }

    @Test
    void setDadosPessoaisTest() {
        DadosPessoais dadosPessoais1 = new DadosPessoais(
                "03056249031",
                "23071992",
                "51999999999",
                endereco
        );
        candidato.setDadosPessoais(dadosPessoais1);
        Assertions.assertEquals(dadosPessoais1, candidato.getDadosPessoais());
    }

    @Test
    void getDadosEscolaresTest() {
        repository.save(candidato);
        Assertions.assertEquals(dadosEscolares, candidato.getDadosEscolares());
    }

    @Test
    void setDadosEscolaresTest() {
        DadosEscolares dadosEscolares1 = new DadosEscolares(
                "UFPel",
                "2022"
        );
        candidato.setDadosEscolares(dadosEscolares1);
        Assertions.assertEquals(dadosEscolares1, candidato.getDadosEscolares());
    }

    @Test
    void getExperenciasTest() {
        repository.save(candidato);
        Assertions.assertEquals(experiencias, candidato.getExperiencias());
    }

    @Test
    void setExperenciasTest() {
        Experiencias experiencias1 = new Experiencias(
                "DBC",
                "boss",
                "3 anos"
        );
        candidato.setExperiencias(experiencias1);
        Assertions.assertEquals(experiencias1, candidato.getExperiencias());
    }

    @Test
    void getLinkCurriculoTest() {
        repository.save(candidato);
        Assertions.assertEquals("www.exemplo.com", candidato.getLinkCurriculo());
    }

    @Test
    void setLinkCurriculoTest() {
        candidato.setLinkCurriculo("url");
        Assertions.assertEquals("url", candidato.getLinkCurriculo());
    }

    @Test
    void getCodigoVagaTest() {
        repository.save(candidato);
        Assertions.assertEquals("AE3", candidato.getCodigoVaga());
    }

    @Test
    void setCodigoVagaTest() {
        candidato.setCodigoVaga("EE3");
        Assertions.assertEquals("EE3", candidato.getCodigoVaga());
    }
}