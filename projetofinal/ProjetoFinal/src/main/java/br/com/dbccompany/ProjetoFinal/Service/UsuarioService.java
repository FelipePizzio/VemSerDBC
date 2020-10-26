package br.com.dbccompany.ProjetoFinal.Service;

import br.com.dbccompany.ProjetoFinal.Document.Usuario;
import br.com.dbccompany.ProjetoFinal.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    @Transactional(rollbackFor = Exception.class)
    public Usuario salvar(Usuario usuario ) {
        return repository.save( usuario );
    }

    @Transactional(rollbackFor = Exception.class)
    public Usuario editar(Usuario usuario, String id){
        usuario.setId(id);
        return repository.save(usuario);
    }

    @Transactional( rollbackFor = Exception.class)
    public void deletar(String id) {
        repository.deleteById( id );
    }

    public List<Usuario> todosUsuarios(){
        return repository.findAll();
    }

    public Usuario usuarioEspecifico(String id){
        Optional<Usuario> usuario = repository.findById(id);
        return usuario.get();
    }

    public List<Usuario> buscarPorNome(String nome){
        return repository.findByNome(nome);
    }

    public List<Usuario> buscarPorEmail(String email){
        return repository.findByEmail(email);
    }

}
