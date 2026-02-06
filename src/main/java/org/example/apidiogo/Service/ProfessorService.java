package org.example.apidiogo.Service;
import org.example.apidiogo.Dto.ProfessorRequestDto;
import org.example.apidiogo.Dto.ProfessorResponseDto;
import org.example.apidiogo.Exception.ProfessorNotFoundException;
import org.example.apidiogo.Model.Professor;
import org.example.apidiogo.Repository.ProfessorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProfessorService {

    private final ProfessorRepository professorRepository;

    public ProfessorService(ProfessorRepository professorRepository) {
        this.professorRepository = professorRepository;
    }

    private Professor fromRequestDTO(ProfessorRequestDto dto) {
        Professor professor = new Professor();
        professor.setNome(dto.getNome());
        professor.setUsuario(dto.getUsuario());
        professor.setSenha(dto.getSenha());
        return professor;
    }

    private ProfessorResponseDto toResponseDto(Professor professor) {
        return new ProfessorResponseDto(
                professor.getId(),
                professor.getNome(),
                professor.getUsuario()
        );
    }

    public List<ProfessorResponseDto> listAll() {
        return professorRepository.findAll()
                .stream()
                .map(this::toResponseDto)
                .collect(Collectors.toList());
    }

    public List<ProfessorResponseDto> listById(Long id) {
        Optional<Professor> professor = professorRepository.findById(id);
        return professor.stream()
                .map(this::toResponseDto)
                .collect(Collectors.toList());
    }


    public ProfessorResponseDto createProfessor(ProfessorRequestDto dto) {
        Professor professor = fromRequestDTO(dto);
        Professor salvo = professorRepository.save(professor);
        return toResponseDto(salvo);
    }

    public void deleteProfessor(Long id) {
        Professor professor = professorRepository.findById(id)
                .orElseThrow(() -> new ProfessorNotFoundException("Professor com id " + id +" não foi encontrado: 404"));
        professorRepository.delete(professor);
    }
}
