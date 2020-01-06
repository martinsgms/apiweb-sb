package br.com.martins.apiweb.ws.service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.martins.apiweb.repository.ClienteRepository;
import br.com.martins.apiweb.ws.model.Cliente;

@Service
public class ClienteServices {
    
    @Autowired
    private ClienteRepository clienteRepository;
    
    //Business 
    public Cliente gravar(Cliente cliente) {
        return clienteRepository.save(cliente);
    }
    
    public Collection<Cliente> buscarTodos() {
        return clienteRepository.findAll();
    }
    
    public Optional<Cliente> buscar(Integer id) {
        return clienteRepository.findById(id);
    }
    
    public void remove(Integer id) {
        clienteRepository.deleteById(id);
    }
}
