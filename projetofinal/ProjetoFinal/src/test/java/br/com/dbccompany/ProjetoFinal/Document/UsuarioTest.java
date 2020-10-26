package br.com.dbccompany.ProjetoFinal.Document;

import br.com.dbccompany.ProjetoFinal.Repository.UsuarioRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UsuarioTest {

    @Autowired
    UsuarioRepository repository;

    Usuario usuario = new Usuario(
            "Guilherme Dall Agnol",
            "Guilherme.dallagnol@dbccompany.com.br",
            "123456"
    );


    @Test
    void getIdTest() {
        repository.save(usuario);
        Assertions.assertNotNull(usuario.getId());
    }

    @Test
    void setIdTest() {
        usuario.setId("1");
        Assertions.assertEquals("1", usuario.getId());
    }

    @Test
    void getNomeTest() {
        repository.save(usuario);
        Assertions.assertEquals("Guilherme Dall Agnol", usuario.getNome());
    }

    @Test
    void setNomeTest() {
        Usuario usuario2 = new Usuario();
        usuario2.setNome("Ronaldo Lopes");
        repository.save(usuario2);
        Assertions.assertEquals("Ronaldo Lopes", usuario2.getNome());
    }

    @Test
    void getEmailTest() {
        repository.save(usuario);
        Assertions.assertEquals("Guilherme.dallagnol@dbccompany.com.br", usuario.getEmail());
    }

    @Test
    void setEmailTest() {
        Usuario usuario2 = new Usuario();
        usuario2.setEmail("ronaldo.lopes@dbccompany.com.br");
        repository.save(usuario2);
        Assertions.assertEquals("ronaldo.lopes@dbccompany.com.br", usuario2.getEmail());
    }

    @Test
    void getSenhaTest() {
        repository.save(usuario);
        Assertions.assertEquals("123456", usuario.getSenha());
    }

    @Test
    void setSenhaTest() {
        Usuario usuario2 = new Usuario();
        usuario2.setSenha("102030");
        repository.save(usuario2);
        Assertions.assertEquals("102030", usuario2.getSenha());
    }
}