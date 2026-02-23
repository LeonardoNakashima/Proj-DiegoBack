package org.example.apidiogo.Service;

import org.example.apidiogo.Dto.*;
import org.example.apidiogo.Exception.AdminNotFoundException;
import org.example.apidiogo.Exception.BoletimNotFoundException;
import org.example.apidiogo.Model.Admin;
import org.example.apidiogo.Model.Boletim;
import org.example.apidiogo.Model.Disciplina;
import org.example.apidiogo.Repository.BoletimRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BoletimService {

    private final BoletimRepository boletimRepository;

    public BoletimService(BoletimRepository boletimRepository) {
        this.boletimRepository = boletimRepository;
    }

    private Boletim fromRequestDTO(BoletimRequestDto dto) {
        Boletim boletim = new Boletim();
        boletim.setId_aluno(dto.getId_aluno());
        boletim.setId_professor(dto.getId_professor());
        boletim.setN1(dto.getN1());
        boletim.setN2(dto.getN2());
        boletim.setDescricao(dto.getDescricao());
        boletim.setMedia(boletim.calcularMedia());
        return boletim;
    }

    private BoletimResponseDto toResponseDto(Boletim boletim) {
        return new BoletimResponseDto(
                boletim.getId(),
                boletim.getDescricao(),
                boletim.getId_professor(),
                boletim.getId_aluno(),
                boletim.getN1(),
                boletim.getN2(),
                boletim.getMedia()
        );
    }


    public List<BoletimResponseDto> listAll() {
        return boletimRepository.findAll()
                .stream()
                .map(this::toResponseDto)
                .collect(Collectors.toList());
    }

    public List<BoletimResponseDto> listById(Long id) {
        Optional<Boletim> boletim = boletimRepository.findById(id);
        return boletim.stream()
                .map(this::toResponseDto)
                .collect(Collectors.toList());
    }

    public BoletimResponseDto createBoletim(BoletimRequestDto dto) {
        Boletim boletim = fromRequestDTO(dto);
        Boletim salvo = boletimRepository.save(boletim);
        return toResponseDto(salvo);
    }

    public void deleteBoletim(Long id) {
        Boletim boletim = boletimRepository.findById(id)
                .orElseThrow(() -> new BoletimNotFoundException("Boletim com id " + id +" não foi encontrado: 404"));
        boletimRepository.delete(boletim);
    }

}
