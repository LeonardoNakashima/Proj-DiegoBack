package org.example.apidiogo.Dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class AlunoRequestDto {

    @Size(min = 3, message = "O nome deve ter 3 ou mais caracteres")
    @Valid
    private String nome;

    @Email
    @Valid
    private String email;

    @Size(min = 8, message = "Senha deve ter mais de 8 caracteres")
    @NotNull(message = "Senha não pode ser nula")
    @Valid
    private String senha;


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

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
