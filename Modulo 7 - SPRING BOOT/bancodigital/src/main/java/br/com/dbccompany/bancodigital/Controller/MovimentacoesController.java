package br.com.dbccompany.bancodigital.Controller;

import br.com.dbccompany.bancodigital.Entity.Movimentacoes;
import br.com.dbccompany.bancodigital.Service.MovimentacoesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping( "/api/movimentacao" )
public class MovimentacoesController {

    @Autowired
    MovimentacoesService service;

    @GetMapping( value = "/todos")
    @ResponseBody
    public List<Movimentacoes> todasMovimentacoes(){
        return service.todasMovimentacoes();
    }

    @PostMapping( value = "/novo")
    @ResponseBody
    public Movimentacoes novaMovimentacao( @RequestBody Movimentacoes movimentacao ){
        return service.salvar( movimentacao );
    }

    @PutMapping( value = "/editar/{id}" )
    @ResponseBody
    public Movimentacoes editarMovimentacao( @PathVariable Integer id, @RequestBody Movimentacoes movimentacao ){
        return service.editar( movimentacao, id );
    }
}
