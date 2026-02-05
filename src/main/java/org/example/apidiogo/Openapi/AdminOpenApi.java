package org.example.apidiogo.Openapi;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.example.apidiogo.Dto.AdminRequestDto;
import org.example.apidiogo.Dto.AdminResponseDto;
import org.example.apidiogo.Dto.AlunoRequestDto;
import org.example.apidiogo.Dto.AlunoResponseDto;
import org.example.apidiogo.Model.Admin;
import org.example.apidiogo.Model.Aluno;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Tag(name = "Admin", description = "Endpoints para gerenciamento dos Admins")
public interface AdminOpenApi {

    @Operation(
            summary = "Lista todos os Admins",
            description = "Retorna todos os Admins cadastrados no sistema."
    )
    ResponseEntity<List<AdminResponseDto>> listAdmins();

    @Operation(
            summary = "Lista admin por id",
            description = "Retorna o Admin com o id."
    )
    ResponseEntity<List<AdminResponseDto>> findAdmin(Long id);


    @Operation(
            summary = "Inserir admin",
            description = "Inserindo admin no sistema"
    )
    public ResponseEntity<AdminResponseDto> createAdmin(@RequestBody @Valid AdminRequestDto dto);


    @Operation(
            summary = "Deletar admin",
            description = "excluindo admin do sistema"
    )
    public ResponseEntity<Admin> deleteAdmin(Long id);

}
