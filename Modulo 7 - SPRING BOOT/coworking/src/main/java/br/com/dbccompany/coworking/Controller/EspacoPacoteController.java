package br.com.dbccompany.coworking.Controller;

import br.com.dbccompany.coworking.Entity.EspacoPacote;
import br.com.dbccompany.coworking.Service.EspacoPacoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/espaço_pacote")
public class EspacoPacoteController {

    @Autowired
    EspacoPacoteService service;

    @GetMapping(value = "/todos")
    @ResponseBody
    public List<EspacoPacote> todosEspacosPacotes(){
        return service.todosEspacosPacotes();
    }

    @PostMapping(value = "/novo")
    @ResponseBody
    public EspacoPacote novoEspacoPacote(@RequestBody EspacoPacote espacoPacote){
        return service.salvar(espacoPacote);
    }

    @PutMapping(value = "/editar/{id}")
    @ResponseBody
    public EspacoPacote editarEspacoPacote(@PathVariable Integer id, @RequestBody EspacoPacote espacoPacote){
        return service.editar(espacoPacote, id);
    }
}
