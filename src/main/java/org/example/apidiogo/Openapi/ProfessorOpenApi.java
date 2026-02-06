package org.example.apidiogo.Openapi;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.example.apidiogo.Dto.DisciplinaRequestDto;
import org.example.apidiogo.Dto.DisciplinaResponseDto;
import org.example.apidiogo.Dto.ProfessorRequestDto;
import org.example.apidiogo.Dto.ProfessorResponseDto;
import org.example.apidiogo.Model.Disciplina;
import org.example.apidiogo.Model.Professor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Tag(name = "Professor", description = "Endpoints para gerenciamento dos Professores")
public interface ProfessorOpenApi {

    @Operation(
            summary = "Lista todos os professores",
            description = "Retorna todas os professores cadastrados no sistema."
    )
    ResponseEntity<List<ProfessorResponseDto>> listProfessores();

    @Operation(
            summary = "Lista Professor por id",
            description = "Retorna a Professor com o id."
    )
    ResponseEntity<List<ProfessorResponseDto>> findProfessor(Long id);


    @Operation(
            summary = "Inserir Professor",
            description = "Inserindo Professor no sistema"
    )
    public ResponseEntity<ProfessorResponseDto> createProfessor(@RequestBody @Valid ProfessorRequestDto dto);


    @Operation(
            summary = "Deletar professor",
            description = "excluindo professor do sistema"
    )
    public ResponseEntity<Professor> deleteProfessor(Long id);

}
