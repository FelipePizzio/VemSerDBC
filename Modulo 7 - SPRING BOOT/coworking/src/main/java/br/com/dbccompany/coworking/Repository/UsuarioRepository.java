package br.com.dbccompany.coworking.Repository;

import br.com.dbccompany.coworking.Entity.UsuarioEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends CrudRepository<UsuarioEntity, Integer> {

    UsuarioEntity findByNome(String nome);
    UsuarioEntity findByEmail(String email);
    UsuarioEntity findByLogin(String login);
    UsuarioEntity findBySenha(String senha);
    List<UsuarioEntity> findAll();
}
