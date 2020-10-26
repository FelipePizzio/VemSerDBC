package br.com.dbccompany.bancodigital.Controller;

import br.com.dbccompany.bancodigital.Entity.Agencias;
import br.com.dbccompany.bancodigital.Service.AgenciasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping( "/api/agencia" )
public class AgenciasController {

    @Autowired
    AgenciasService service;

    @GetMapping( value = "/todas" )
    @ResponseBody
    public List<Agencias> todasAgencias(){
        return service.todasAgencias();
    }

    @PostMapping( value = "/nova" )
    @ResponseBody
    public Agencias novaAgencia( @RequestBody Agencias agencia ){
        return service.salvar( agencia );
    }

    @PutMapping( value = "/editar/{id}")
    @ResponseBody
    public Agencias editarAgencia( @PathVariable Integer id, @RequestBody Agencias agencia ){
        return service.editar( agencia, id );
    }
}
