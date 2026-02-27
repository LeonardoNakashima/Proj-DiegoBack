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


    public @Size(min = 3, message = "O nome deve ter 3 ou mais caracteres") @Valid String getNome() {
        return nome;
    }

    public void setNome(@Size(min = 3, message = "O nome deve ter 3 ou mais caracteres") @Valid String nome) {
        this.nome = nome;
    }

    public @Email @Valid String getEmail() {
        return email;
    }

    public void setEmail(@Email @Valid String email) {
        this.email = email;
    }

    public @Size(min = 8, message = "Senha deve ter mais de 8 caracteres") @NotNull(message = "Senha não pode ser nula") @Valid String getSenha() {
        return senha;
    }

    public void setSenha(@Size(min = 8, message = "Senha deve ter mais de 8 caracteres") @NotNull(message = "Senha não pode ser nula") @Valid String senha) {
        this.senha = senha;
    }
}
