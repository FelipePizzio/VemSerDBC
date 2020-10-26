package br.com.dbccompany.ProjetoFinal.Repository;

import br.com.dbccompany.ProjetoFinal.Document.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends MongoRepository<Usuario, String> {
    List<Usuario> findByNome (String nome);
    List<Usuario> findByEmail (String email);
    List<Usuario> findAll();
}
