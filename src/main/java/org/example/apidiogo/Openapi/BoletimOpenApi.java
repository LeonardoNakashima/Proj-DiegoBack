package org.example.apidiogo.Openapi;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.apidiogo.Dto.BoletimResponseDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Tag(name = "Boletim", description = "Endpoints para gerenciamento dos Boletins")
public interface BoletimOpenApi {


    @Operation(
            summary = "Lista todos os Boletins",
            description = "Retorna todos os Boletins cadastrados no sistema."
    )
    public ResponseEntity<List<BoletimResponseDto>> listBoletins();


    }
