package br.com.dbccompany.coworking.Controller;

import br.com.dbccompany.coworking.Entity.ClientePacote;
import br.com.dbccompany.coworking.Service.ClientePacoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping( "/api/cliente_pacote" )
public class ClientePacoteController {

    @Autowired
    ClientePacoteService service;

    @GetMapping(value = "/{id}")
    @ResponseBody
    public ClientePacote clientePacoteEspecifico(@PathVariable Integer id){
        return service.clientePacoteEspecifico(id);
    }

    @GetMapping(value = "/{quantidade}")
    @ResponseBody
    public ClientePacote clientePacoteByQuantidade(@PathVariable Integer quantidade){
        return service.clientePacoteByQuantidade(quantidade);
    }

    @GetMapping(value = "/todos")
    @ResponseBody
    public List<ClientePacote> todosClientePacote(){
        return service.todosClientePacote();
    }

    @PostMapping(value = "/novo")
    @ResponseBody
    public ClientePacote novoClientePacote(@RequestBody ClientePacote clientePacote){
        return service.salvar(clientePacote);
    }

    @PutMapping(value = "/editar/{id}")
    @ResponseBody
    public ClientePacote editarClientePacote(@PathVariable Integer id, @RequestBody ClientePacote clientePacote){
        return service.editar(clientePacote, id );
    }
}
