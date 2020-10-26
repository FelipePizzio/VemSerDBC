package br.com.dbccompany.coworking.Controller;

import br.com.dbccompany.coworking.Entity.ContatoEntity;
import br.com.dbccompany.coworking.Entity.TipoContatoEntity;
import br.com.dbccompany.coworking.Service.ContatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/contato")
public class ContatoController {

    @Autowired
    ContatoService service;

    @GetMapping(value = "{id}")
    @ResponseBody
    public ContatoEntity contatoEspecifico(@PathVariable Integer id){
        return service.contatoEspecifico(id);
    }

    @GetMapping(value = "{tipoContato}")
    @ResponseBody
    public ContatoEntity contatoByTipoContato(@PathVariable TipoContatoEntity tipoContato){
        return service.contatoByTipoContato(tipoContato);
    }

    @GetMapping(value = "{valor}")
    @ResponseBody
    public ContatoEntity contatoByValor(@PathVariable String valor){
        return service.contatoByValor(valor);
    }

    @GetMapping(value = "/todos")
    @ResponseBody
    public List<ContatoEntity> todosContatos(){
        return service.todosContatos();
    }

    @PostMapping(value = "/novo")
    @ResponseBody
    public ContatoEntity novoContato(@RequestBody ContatoEntity contato){
        return service.salvar(contato);
    }

    @PutMapping(value = "/editar/{id}")
    @ResponseBody
    public ContatoEntity editarContato(@PathVariable Integer id, @RequestBody ContatoEntity contato){
        return service.editar(contato, id);
    }
}
