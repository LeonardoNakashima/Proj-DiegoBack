package org.example.apidiogo.Dto;

public class AlunoResponseDto {

    private Long matricula;
    private String nome;
    private String email;

    public AlunoResponseDto() {}

    public AlunoResponseDto(Long matricula, String nome, String email) {
        this.matricula = matricula;
        this.nome = nome;
        this.email = email;
    }

    public Long getMatricula() {
        return matricula;
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


}
