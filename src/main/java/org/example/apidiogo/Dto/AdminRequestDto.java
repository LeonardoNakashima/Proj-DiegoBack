package org.example.apidiogo.Dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class AdminRequestDto {

    @Valid
    @NotNull(message = "usuario não pode ser nula")
    @Size(min = 3, message = "O nome do admin deve ter 3 ou mais caracteres")
    private String usuario;

    @Valid
    @NotNull(message = "Senha não pode ser nula")
    @Size(min = 8, message = "Senha deve ter mais de 8 caracteres")
    private String senha;

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
