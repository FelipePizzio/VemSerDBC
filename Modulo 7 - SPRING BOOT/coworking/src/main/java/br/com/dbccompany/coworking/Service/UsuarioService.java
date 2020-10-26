package br.com.dbccompany.coworking.Service;

import br.com.dbccompany.coworking.Entity.UsuarioEntity;
import br.com.dbccompany.coworking.Repository.UsuarioRepository;
import br.com.dbccompany.coworking.Security.Criptografia;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository repository;

    @Transactional(rollbackFor = Exception.class)
    public UsuarioEntity salvar(UsuarioEntity usuario){
        String senha = usuario.getSenha();
        if((StringUtils.isAlphanumeric(senha)) && senha.length() >= 6){
            usuario.setSenha(Criptografia.cripto(senha));
            return repository.save(usuario);
        }
        else{
            throw new RuntimeException("Obrigátorio senha de 6 digitos alfanúmericos");
        }
    }

    @Transactional(rollbackFor = Exception.class)
    public UsuarioEntity editar(UsuarioEntity usuario, Integer id){
        usuario.setId(id);
        return repository.save(usuario);
    }

    @Transactional(rollbackFor = Exception.class)
    public void deletar(Integer id){
        repository.deleteById(id);
    }

    public List<UsuarioEntity> todosUsuarios(){
        return repository.findAll();
    }

    public UsuarioEntity usuarioEspecifico(Integer id){
        Optional<UsuarioEntity> usuario = repository.findById(id);
        return usuario.get();
    }

    public UsuarioEntity usuarioByNome(String nome){
        return repository.findByNome(nome);
    }

    public UsuarioEntity usuarioByEmail(String email){
        return repository.findByEmail(email);
    }

    public UsuarioEntity usuarioByLogin(String login){
        return repository.findByLogin(login);
    }

    public UsuarioEntity usuarioBySenha(String senha){
        return repository.findBySenha(senha);
    }
}
