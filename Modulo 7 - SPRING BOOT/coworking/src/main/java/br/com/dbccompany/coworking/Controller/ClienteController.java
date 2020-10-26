package br.com.dbccompany.coworking.Controller;

import br.com.dbccompany.coworking.Entity.ClienteEntity;
import br.com.dbccompany.coworking.Service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/api/cliente")
public class ClienteController {

    @Autowired
    ClienteService service;

    @GetMapping(value = "/{id}")
    @ResponseBody
    public ClienteEntity clienteEspecifico(@PathVariable Integer id){
        return service.clienteEspecifico(id);
    }

    @GetMapping(value = "/{nome}")
    @ResponseBody
    public ClienteEntity clienteByNome(@PathVariable String nome){
        return service.clienteByNome(nome);
    }

    @GetMapping(value = "/{cpf}")
    @ResponseBody
    public ClienteEntity clienteByCpf(@PathVariable Integer cpf){
        return service.clienteByCpf(cpf);
    }

    @GetMapping(value = "/{data}")
    @ResponseBody
    public ClienteEntity clienteByDataNascimento(@PathVariable LocalDate dataNascimento){
        return service.clienteByDataNascimento(dataNascimento);
    }

    @GetMapping(value = "/todos")
    @ResponseBody
    public List<ClienteEntity> todosClientes(){
        return service.todosClientes();
    }

    @PostMapping(value = "/novo")
    @ResponseBody
    public ClienteEntity novoCliente(@RequestBody ClienteEntity cliente){
        return service.salvar(cliente);
    }

    @PutMapping(value = "/editar/{id}")
    @ResponseBody
    public ClienteEntity editarCliente(@PathVariable Integer id, @RequestBody ClienteEntity cliente){
        return service.editar(cliente, id );
    }
}
