package br.com.dbccompany.bancodigital.Controller;

import br.com.dbccompany.bancodigital.Entity.Cidades;
import br.com.dbccompany.bancodigital.Service.CidadesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping( "/api/cidade" )
public class CidadesController {

    @Autowired
    CidadesService service;

    @GetMapping( value = "/todos")
    @ResponseBody
    public List<Cidades> todasCidades(){
        return service.todasCidades();
    }

    @PostMapping( value = "/novo")
    @ResponseBody
    public Cidades novaCidade( @RequestBody Cidades cidade ){
        return service.salvar( cidade );
    }

    @PutMapping( value = "/editar/{id}" )
    @ResponseBody
    public Cidades editarCidade( @PathVariable Integer id, @RequestBody Cidades cidade ){
        return service.editar( cidade, id );
    }
}
