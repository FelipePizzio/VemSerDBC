package br.com.dbccompany.coworking.Controller;

import br.com.dbccompany.coworking.Entity.TipoContatoEntity;
import br.com.dbccompany.coworking.Service.TipoContatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/tipo_contato")
public class TipoContatoController {

    @Autowired
    TipoContatoService service;

    @GetMapping(value = "/todos")
    @ResponseBody
    public List<TipoContatoEntity> todosTipoContato(){
        return service.todosTipoContato();
    }

    @PostMapping(value = "/novo")
    @ResponseBody
    public TipoContatoEntity novoTipoContato(@RequestBody TipoContatoEntity tipoContato){
        return service.salvar(tipoContato);
    }

    @PutMapping(value = "/editar/{id}")
    @ResponseBody
    public TipoContatoEntity editarTipoContato(@PathVariable Integer id, @RequestBody TipoContatoEntity tipoContato){
        return service.editar(tipoContato, id);
    }
}
