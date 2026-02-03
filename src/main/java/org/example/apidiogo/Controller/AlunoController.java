package org.example.apidiogo.Controller;

import org.example.apidiogo.Dto.AlunoResponseDto;
import org.example.apidiogo.Openapi.AlunoOpenApi;
import org.example.apidiogo.Repository.AlunoRepository;
import org.example.apidiogo.Service.AlunoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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



}
