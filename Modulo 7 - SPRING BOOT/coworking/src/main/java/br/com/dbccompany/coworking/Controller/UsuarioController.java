package br.com.dbccompany.coworking.Controller;

import br.com.dbccompany.coworking.Entity.UsuarioEntity;
import br.com.dbccompany.coworking.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/usuario")
public class UsuarioController {

    @Autowired
    UsuarioService service;

    @GetMapping(value = "/{id}")
    @ResponseBody
    public UsuarioEntity usuarioEspecifico(@PathVariable Integer id){
        return service.usuarioEspecifico(id);
    }

    @GetMapping(value = "/{nome}")
    @ResponseBody
    public UsuarioEntity usuarioByNome(@PathVariable String nome){
        return service.usuarioByNome(nome);
    }

    @GetMapping(value = "/{email}")
    @ResponseBody
    public UsuarioEntity usuarioByEmail(@PathVariable String email){
        return service.usuarioByEmail(email);
    }

    @GetMapping(value = "/{login}")
    @ResponseBody
    public UsuarioEntity usuarioByLogin(@PathVariable String login){
        return service.usuarioByLogin(login);
    }

    @GetMapping(value = "/{senha}")
    @ResponseBody
    public UsuarioEntity usuarioBySenha(@PathVariable String senha){
        return service.usuarioBySenha(senha);
    }

    @GetMapping(value = "/todos")
    @ResponseBody
    public List<UsuarioEntity> todosUsuarios(){
        return service.todosUsuarios();
    }

    @PostMapping(value = "/nova")
    @ResponseBody
    public UsuarioEntity novoUsuario(@RequestBody UsuarioEntity usuario){
        return service.salvar(usuario);
    }

    @PutMapping(value = "/editar/{id}")
    @ResponseBody
    public UsuarioEntity editarUsuario(@PathVariable Integer id, @RequestBody UsuarioEntity usuario){
        return service.editar(usuario, id);
    }

    @RequestMapping(value = "/deletar/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public Boolean deletarUsuario(@PathVariable Integer id){
        service.deletar(id);
        return true;
    }
}
