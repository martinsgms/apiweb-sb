package br.com.martins.apiweb.ws.service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.martins.apiweb.repository.EstadoRepository;
import br.com.martins.apiweb.ws.model.Estado;

@Service
public class EstadoServices {
    
    @Autowired
    private EstadoRepository estadoRepository;
    
    //Business 
    public Estado save(Estado estado) {
        return estadoRepository.save(estado);
    }
    
    public Collection<Estado> findAll() {
        return estadoRepository.findAll();
    }
    
    public Optional<Estado> findById(Integer id) {
        return estadoRepository.findById(id);
    }
    
    public void deleteById(Integer id) {
        estadoRepository.deleteById(id);
    }
}
