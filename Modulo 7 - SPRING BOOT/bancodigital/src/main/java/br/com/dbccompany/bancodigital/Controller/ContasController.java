package br.com.dbccompany.bancodigital.Controller;

import br.com.dbccompany.bancodigital.Entity.Contas;
import br.com.dbccompany.bancodigital.Service.ContasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping( "/api/conta" )
public class ContasController {

    @Autowired
    ContasService service;

    @GetMapping( value = "/todos")
    @ResponseBody
    public List<Contas> todasContas(){
        return service.todasContas();
    }

    @PostMapping( value = "/novo")
    @ResponseBody
    public Contas novaConta( @RequestBody Contas conta ){
        return service.salvar( conta );
    }

    @PutMapping( value = "/editar/{id}" )
    @ResponseBody
    public Contas editarConta( @PathVariable Integer id, @RequestBody Contas conta ){
        return service.editar( conta, id );
    }
}
