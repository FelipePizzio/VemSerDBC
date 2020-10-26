package br.com.dbccompany.ProjetoFinal.Document;

import br.com.dbccompany.ProjetoFinal.Document.Vagas;
import br.com.dbccompany.ProjetoFinal.Repository.VagasRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class VagasTest {

    @Autowired
    VagasRepository repository;

    @Test
    public void getIdTest(){
        Vagas vaga = new Vagas();
        vaga.setTitulo("Dev");
        repository.save(vaga);
        Assertions.assertNotNull(vaga.getId());
    }

    @Test
    public void setIdTest(){
        Vagas vaga = new Vagas();
        vaga.setId("2FR45");
        repository.save(vaga);

        Assertions.assertNotNull(vaga.getId());
        Assertions.assertEquals("2FR45", vaga.getId());
    }

    @Test
    public void getTituloTest(){
        Vagas vaga1 = new Vagas();
        vaga1.setTitulo("Analista de Dados");

        Assertions.assertEquals("Analista de Dados", vaga1.getTitulo());
    }

    @Test
    public void setTituloTest(){
        Vagas vaga1 = new Vagas();
        vaga1.setTitulo("DEV");
        repository.save(vaga1);

        Assertions.assertEquals("DEV",vaga1.getTitulo());
    }

    @Test
    public void getDataAberturaTest(){
        Vagas vaga1 = new Vagas();
        vaga1.setDataabertura("2020-03-02 T00:00:00");
        repository.save(vaga1);

        Assertions.assertEquals("2020-03-02 T00:00:00", vaga1.getDataabertura());
    }

    @Test
    public void setDataAberturaTest(){
        Vagas vaga1 = new Vagas();
        vaga1.setDataabertura("2020-03-05 T10:00:00");
        repository.save(vaga1);

        Assertions.assertEquals("2020-03-05 T10:00:00", vaga1.getDataabertura());
    }

    @Test
    public void getCodigoVagaTest(){
        Vagas vaga1 = new Vagas();
        vaga1.setCodigovaga("5ff3");
        repository.save(vaga1);

        Assertions.assertEquals("5ff3", vaga1.getCodigovaga());
    }

    @Test
    public void setCodigoVagaTest(){
        Vagas vaga1 = new Vagas();
        vaga1.setCodigovaga("4ft5");
        repository.save(vaga1);

        Assertions.assertEquals("4ft5", vaga1.getCodigovaga());
    }

    @Test
    public void getUrlTest(){
        Vagas vaga1 = new Vagas();
        vaga1.setUrl("https://DBC.compleo.com.br/Visualizar/53272");
        repository.save(vaga1);

        Assertions.assertEquals("https://DBC.compleo.com.br/Visualizar/53272",vaga1.getUrl());
    }

    @Test
    public void setUrlTest(){
        Vagas vaga1 = new Vagas();
        vaga1.setUrl("https://DBC.compleo.com.br/Visualizar/53282");
        repository.save(vaga1);

        Assertions.assertEquals("https://DBC.compleo.com.br/Visualizar/53282",vaga1.getUrl());
    }

    @Test
    public void getCidadeTest(){
        Vagas vaga1 = new Vagas();
        vaga1.setCidade("Porto Alegre");
        repository.save(vaga1);

        Assertions.assertEquals("Porto Alegre", vaga1.getCidade());
    }

    @Test
    public void setCidadeTest(){
        Vagas vaga1 = new Vagas();
        vaga1.setCidade("Palhoça");
        repository.save(vaga1);

        Assertions.assertEquals("Palhoça", vaga1.getCidade());
    }


    @Test
    public void getEstadoTest(){
        Vagas vaga1 = new Vagas();
        vaga1.setEstado("RS");
        repository.save(vaga1);

        Assertions.assertEquals("RS", vaga1.getEstado());
    }

    @Test
    public void setEstadoTest(){
        Vagas vaga1 = new Vagas();
        vaga1.setEstado("SC");
        repository.save(vaga1);

        Assertions.assertEquals("SC", vaga1.getEstado());
    }

    @Test
    public void getCodigoFilialTest(){
        Vagas vaga1 = new Vagas();
        vaga1.setCodigofilial(5555);
        repository.save(vaga1);

        Assertions.assertEquals(5555,vaga1.getCodigofilial());
    }

    @Test
    public void setCodigoFilialTest(){
        Vagas vaga1 = new Vagas();
        vaga1.setCodigofilial(2222);
        repository.save(vaga1);

        Assertions.assertEquals(2222,vaga1.getCodigofilial());
    }

    @Test
    public void getNomeFilialTest(){
        Vagas vaga1 = new Vagas();
        vaga1.setNomefilial("Palhoça");
        repository.save(vaga1);

        Assertions.assertEquals("Palhoça",vaga1.getNomefilial());
    }

    @Test
    public void setNomeFilialTest(){
        Vagas vaga1 = new Vagas();
        vaga1.setNomefilial("POA");
        repository.save(vaga1);

        Assertions.assertEquals("POA",vaga1.getNomefilial());
    }

    @Test
    public void getDescricaoVagasTest(){
        Vagas vaga1 = new Vagas();
        vaga1.setDescricaovaga("Scrum,java,CSS,HTML");
        repository.save(vaga1);

        Assertions.assertEquals("Scrum,java,CSS,HTML",vaga1.getDescricaovaga());
    }

    @Test
    public void setDescricaoVagasTest(){
        Vagas vaga1 = new Vagas();
        vaga1.setDescricaovaga("JS,NODE,REACT");
        repository.save(vaga1);

        Assertions.assertEquals("JS,NODE,REACT",vaga1.getDescricaovaga());
    }


}
