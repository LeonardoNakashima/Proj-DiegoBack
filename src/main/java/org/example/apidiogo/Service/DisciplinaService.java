package org.example.apidiogo.Service;

import org.example.apidiogo.Dto.*;
import org.example.apidiogo.Exception.AdminNotFoundException;
import org.example.apidiogo.Exception.DisciplinaNotFoundException;
import org.example.apidiogo.Model.Admin;
import org.example.apidiogo.Model.Aluno;
import org.example.apidiogo.Model.Disciplina;
import org.example.apidiogo.Repository.DisciplinaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DisciplinaService {
    private final DisciplinaRepository disciplinaRepository;

    public DisciplinaService(DisciplinaRepository disciplinaRepository) {
        this.disciplinaRepository = disciplinaRepository;
    }

    private Disciplina fromRequestDTO(DisciplinaRequestDto dto) {
        Disciplina disciplina = new Disciplina();
        disciplina.setNome(dto.getNome());

        return disciplina;
    }

    private DisciplinaResponseDto toResponseDto(Disciplina disciplina) {
        return new DisciplinaResponseDto(
                disciplina.getId(),
                disciplina.getNome()
        );
    }

    public List<DisciplinaResponseDto> listAll() {
        return disciplinaRepository.findAll()
                .stream()
                .map(this::toResponseDto)
                .collect(Collectors.toList());
    }

    public List<DisciplinaResponseDto> listById(Long id) {
        Optional<Disciplina> disciplina = disciplinaRepository.findById(id);
        return disciplina.stream()
                .map(this::toResponseDto)
                .collect(Collectors.toList());
    }


    public DisciplinaResponseDto createDisciplina(DisciplinaRequestDto dto) {
        Disciplina disciplina = fromRequestDTO(dto);
        Disciplina salvo = disciplinaRepository.save(disciplina);
        return toResponseDto(salvo);
    }

    public void deleteDisciplina(Long id) {
        Disciplina disciplina = disciplinaRepository.findById(id)
                .orElseThrow(() -> new DisciplinaNotFoundException("Disciplina com id " + id +" não foi encontrado: 404"));
        disciplinaRepository.delete(disciplina);
    }

    }
