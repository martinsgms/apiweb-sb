/**
 * 
 */
package br.com.martins.apiweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.martins.apiweb.ws.model.Estado;

public interface EstadoRepository extends JpaRepository<Estado, Integer> {

}
