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

import br.com.martins.apiweb.ws.model.Estado;
import br.com.martins.apiweb.ws.service.EstadoServices;

@RestController
public class EstadoController {
    
    @Autowired
    private EstadoServices estadoServices;
    
    @RequestMapping(method=RequestMethod.POST, value="/estados", consumes=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Estado> save(@RequestBody Estado estado) {
        Estado retorno = estadoServices.save(estado);
        return new ResponseEntity<>(retorno, HttpStatus.CREATED);
    }
    
    @RequestMapping(method=RequestMethod.GET, value="/estados", produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Collection<Estado>> findAll() {
        Collection<Estado> retorno = estadoServices.findAll();
        return new ResponseEntity<>(retorno, HttpStatus.OK);
    }
    
    @RequestMapping(method=RequestMethod.GET, value="/estados/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Optional<Estado>> findById(@PathVariable Integer id) {
        Optional<Estado> retorno = estadoServices.findById(id);
        
        return (retorno.isPresent()) ? new ResponseEntity<>(retorno, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
    @RequestMapping(method=RequestMethod.PUT, value="/estados", consumes=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Estado> update(@RequestBody Estado estado) {
        Optional<Estado> retorno = estadoServices.findById(estado.getId());
        
        if (!retorno.isPresent())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        
        estadoServices.save(estado);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @RequestMapping(method=RequestMethod.DELETE, value="/estados/{id}")
    public ResponseEntity<Estado> delete(@PathVariable Integer id) {
        Optional<Estado> retorno = estadoServices.findById(id);
        
        if (!retorno.isPresent())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        
        estadoServices.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

