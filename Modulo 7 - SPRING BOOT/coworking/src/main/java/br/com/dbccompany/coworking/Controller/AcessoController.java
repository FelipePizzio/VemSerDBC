package br.com.dbccompany.coworking.Controller;

import br.com.dbccompany.coworking.Entity.AcessoEntity;
import br.com.dbccompany.coworking.Service.AcessoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/api/acesso")
public class AcessoController {

    @Autowired
    private AcessoService service;

    @GetMapping(value = "/{id}")
    @ResponseBody
    public AcessoEntity acessoEspecifico(@PathVariable Integer id){
        return service.acessoEspecifico(id);
    }

    @GetMapping(value = "/{data}")
    @ResponseBody
    public AcessoEntity acessoByData(@PathVariable LocalDate data){
        return service.acessoByData(data);
    }

    @GetMapping(value = "/todos")
    @ResponseBody
    public List<AcessoEntity> todosAcessos(){
        return service.todosAcessos();
    }

    @PostMapping(value = "/novo")
    @ResponseBody
    public AcessoEntity novoAcesso(@RequestBody AcessoEntity acesso){
        return service.salvar(acesso);
    }

    @PutMapping(value = "/editar/{id}")
    @ResponseBody
    public AcessoEntity editarAcesso(@PathVariable Integer id, @RequestBody AcessoEntity acesso){
        return service.editar(acesso, id);
    }
}