package org.example.apidiogo.Openapi;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.apidiogo.Dto.AlunoResponseDto;
import org.springframework.http.ResponseEntity;

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

}
