package org.example.apidiogo.Dto;

public class ProfessorResponseDto {

    private Long id;

    private String nome;

    private String usuario;

    public ProfessorResponseDto() {}

    public ProfessorResponseDto(Long id, String nome, String usuario) {
        this.id = id;
        this.nome = nome;
        this.usuario = usuario;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getUsuario() {
        return usuario;
    }
}
