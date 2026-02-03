package org.example.apidiogo.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Professor {
    @Id
    private Long id;

    private String nome;

    private Long id_Disciplina;

    private String usuario;

    private String senha;

    public Professor() {}

    public Professor(Long id, String nome, Long id_Disciplina, String usuario, String senha) {
        this.id = id;
        this.nome = nome;
        this.id_Disciplina = id_Disciplina;
        this.usuario = usuario;
        this.senha = senha;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Long getId_Disciplina() {
        return id_Disciplina;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setId_Disciplina(Long id_Disciplina) {
        this.id_Disciplina = id_Disciplina;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
