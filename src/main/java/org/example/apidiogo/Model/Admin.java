package org.example.apidiogo.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;


@Entity
public class Admin {

    @Id
    private Long id;

    private String email;

    private String senha;

    public Admin() {

    }

    public Admin(Long id, String email, String senha) {
        this.email = email;
        this.senha = senha;
    }


    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }


}
