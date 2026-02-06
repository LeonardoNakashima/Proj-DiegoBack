package org.example.apidiogo.Dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public class DisciplinaRequestDto {
    private String nome;

    @Valid
    @NotNull(message = "Nome não pode ser nulo")
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
