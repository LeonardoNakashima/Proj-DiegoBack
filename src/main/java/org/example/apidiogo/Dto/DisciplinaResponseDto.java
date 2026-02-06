package org.example.apidiogo.Dto;

public class DisciplinaResponseDto {
    private Long id;
    private String nome;

    public DisciplinaResponseDto(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }
    public DisciplinaResponseDto() {}

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
}
