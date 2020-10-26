package br.com.dbccompany.ProjetoFinal.Controller;

import br.com.dbccompany.ProjetoFinal.Document.Candidato;
import br.com.dbccompany.ProjetoFinal.Service.CandidatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/candidatos")
public class CandidatoController {

    @Autowired
    CandidatoService service;

    @PostMapping(value = "/salvar/novo")
    @ResponseBody
    public Candidato novoCandidato(@RequestBody Candidato candidato){
        return service.salvar(candidato);
    }

    @PutMapping(value = "/editar/{id}")
    @ResponseBody
    public Candidato editarCandidato(@PathVariable String id, @RequestBody Candidato candidato){
        return service.editar(candidato, id);
    }

    @RequestMapping(value = "/deletar/{id}",method = RequestMethod.DELETE)
    @ResponseBody
    public Boolean deletarCandidato(@PathVariable String id){
        service.deletar(id);
        return true;
    }

    @GetMapping(value = "/buscar-todos")
    @ResponseBody
    public List<Candidato> todosCandidatos(){
        return service.todosCandidatos();
    }

    @GetMapping(value = "/buscar-por-id/{id}")
    @ResponseBody
    public Candidato candidatoEspecifico(@PathVariable String id){
        return service.candidatoEspecifico(id);
    }

    @GetMapping(value = "/buscar-por-nome/{nome}")
    @ResponseBody
    public List<Candidato> buscarPorNome(@PathVariable String nome){
        return service.buscarPorNome(nome);
    }

    @GetMapping(value = "/buscar-por-vaga/{codigo}")
    @ResponseBody
    public List<Candidato> buscarPorCodigoVaga(@PathVariable String codigo){
        return service.buscarPorCodigoVaga(codigo);
    }
}
