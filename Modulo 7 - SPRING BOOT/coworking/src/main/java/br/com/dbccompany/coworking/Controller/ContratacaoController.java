package br.com.dbccompany.coworking.Controller;

import br.com.dbccompany.coworking.Entity.ContratacaoEntity;
import br.com.dbccompany.coworking.Service.ContratacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/contratação")
public class ContratacaoController {

    @Autowired
    ContratacaoService service;

    @GetMapping(value = "/todas")
    @ResponseBody
    public List<ContratacaoEntity> todasContratacoes(){
        return service.todasContratacoes();
    }

    @PostMapping(value = "/nova")
    @ResponseBody
    public ContratacaoEntity novaContratacao(@RequestBody ContratacaoEntity contratacao){
        return service.salvar(contratacao);
    }

    @PutMapping(value = "/editar/{id}")
    @ResponseBody
    public ContratacaoEntity editarContratacao(@PathVariable Integer id, @RequestBody ContratacaoEntity contratacao){
        return service.editar(contratacao, id);
    }
}
