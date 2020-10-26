package br.com.dbccompany.bancodigital.Controller;

import br.com.dbccompany.bancodigital.Entity.Bancos;
import br.com.dbccompany.bancodigital.Service.BancosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping( "/api/banco" )
public class BancosController {

    @Autowired
    BancosService service;

    @GetMapping( value = "/todos")
    @ResponseBody
    public List<Bancos> todosBancos(){
        return service.todosBancos();
    }

    @PostMapping( value = "/novo")
    @ResponseBody
    public Bancos novoBanco( @RequestBody Bancos banco ){
        return service.salvar( banco );
    }

    @PutMapping( value = "/editar/{id}" )
    @ResponseBody
    public Bancos editarBanco( @PathVariable Integer id, @RequestBody Bancos banco ) {
        return service.editar( banco, id );
    }
}
