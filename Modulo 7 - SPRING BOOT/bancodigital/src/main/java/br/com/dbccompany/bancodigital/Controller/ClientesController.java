package br.com.dbccompany.bancodigital.Controller;

import br.com.dbccompany.bancodigital.Entity.Clientes;
import br.com.dbccompany.bancodigital.Service.ClientesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping( "/api/cliente" )
public class ClientesController {

    @Autowired
    ClientesService service;

    @GetMapping( value = "/todos")
    @ResponseBody
    public List<Clientes> todosClientes(){
        return service.todosClientes();
    }

    @PostMapping( value = "/novo")
    @ResponseBody
    public Clientes novoCliente( @RequestBody Clientes cliente ){
        return service.salvar( cliente );
    }

    @PutMapping( value = "/editar/{id}" )
    @ResponseBody
    public Clientes editarCliente( @PathVariable Integer id, @RequestBody Clientes cliente ){
        return service.editar( cliente, id );
    }
}
