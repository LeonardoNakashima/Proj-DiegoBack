package org.example.apidiogo.Dto;

public class BoletimResponseDto {

    private Long id;
    private String descricao;
    private Long id_professor;
    private Long id_aluno;
    private Double n1;
    private Double n2;
    private Double media;

    public BoletimResponseDto() {}

    public BoletimResponseDto(Long id, String descricao, Long id_professor, Long id_aluno, Double n1, Double n2, Double media) {
        this.id = id;
        this.descricao = descricao;
        this.id_professor = id_professor;
        this.id_aluno = id_aluno;
        this.n1 = n1;
        this.n2 = n2;
        this.media = media;
    }

    public Long getId() {
        return id;
    }
    public String getDescricao() {
        return descricao;
    }
    public Long getId_professor() {
        return id_professor;
    }
    public Long getId_aluno() {
        return id_aluno;
    }

    public Double getN1() {
        return n1;
    }
    public Double getN2() {
        return n2;
    }
    public Double getMedia() {
        return media;
    }
}
