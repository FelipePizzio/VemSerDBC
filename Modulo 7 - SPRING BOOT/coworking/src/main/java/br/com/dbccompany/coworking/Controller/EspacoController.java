package br.com.dbccompany.coworking.Controller;

import br.com.dbccompany.coworking.Entity.EspacoEntity;
import br.com.dbccompany.coworking.Service.EspacoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/espaço")
public class EspacoController {

    @Autowired
    EspacoService service;

    @GetMapping(value = "/todos")
    @ResponseBody
    public List<EspacoEntity> todosEspacos(){
        return service.todosEspacos();
    }

    @PostMapping(value = "/novo")
    @ResponseBody
    public EspacoEntity novoEspaco(@RequestBody EspacoEntity espaco){
        return service.salvar(espaco);
    }

    @PutMapping(value = "/editar/{id}")
    @ResponseBody
    public EspacoEntity editarEspaco(@PathVariable Integer id, @RequestBody EspacoEntity espaco){
        return service.editar(espaco, id);
    }
}
