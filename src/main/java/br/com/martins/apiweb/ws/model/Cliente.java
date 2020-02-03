package br.com.martins.apiweb.ws.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Cliente {
    
    @Id
    @GeneratedValue
    private Integer id;
    private String nome;
    private String email;

    @ManyToOne
    @JoinColumn(name="ID_ESTADO")
    private Estado uf;
    
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public Estado getUf() {
        return uf;
    }
    public void setUf(Estado uf) {
        this.uf = uf;
    }
    
}
