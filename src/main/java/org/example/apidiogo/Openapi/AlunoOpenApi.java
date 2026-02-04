package org.example.apidiogo.Openapi;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.example.apidiogo.Dto.AlunoRequestDto;
import org.example.apidiogo.Dto.AlunoResponseDto;
import org.example.apidiogo.Model.Aluno;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Tag(name = "Aluno", description = "Endpoints para gerenciamento de Alunos")
public interface AlunoOpenApi {

    @Operation(
            summary = "Lista todos os Alunos",
            description = "Retorna todos os Alunos cadastrados no sistema."
    )
    ResponseEntity<List<AlunoResponseDto>> listAlunos();

    @Operation(
            summary = "Lista aluno por Matricula",
            description = "Retorna o Aluno com a matricula."
    )
    ResponseEntity<List<AlunoResponseDto>> findAluno(Long Matricula);


    @Operation(
            summary = "Inserir aluno",
            description = "Inserindo aluno no sistema"
    )
    public ResponseEntity<AlunoResponseDto> createAluno(@RequestBody @Valid AlunoRequestDto dto);


    @Operation(
            summary = "Deletar aluno",
            description = "excluindo aluno do sistema"
    )
    public ResponseEntity<Aluno> deleteAluno(Long Matricula);

}
