package br.com.dbccompany.ProjetoFinal.Repository;

import br.com.dbccompany.ProjetoFinal.Document.Usuario;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;

@SpringBootTest
class UsuarioRepositoryTest {

    @Autowired
    UsuarioRepository repository;

    @Autowired
    MongoTemplate mongoTemplate;

    @BeforeEach
    public void setup() throws Exception {
        mongoTemplate.dropCollection(Usuario.class);
    }

    @AfterEach
    public void tearDown() throws Exception {
        mongoTemplate.dropCollection(Usuario.class);
    }

    Usuario usuario = new Usuario(
            "Joseph Affeldt",
            "joseph.affeldt@dbccompany.com.br",
            "123456789"
    );

    Usuario usuario2 = new Usuario(
            "Ronaldo Lopes",
            "ronaldo.lopes@dbccompany.com.br",
            "987654321"
    );

    @Test
    void findByNomeTest() {
        repository.save(usuario);
        repository.save(usuario2);
        Assertions.assertNotNull(repository.findByNome("Ronaldo Lopes"));
    }

    @Test
    void findByEmailTest() {
        repository.save(usuario);
        repository.save(usuario2);
        Assertions.assertNotNull(repository.findByEmail("joseph.affeldt@dbccompany.com.br"));
    }

    @Test
    void findAllTest() {
        repository.save(usuario);
        repository.save(usuario2);
        Assertions.assertNotNull(repository.findAll());
    }

    @Test
    void deletarUsuarioTest() {
        repository.save(usuario);
        repository.save(usuario2);
        repository.deleteById(usuario2.getId());
        Assertions.assertEquals(usuario.getNome(), repository.findByNome("Joseph Affeldt").get(0).getNome());
    }
}