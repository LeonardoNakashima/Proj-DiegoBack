package org.example.apidiogo.Openapi;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.example.apidiogo.Dto.BoletimRequestDto;
import org.example.apidiogo.Dto.BoletimResponseDto;
import org.example.apidiogo.Model.Boletim;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Tag(name = "Boletim", description = "Endpoints para gerenciamento dos Boletins")
public interface BoletimOpenApi {


    @Operation(
            summary = "Lista todos os Boletins",
            description = "Retorna todos os Boletins cadastrados no sistema."
    )
    public ResponseEntity<List<BoletimResponseDto>> listBoletins();


    @Operation(
            summary = "Buscar Boletim por id",
            description = "Retorna o Boletim pelo id."
    )
    public ResponseEntity<List<BoletimResponseDto>> findBoletim(@PathVariable Long id) ;

    @Operation(
            summary = "Inserir Boletim",
            description = "Inserindo boletim no sistema"
    )
    public ResponseEntity<BoletimResponseDto> createBoletim(@RequestBody @Valid BoletimRequestDto dto) ;


    @Operation(
            summary = "Deletar boletim",
            description = "excluindo boletim do sistema"
    )
    public ResponseEntity<Boletim> deleteBoletim(@PathVariable Long id);
    }
