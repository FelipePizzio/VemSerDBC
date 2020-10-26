package br.com.dbccompany.coworking.Controller;

import br.com.dbccompany.coworking.Entity.PagamentoEntity;
import br.com.dbccompany.coworking.Service.PagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/pagamento")
public class PagamentoController {

    @Autowired
    PagamentoService service;

    @GetMapping(value = "/todos")
    @ResponseBody
    public List<PagamentoEntity> todosPagamentos(){
        return service.todosPagamentos();
    }

    @PostMapping(value = "/novo")
    @ResponseBody
    public PagamentoEntity novoPagamento(@RequestBody PagamentoEntity pagamento){
        return service.salvar(pagamento);
    }

    @PutMapping(value = "/editar/{id}")
    @ResponseBody
    public PagamentoEntity editarPagamento(@PathVariable Integer id, @RequestBody PagamentoEntity pagamento){
        return service.editar(pagamento, id);
    }
}
