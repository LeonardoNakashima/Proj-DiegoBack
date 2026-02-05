package org.example.apidiogo.Dto;

public class AdminResponseDto {
    private Long id;
    private String usuario;

    public AdminResponseDto() {}

    public AdminResponseDto(Long id, String usuario) {
        this.id = id;
        this.usuario = usuario;
    }

    public Long getId() {
        return id;
    }
    public String getUsuario() {
        return usuario;
    }

}
