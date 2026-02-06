package org.example.apidiogo.Controller;

import jakarta.validation.Valid;
import org.example.apidiogo.Dto.DisciplinaRequestDto;
import org.example.apidiogo.Dto.DisciplinaResponseDto;
import org.example.apidiogo.Dto.ProfessorRequestDto;
import org.example.apidiogo.Dto.ProfessorResponseDto;
import org.example.apidiogo.Model.Disciplina;
import org.example.apidiogo.Model.Professor;
import org.example.apidiogo.Openapi.ProfessorOpenApi;
import org.example.apidiogo.Service.ProfessorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/professor")
public class ProfessorController implements ProfessorOpenApi {

    private final ProfessorService service;

    public ProfessorController(ProfessorService service) {
        this.service = service;
    }

    @GetMapping("/list")
    public ResponseEntity<List<ProfessorResponseDto>> listProfessores() {
        List<ProfessorResponseDto> professores = service.listAll();
        return ResponseEntity.ok(professores);
    }


    @GetMapping("/findProfessor/{id}")
    public ResponseEntity<List<ProfessorResponseDto>> findProfessor(@PathVariable Long id) {
        return ResponseEntity.ok(service.listById(id));
    }


    @PostMapping("/create")
    public ResponseEntity<ProfessorResponseDto> createProfessor(@RequestBody @Valid ProfessorRequestDto dto) {
       ProfessorResponseDto response = service.createProfessor(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Professor> deleteProfessor(@PathVariable Long id) {
        service.deleteProfessor(id);
        return ResponseEntity.noContent().build();
    }
}
