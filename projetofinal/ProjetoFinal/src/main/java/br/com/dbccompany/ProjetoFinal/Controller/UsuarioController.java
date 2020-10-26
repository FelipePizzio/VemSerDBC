package br.com.dbccompany.ProjetoFinal.Controller;

import br.com.dbccompany.ProjetoFinal.Document.Usuario;
import br.com.dbccompany.ProjetoFinal.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping( value = "/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @PostMapping(value = "/salvar/novo")
    @ResponseBody
    public Usuario novoUsuario(@RequestBody Usuario usuario ){
        return service.salvar( usuario );
    }

    @PutMapping(value = "/editar/{id}")
    @ResponseBody
    public Usuario editarUsuario(@PathVariable String id, @RequestBody Usuario usuario) {
        return service.editar(usuario, id);
    }

    @DeleteMapping( value = "/deletar/{id}")
    @ResponseBody
    public Boolean deletarUsuario( @PathVariable String id ) {
        service.deletar( id );
        return true;
    }

    @GetMapping(value = "/buscar-todos")
    @ResponseBody
    public List<Usuario> todosUsuarios(){
        return service.todosUsuarios();
    }

    @GetMapping(value = "/buscar-por-id/{id}")
    @ResponseBody
    public Usuario buscarPorId(@PathVariable String id) {
        return service.usuarioEspecifico(id);
    }

    @GetMapping(value = "/buscar-por-nome/{nome}")
    @ResponseBody
    public List<Usuario> buscarPorNome(@PathVariable String nome){
        return service.buscarPorNome(nome);
    }

    @GetMapping(value = "/buscar-por-email/{email}")
    @ResponseBody
    public List<Usuario> buscarPorEmail(@PathVariable String email) {
        return service.buscarPorEmail(email);
    }

}
