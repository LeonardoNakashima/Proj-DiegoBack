package org.example.apidiogo.Controller;

import jakarta.validation.Valid;
import org.example.apidiogo.Dto.AdminRequestDto;
import org.example.apidiogo.Dto.AdminResponseDto;
import org.example.apidiogo.Dto.DisciplinaRequestDto;
import org.example.apidiogo.Dto.DisciplinaResponseDto;
import org.example.apidiogo.Model.Admin;
import org.example.apidiogo.Model.Disciplina;
import org.example.apidiogo.Service.AdminService;
import org.example.apidiogo.Service.DisciplinaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/disciplina")
public class DisciplinaController {

    private final DisciplinaService service;

    public DisciplinaController(DisciplinaService service) {
        this.service = service;
    }

    @GetMapping("/list")
    public ResponseEntity<List<DisciplinaResponseDto>> listDisciplinas() {
        List<DisciplinaResponseDto> disciplinas = service.listAll();
        return ResponseEntity.ok(disciplinas);
    }


    @GetMapping("/findDisciplina/{id}")
    public ResponseEntity<List<DisciplinaResponseDto>> findDisciplina(@PathVariable Long id) {
        return ResponseEntity.ok(service.listById(id));
    }


    @PostMapping("/create")
    public ResponseEntity<DisciplinaResponseDto> createDisciplina(@RequestBody @Valid DisciplinaRequestDto dto) {
        DisciplinaResponseDto response = service.createDisciplina(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Disciplina> deleteDisciplina(@PathVariable Long id) {
        service.deleteDisciplina(id);
        return ResponseEntity.noContent().build();
    }
}
