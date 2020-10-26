package br.com.dbccompany.bancodigital.Controller;

import br.com.dbccompany.bancodigital.Entity.TipoConta;
import br.com.dbccompany.bancodigital.Service.TipoContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping( "/api/tipoconta" )
public class TipoContaController {

    @Autowired
    TipoContaService service;

    @GetMapping( value = "/todos")
    @ResponseBody
    public List<TipoConta> todosTipoConta(){
        return service.todosTipoConta();
    }

    @PostMapping( value = "/novo")
    @ResponseBody
    public TipoConta novoTipoConta( @RequestBody TipoConta tipoConta ){
        return service.salvar( tipoConta );
    }

    @PutMapping( value = "/editar/{id}" )
    @ResponseBody
    public TipoConta editarTipoConta( @PathVariable Integer id, @RequestBody TipoConta tipoConta ){
        return service.editar( tipoConta, id );
    }
}
