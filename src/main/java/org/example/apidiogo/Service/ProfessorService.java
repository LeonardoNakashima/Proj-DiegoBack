package org.example.apidiogo.Service;
import org.example.apidiogo.Dto.ProfessorRequestDto;
import org.example.apidiogo.Dto.ProfessorResponseDto;
import org.example.apidiogo.Exception.ProfessorNotFoundException;
import org.example.apidiogo.Model.Professor;
import org.example.apidiogo.Repository.ProfessorRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProfessorService {

    private final ProfessorRepository professorRepository;
    private final PasswordEncoder passwordEncoder;

    public ProfessorService(
            ProfessorRepository professorRepository,
            PasswordEncoder passwordEncoder
    ) {
        this.professorRepository = professorRepository;
        this.passwordEncoder = passwordEncoder;
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
                .toList();
    }

    public void deleteProfessor(Long id) {
        Professor professor = professorRepository.findById(id)
                .orElseThrow(() ->
                        new ProfessorNotFoundException("Professor não encontrado")
                );
        professorRepository.delete(professor);
    }

    public ProfessorResponseDto inserirProfessor(ProfessorRequestDto request) {

        String senhaCriptografada =
                passwordEncoder.encode(request.getSenha());

        professorRepository.inserirProfessorComDisciplina(
                request.getNome(),
                request.getUsuario(),
                senhaCriptografada,
                request.getDisciplina()
        );

        Professor professor =
                professorRepository.findByUsuario(request.getUsuario())
                        .orElseThrow();

        return toResponseDto(professor);
    }
}

