package org.example.apidiogo.Dto;

import jakarta.validation.Valid;

public class BoletimRequestDto {

    @Valid
    private String descricao;

    @Valid
    private Long id_professor;

    @Valid
    private Long id_aluno;

    @Valid
    private Double n1;

    @Valid
    private Double n2;

    @Valid
    private Double media;


    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Long getId_professor() {
        return id_professor;
    }

    public void setId_professor(Long id_professor) {
        this.id_professor = id_professor;
    }

    public Long getId_aluno() {
        return id_aluno;
    }

    public void setId_aluno(Long id_aluno) {
        this.id_aluno = id_aluno;
    }

    public Double getN1() {
        return n1;
    }

    public void setN1(Double n1) {
        this.n1 = n1;
    }

    public Double getN2() {
        return n2;
    }

    public void setN2(Double n2) {
        this.n2 = n2;
    }

    public Double getMedia() {
        return media;
    }
    public void setMedia(Double media) {
        this.media = media;
    }
}
