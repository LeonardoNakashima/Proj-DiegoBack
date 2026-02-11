package org.example.apidiogo.Controller;

import jakarta.validation.Valid;
import org.example.apidiogo.Dto.AdminRequestDto;
import org.example.apidiogo.Dto.AdminResponseDto;
import org.example.apidiogo.Dto.BoletimRequestDto;
import org.example.apidiogo.Dto.BoletimResponseDto;
import org.example.apidiogo.Model.Admin;
import org.example.apidiogo.Model.Boletim;
import org.example.apidiogo.Service.BoletimService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/boletim")
public class BoletimController {

    private final BoletimService service;
    public BoletimController(BoletimService service) {
        this.service = service;
    }

    @GetMapping("/list")
    public ResponseEntity<List<BoletimResponseDto>> listBoletins() {
        List<BoletimResponseDto> boletins = service.listAll();
        return ResponseEntity.ok(boletins);
    }

    @GetMapping("/findBoletim/{id}")
    public ResponseEntity<List<BoletimResponseDto>> findBoletim(@PathVariable Long id) {
        return ResponseEntity.ok(service.listById(id));
    }

    @PostMapping("/create")
    public ResponseEntity<BoletimResponseDto> createBoletim(@RequestBody @Valid BoletimRequestDto dto) {
        BoletimResponseDto response = service.createBoletim(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boletim> deleteBoletim(@PathVariable Long id) {
        service.deleteBoletim(id);
        return ResponseEntity.noContent().build();
    }



}
