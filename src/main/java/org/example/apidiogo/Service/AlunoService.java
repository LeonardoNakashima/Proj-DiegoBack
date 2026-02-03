package org.example.apidiogo.Service;

import ch.qos.logback.core.pattern.util.AlmostAsIsEscapeUtil;
import org.example.apidiogo.Dto.AlunoRequestDto;
import org.example.apidiogo.Dto.AlunoResponseDto;
import org.example.apidiogo.Model.Aluno;
import org.example.apidiogo.Repository.AlunoRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AlunoService {

    private final AlunoRepository alunoRepository;

    public AlunoService(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }


    private Aluno fromRequestDTO(AlunoRequestDto dto) {
        Aluno aluno = new Aluno();
        aluno.setNome(dto.getNome());
        aluno.setEmail(dto.getEmail());
        return aluno;
    }

    private AlunoResponseDto toResponseDto(Aluno aluno) {
        return new AlunoResponseDto(
                aluno.getMatricula(),
                aluno.getNome(),
                aluno.getEmail()
        );
    }



    public List<AlunoResponseDto> listAll() {
        return alunoRepository.findAll()
                .stream()
                .map(this::toResponseDto)
                .collect(Collectors.toList());
    }


    public List<AlunoResponseDto> listByMatricula(Long matricula) {
        Optional<Aluno> aluno = alunoRepository.findAlunoByMatricula(matricula);
        return aluno.stream()
                .map(this::toResponseDto)
                .collect(Collectors.toList());    }

}
