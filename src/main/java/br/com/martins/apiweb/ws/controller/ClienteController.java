package br.com.martins.apiweb.ws.controller;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.martins.apiweb.ws.model.Cliente;
import br.com.martins.apiweb.ws.service.ClienteServices;

@RestController
public class ClienteController {
    
    @Autowired
    private ClienteServices clienteServices;
    
    //End Points
    @RequestMapping(method=RequestMethod.POST, value="/clientes", consumes=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Cliente> create(@RequestBody Cliente cliente) {
        Cliente retorno = clienteServices.gravar(cliente);
        return new ResponseEntity<>(retorno, HttpStatus.CREATED);
    }
    
    @RequestMapping(method=RequestMethod.GET, value="/clientes", produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Collection<Cliente>> findAll() {
        Collection<Cliente> retorno = clienteServices.buscarTodos();
        return new ResponseEntity<>(retorno, HttpStatus.OK);
    }
    
    @RequestMapping(method=RequestMethod.GET, value="/clientes/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Optional<Cliente>> findById(@PathVariable Integer id) {
        Optional<Cliente> retorno = clienteServices.buscar(id);
        if (!retorno.isPresent()) 
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        
        return new ResponseEntity<>(retorno, HttpStatus.OK);
    }
    
    @RequestMapping(method=RequestMethod.PUT, value="/clientes", consumes=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Cliente> update(@RequestBody Cliente cliente) {
        if(clienteServices.buscar(cliente.getId()) == null) 
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        clienteServices.gravar(cliente);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @RequestMapping(method=RequestMethod.DELETE, value="/clientes/{id}")
    public ResponseEntity<Cliente> delete(@PathVariable Integer id) {
        if(clienteServices.buscar(id) == null) 
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        
        clienteServices.remove(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
