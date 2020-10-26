package br.com.dbccompany.bancodigital.Controller;

import br.com.dbccompany.bancodigital.Entity.Estados;
import br.com.dbccompany.bancodigital.Service.EstadosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping( "/api/estado" )
public class EstadosController {

    @Autowired
    EstadosService service;

    @GetMapping( value = "/todos")
    @ResponseBody
    public List<Estados> todosEstados(){
        return service.todosEstados();
    }

    @PostMapping( value = "/novo")
    @ResponseBody
    public Estados novoEstado( @RequestBody Estados estado ){
        return service.salvar( estado );
    }

    @PutMapping( value = "/editar/{id}" )
    @ResponseBody
    public Estados editarEstado( @PathVariable Integer id, @RequestBody Estados estado ){
        return service.editar( estado, id );
    }
}
