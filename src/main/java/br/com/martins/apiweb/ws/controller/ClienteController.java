package br.com.martins.apiweb.ws.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.martins.apiweb.ws.model.Cliente;

@RestController
public class ClienteController {

    private Map<Integer, Cliente> clientes = new HashMap<>();
    Integer proximoId = 1;
    
    //End Points
    @RequestMapping(method=RequestMethod.POST, value="/clientes", consumes=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Cliente> create(@RequestBody Cliente cliente) {
        Cliente retorno = cadastro(cliente);
        return new ResponseEntity<>(retorno, HttpStatus.CREATED);
    }
    
    @RequestMapping(method=RequestMethod.GET, value="/clientes", produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Collection<Cliente>> findAll() {
        Collection<Cliente> retorno = buscarTodos();
        return new ResponseEntity<>(retorno, HttpStatus.OK);
    }
    
    @RequestMapping(method=RequestMethod.GET, value="/clientes/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Cliente> findById(@PathVariable Integer id) {
        Cliente retorno = buscar(id);
        if (retorno == null) 
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        
        return new ResponseEntity<>(retorno, HttpStatus.OK);
    }
    
    @RequestMapping(method=RequestMethod.PUT, value="/clientes", consumes=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Cliente> update(@RequestBody Cliente cliente) {
        if(buscar(cliente.getId()) == null) 
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        alterar(cliente);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @RequestMapping(method=RequestMethod.DELETE, value="/clientes/{id}")
    public ResponseEntity<Cliente> delete(@PathVariable Integer id) {
        if(buscar(id) == null) 
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        
        remove(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    //Business 
    private Cliente cadastro(Cliente cliente) {
        cliente.setId(proximoId++);
        clientes.put(cliente.getId(), cliente);
        
        return cliente;
    }
    
    private Collection<Cliente> buscarTodos() {
        return clientes.values();
    }
    
    private Cliente buscar(Integer id) {
        Cliente retorno = clientes.get(id);
        return (retorno != null)? retorno : null;
    }
    
    private void remove(Integer id) {
        clientes.remove(id);
    }
    
    private void alterar(Cliente cliente) {
        clientes.put(cliente.getId(), cliente);
    }
}
