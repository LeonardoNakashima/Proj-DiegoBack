package org.example.apidiogo.Controller;

import jakarta.validation.Valid;
import org.example.apidiogo.Dto.AlunoRequestDto;
import org.example.apidiogo.Dto.AlunoResponseDto;
import org.example.apidiogo.Model.Aluno;
import org.example.apidiogo.Openapi.AlunoOpenApi;
import org.example.apidiogo.Repository.AlunoRepository;
import org.example.apidiogo.Service.AlunoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/aluno")
public class AlunoController implements AlunoOpenApi {

    private final AlunoService service;

    public AlunoController(AlunoService service) {
        this.service = service;
    }

    @GetMapping("/list")
    public ResponseEntity<List<AlunoResponseDto>> listAlunos() {
        List<AlunoResponseDto> alunos = service.listAll();
        return ResponseEntity.ok(alunos);
    }


    @GetMapping("/findAluno/{matricula}")
    public ResponseEntity<List<AlunoResponseDto>> findAluno(@PathVariable Long matricula) {
        return ResponseEntity.ok(service.listByMatricula(matricula));
    }


    @PostMapping("/create")
    public ResponseEntity<AlunoResponseDto> createAluno(@RequestBody @Valid AlunoRequestDto dto) {
        AlunoResponseDto response = service.createAluno(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @DeleteMapping("/delete/{matricula}")
    public ResponseEntity<Aluno> deleteAluno(@PathVariable Long matricula) {
        service.deleteAluno(matricula);
        return ResponseEntity.noContent().build();
    }


}
