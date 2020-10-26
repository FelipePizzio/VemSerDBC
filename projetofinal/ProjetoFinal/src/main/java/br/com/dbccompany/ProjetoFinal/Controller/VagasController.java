package br.com.dbccompany.ProjetoFinal.Controller;

import br.com.dbccompany.ProjetoFinal.Document.Vagas;
import br.com.dbccompany.ProjetoFinal.Service.VagasService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vagas")
public class VagasController {

    @Autowired
    private VagasService service;

    @PutMapping(value = "/editar/{id}")
    @ResponseBody
    public Vagas editarVagas(@PathVariable String id, @RequestBody Vagas vaga){
        return service.editar(vaga,id);
    }

    @GetMapping( value = "/buscar-todos")
    @ResponseBody
    public List<Vagas> buscarTodos() throws JsonProcessingException {
        return service.buscarTodos();
    }

    @GetMapping( value = "/buscar-api" )
    @ResponseBody
    public List<Vagas> buscarApi() throws JsonProcessingException {
        return service.consumerApi();
    }

    @GetMapping( value = "/buscar-por-id/{id}")
    @ResponseBody
    public Vagas buscarPorId( @PathVariable String id ){
        return service.buscarPoriD(id);
    }

    @GetMapping(value = "/buscar-por-titulo/{titulo}")
    @ResponseBody
    public List<Vagas> buscarPorTitulo(@PathVariable String titulo){
        return service.buscarPorTitulo(titulo);
    }

    @GetMapping(value = "/buscar-por-data-de-abertura/{data}")
    @ResponseBody
    public List<Vagas> buscarPorDataDeAbertura(@PathVariable String data){
        return service.buscarPorDataDeAbertura(data);
    }

    @GetMapping(value = "/buscar-por-codigo-da-vaga/{codigo}")
    @ResponseBody
    public List<Vagas>  buscarPorCodigoDaVaga(@PathVariable String codigo){
        return service.buscarPorCodigoDaVaga(codigo);
    }

    @GetMapping(value = "/buscar-por-url/{url}")
    @ResponseBody
    public Vagas buscarPorUrl(@PathVariable String url){
        return service.buscarPorUrl(url);
    }

    @GetMapping(value = "/buscar-por-cidade/{cidade}")
    @ResponseBody
    public List<Vagas> buscarPorCidade(@PathVariable String cidade){
        return service.buscarPorCidade(cidade);
    }

    @GetMapping(value = "/buscar-por-estado/{estado}")
    @ResponseBody
    public List<Vagas> buscarPorEstado(@PathVariable String estado){
        return service.buscarPorEstado(estado);
    }

    @GetMapping(value = "/buscar-por-codigo-filial/{codigo}")
    @ResponseBody
    public List<Vagas> buscarPorCodigoDaFilial(@PathVariable Integer codigo){
        return service.buscarPorCodigoDaFilial(codigo);
    }

    @GetMapping(value = "/buscar-por-nome-filial/{nome}")
    @ResponseBody
    public List<Vagas> buscarPorNomeDaFilial(@PathVariable String nome){
        return service.buscarPorNomeDaFilial(nome);
    }

    @RequestMapping( value = "/deletar/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public Boolean deletar(@PathVariable String id){
        service.delete( id );
        return true;
    }

}
