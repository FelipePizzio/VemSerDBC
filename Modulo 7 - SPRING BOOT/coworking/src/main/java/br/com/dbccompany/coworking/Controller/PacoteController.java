package br.com.dbccompany.coworking.Controller;

import br.com.dbccompany.coworking.Entity.PacoteEntity;
import br.com.dbccompany.coworking.Service.PacoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/pacote")
public class PacoteController {

    @Autowired
    PacoteService service;

    @GetMapping(value = "/todos")
    @ResponseBody
    public List<PacoteEntity> todosPacotes(){
        return service.todosPacotes();
    }

    @PostMapping(value = "/novo")
    @ResponseBody
    public PacoteEntity novoPacote(@RequestBody PacoteEntity pacote){
        return service.salvar(pacote);
    }

    @PutMapping(value = "/editar/{id}")
    @ResponseBody
    public PacoteEntity editarPacote(@PathVariable Integer id, @RequestBody PacoteEntity pacote){
        return service.editar(pacote, id);
    }
}
