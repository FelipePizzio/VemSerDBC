package br.com.dbccompany.bancodigital.Controller;

import br.com.dbccompany.bancodigital.Entity.Paises;
import br.com.dbccompany.bancodigital.Service.PaisesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping( "/api/pais" )
public class PaisesController {

    @Autowired
    PaisesService service;

    @GetMapping( value = "/todos")
    @ResponseBody
    public List<Paises> todosPaises(){
        return service.todosPaises();
    }

    @PostMapping( value = "/novo")
    @ResponseBody
    public Paises novoPais( @RequestBody Paises pais ){
        return service.salvar( pais );
    }

    @PutMapping( value = "/editar/{id}" )
    @ResponseBody
    public Paises editarPais( @PathVariable Integer id, @RequestBody Paises pais ){
        return service.editar( pais, id );
    }
}
