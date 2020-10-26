package br.com.dbccompany.ProjetoFinal.Repository;

import br.com.dbccompany.ProjetoFinal.Document.Vagas;
import br.com.dbccompany.ProjetoFinal.Repository.VagasRepository;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;


@SpringBootTest
public class VagasRepositoryTest {

    @Autowired
    private VagasRepository repository;

    @Autowired
    MongoTemplate mongoTemplate;

    @BeforeEach
    public void setup() throws Exception {
        mongoTemplate.dropCollection(Vagas.class);
    }
    @AfterEach
    public void tearDown() throws Exception {
        mongoTemplate.dropCollection(Vagas.class);
    }


    @Test
    public void salvarVagasTest(){
        Vagas vaga1 = new Vagas();
        vaga1.setTitulo("Analista de dados");
        vaga1.setEstado("RS");
        vaga1.setCidade("Poa");
        repository.save(vaga1);

        Assertions.assertNotNull(vaga1.getTitulo());
        Assertions.assertNotNull(vaga1.getEstado());
        Assertions.assertNotNull(vaga1.getCidade());
        Assertions.assertEquals("Analista de dados", vaga1.getTitulo());
        Assertions.assertEquals("RS",vaga1.getEstado());
        Assertions.assertEquals("Poa",vaga1.getCidade());
    }

    @Test
    public void editarVagasTest(){
        Vagas vaga1 = new Vagas();
        vaga1.setTitulo("Analista de dados");
        repository.save(vaga1);
        vaga1.setTitulo("Desenvolvedor");
        repository.save(vaga1);

        Assertions.assertNotNull(vaga1.getTitulo());
        Assertions.assertEquals("Desenvolvedor",vaga1.getTitulo());
    }

    @Test
    public void findByTituloTest(){
        Vagas vagas1 = new Vagas();
        Vagas vagas2 = new Vagas();
        vagas1.setTitulo("Dev");
        vagas2.setTitulo("Dev-Front");
        repository.save(vagas1);
        repository.save(vagas2);

        Assertions.assertNotNull(vagas1.getTitulo());
        Assertions.assertNotNull(vagas2.getTitulo());
        Assertions.assertEquals("Dev", vagas1.getTitulo());
        Assertions.assertEquals("Dev-Front",vagas2.getTitulo());
        Assertions.assertEquals(vagas1.getTitulo(),repository.findByTitulo("Dev").get(0).getTitulo());
        Assertions.assertEquals(vagas2.getTitulo(),repository.findByTitulo("Dev-Front").get(0).getTitulo());
    }

    @Test
    public void findByDataAberturaTest(){
        Vagas vagas1 = new Vagas();
        Vagas vagas2 = new Vagas();
        vagas1.setDataabertura("2020-03-02T 00:00:00");
        vagas2.setDataabertura("2020-05-02T 22:00:00");
        repository.save(vagas1);
        repository.save(vagas2);

        Assertions.assertNotNull(vagas1.getDataabertura());
        Assertions.assertNotNull(vagas2.getDataabertura());
        Assertions.assertEquals("2020-03-02T 00:00:00", vagas1.getDataabertura());
        Assertions.assertEquals("2020-05-02T 22:00:00",vagas2.getDataabertura());
        Assertions.assertEquals(vagas1.getDataabertura(),repository.findByDataabertura("2020-03-02T 00:00:00").get(0).getDataabertura());
        Assertions.assertEquals(vagas2.getDataabertura(),repository.findByDataabertura("2020-05-02T 22:00:00").get(0).getDataabertura());
    }

    @Test
    public void findByCodigovagaTest(){
        Vagas vagas1 = new Vagas();
        Vagas vagas2 = new Vagas();
        vagas1.setCodigovaga("53272");
        vagas2.setCodigovaga("GET53273");
        repository.save(vagas1);
        repository.save(vagas2);

        Assertions.assertNotNull(vagas1.getCodigovaga());
        Assertions.assertNotNull(vagas2.getCodigovaga());
        Assertions.assertEquals("53272", vagas1.getCodigovaga());
        Assertions.assertEquals("GET53273",vagas2.getCodigovaga());
        Assertions.assertEquals(vagas1.getCodigovaga(),repository.findByCodigovaga("53272").get(0).getCodigovaga());
        Assertions.assertEquals(vagas2.getCodigovaga(),repository.findByCodigovaga("GET53273").get(0).getCodigovaga());
    }

    @Test
    public void findByUrlTest(){
        Vagas vagas1 = new Vagas();
        Vagas vagas2 = new Vagas();
        vagas1.setUrl("https://DBC.compleo.com.br/Visualizar/53273");
        vagas2.setUrl("https://DBC.compleo.com.br/Visualizar/53103");
        repository.save(vagas1);
        repository.save(vagas2);

        Assertions.assertNotNull(vagas1.getUrl());
        Assertions.assertNotNull(vagas2.getUrl());
        Assertions.assertEquals("https://DBC.compleo.com.br/Visualizar/53273", vagas1.getUrl());
        Assertions.assertEquals("https://DBC.compleo.com.br/Visualizar/53103", vagas2.getUrl());

    }


    @Test
    public void findByCidadeTest(){
        Vagas vagas1 = new Vagas();
        Vagas vagas2 = new Vagas();
        vagas1.setCidade("Canoas");
        vagas2.setCidade("Poa");
        repository.save(vagas1);
        repository.save(vagas2);

        Assertions.assertNotNull(vagas1.getCidade());
        Assertions.assertNotNull(vagas2.getCidade());
        Assertions.assertEquals("Canoas", vagas1.getCidade());
        Assertions.assertEquals("Poa",vagas2.getCidade());
        Assertions.assertEquals(vagas1.getCidade(),repository.findByCidade("Canoas").get(0).getCidade());
        Assertions.assertEquals(vagas2.getCidade(),repository.findByCidade("Poa").get(0).getCidade());
    }

    @Test
    public void findByEstadoTest(){
        Vagas vagas1 = new Vagas();
        Vagas vagas2 = new Vagas();
        vagas1.setEstado("RS");
        vagas2.setEstado("SC");
        repository.save(vagas1);
        repository.save(vagas2);

        Assertions.assertNotNull(vagas1.getEstado());
        Assertions.assertNotNull(vagas2.getEstado());
        Assertions.assertEquals("RS", vagas1.getEstado());
        Assertions.assertEquals("SC",vagas2.getEstado());
        Assertions.assertEquals(vagas1.getEstado(),repository.findByEstado("RS").get(0).getEstado());
        Assertions.assertEquals(vagas2.getEstado(),repository.findByEstado("SC").get(0).getEstado());
    }

    @Test
    public void findByCodigoFilialTest(){
        Vagas vagas1 = new Vagas();
        Vagas vagas2 = new Vagas();
        vagas1.setCodigofilial(5555);
        vagas2.setCodigofilial(4444);
        repository.save(vagas1);
        repository.save(vagas2);

        Assertions.assertNotNull(vagas1.getCodigofilial());
        Assertions.assertNotNull(vagas2.getCodigofilial());
        Assertions.assertEquals(5555, vagas1.getCodigofilial());
        Assertions.assertEquals(4444,vagas2.getCodigofilial());
        Assertions.assertEquals(vagas1.getCodigofilial(),repository.findByCodigofilial(5555).get(0).getCodigofilial());
        Assertions.assertEquals(vagas2.getCodigofilial(),repository.findByCodigofilial(4444).get(0).getCodigofilial());
    }

    @Test
    public void findByNomeFilialTest(){
        Vagas vagas1 = new Vagas();
        Vagas vagas2 = new Vagas();
        vagas1.setNomefilial("Sede POA");
        vagas2.setNomefilial("Sede Palhoça");
        repository.save(vagas1);
        repository.save(vagas2);

        Assertions.assertNotNull(vagas1.getNomefilial());
        Assertions.assertNotNull(vagas2.getNomefilial());
        Assertions.assertEquals("Sede POA", vagas1.getNomefilial());
        Assertions.assertEquals("Sede Palhoça",vagas2.getNomefilial());
        Assertions.assertEquals(vagas1.getNomefilial(),repository.findByNomefilial("Sede POA").get(0).getNomefilial());
        Assertions.assertEquals(vagas2.getNomefilial(),repository.findByNomefilial("Sede Palhoça").get(0).getNomefilial());
    }

   @Test
    public void findAllTest(){
       Vagas vagas1 = new Vagas("Analista de dados",
                                "2020-03-02T 00:00:00",
                                "53272","","POA","RS",5555,"Sede Poa",
                                "Python,MapReduce,PowerBI");
       Vagas vagas2 = new Vagas("Dev",
                                "2020-03-02T 10:00:00",
                                "44272","","Palhoça","SC",4444,"Sede Palhoça",
                                "Dev-Front,Dev-Back");

       repository.save(vagas1);
       repository.save(vagas2);
       Assertions.assertNotNull(repository.findAll());
   }



}
